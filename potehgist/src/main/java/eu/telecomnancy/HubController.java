package eu.telecomnancy;

import java.io.IOException;
import java.sql.ResultSet;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import eu.telecomnancy.BDD_App.API;
import eu.telecomnancy.Model.Notification;
import eu.telecomnancy.Model.Reservation;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class HubController {

    List<Integer> listevisiteeList = new ArrayList<Integer>();
    List<Integer> listeidnotif = new ArrayList<Integer>();

    @FXML VBox NotifVobx;


    private List<Notification> Notification() throws Exception{
        ResultSet result = API.getInstance().getNotif(App.getUser().getId());
        List<Notification> notifs = new ArrayList<>();
        while(result.next())
        {
            if(!listeidnotif.contains(result.getInt("id")))
            {   
                Notification notif = new Notification(result.getInt("id"));
                notifs.add(notif);
                listeidnotif.add(result.getInt("id"));
            }
        }
        return notifs;
    }

    @FXML
    private void initialize() throws Exception
    {
        ResultSet result = API.getInstance().getNotif(App.getUser().getId());
        while(result.next())
        {
            if(result.getInt("type")==2)
            {
                listevisiteeList.add(result.getInt("iduser2"));
            }
        }

        List<Reservation> resa = Reservation();
        //System.out.println(resa.get(0).getDate_debut()+" "+dates[0]+" "+resa.get(0).getDate_fin());
        for (int i=0; i<resa.size(); i++){
            envoyernotifresa(resa.get(i));
        }
        List<Notification> notifs = Notification();
        System.out.println(notifs.size());
        for (int i=0; i<notifs.size(); i++){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("notifitem.fxml"));
            try{
                HBox hbox = loader.load();
                NotifItemController controller = loader.getController();
                controller.setData(notifs.get(i).getMessage(), notifs.get(i).getdate(), notifs.get(i).gettype(), notifs.get(i).getiduser2(),notifs.get(i).getidannonce());
                NotifVobx.getChildren().add(hbox);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private void envoyernotifresa(Reservation resa) throws Exception
    {
        int date = (int)Instant.now().getEpochSecond();
        int dateresadebut=resa.getDate_debut(); 
        int dateresafin=resa.getDate_fin();
        ResultSet result = API.getInstance().getNotif(App.getUser().getId());

        while(result.next())
        {
            if(!((result.getInt("type")==2)&&(result.getInt("iduser2")==resa.getAnnonce().getId())))
            {
                if(dateresadebut<=date && dateresafin>=date)
                {
                    if(!listevisiteeList.contains(resa.getAnnonce().getId()))
                    {
                        API.getInstance().addnotif(App.getUser().getId(), "Vous avez une réservation aujourd hui",2, resa.getAnnonce().getId());
                        listevisiteeList.add(resa.getAnnonce().getId());
                    }
                }
            }
        }
        
    }


    @FXML
    private void depot() throws IOException {
        App.setRoot("creationannonce");
        // App.setRoot("creationannonce_planning_service");
    }

    @FXML
    private void liste_annonce() throws IOException {
        App.setTypeRecherche(TypeRecherche.ALL);
        App.setRoot("listeannonce");
    }

    private List<Reservation> Reservation() throws Exception{
        List<Reservation> reservations = new ArrayList<>();
        ResultSet resultSet = API.getInstance().getReservations(App.getUser().getId());
        System.out.println(resultSet);
        while (resultSet.next()) {
            Reservation resa = new Reservation(resultSet.getInt("id"));

            reservations.add(resa);
        }
        return reservations;
    }
}