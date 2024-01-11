package eu.telecomnancy;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import eu.telecomnancy.BDD_App.API;
import eu.telecomnancy.Model.Notification;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class HubController {

    

    @FXML VBox NotifVobx;


    private List<Notification> Notification() throws Exception{
        ResultSet result = API.getInstance().getNotif(App.getUser().getId());
        List<Notification> notifs = new ArrayList<>();
        while(result.next())
        {
            Notification notif = new Notification(result.getInt("id"));
            notifs.add(notif);
        }
        return notifs;
    }

    @FXML
    private void initialize() throws Exception
    {
        List<Notification> notifs = Notification();
        for (int i=0; i<notifs.size(); i++){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("notifitem.fxml"));
            try{
                HBox hbox = loader.load();
                NotifItemController controller = loader.getController();
                controller.setData(notifs.get(i).getMessage(), notifs.get(i).getdate());
                NotifVobx.getChildren().add(hbox);
            } catch (Exception e){
                e.printStackTrace();
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
}