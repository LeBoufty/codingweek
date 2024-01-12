package eu.telecomnancy;

import java.sql.ResultSet;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import eu.telecomnancy.BDD_App.API;
import eu.telecomnancy.Model.Date_M;
import eu.telecomnancy.Model.Reservation;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class PlanningReservationController {

    public int currentpage=0;

    public int currentannonce=0;

    @FXML
    private Label Page;

    @FXML
    private Label jour1;

    @FXML
    private Label jour2;

    @FXML
    private Label jour3;

    @FXML
    private Label jour4;

    @FXML
    private Label jour5;

    @FXML
    private Label jour6;

    @FXML
    private Label jour7;


    private int[] dates= new int[7];


    @FXML
    private javafx.scene.control.TextArea Description;

    @FXML
    private VBox annonceslayout1;

    @FXML
    private VBox annonceslayout2;

    @FXML
    private VBox annonceslayout3;

    @FXML
    private VBox annonceslayout4;
    
    @FXML
    private VBox annonceslayout5;

    @FXML
    private VBox annonceslayout6;

    @FXML
    private VBox annonceslayout7;

    @FXML
    public void initialize(){
        currentannonce = App.currentannonce;
        afficherdate();  
    }


    private void afficherdate()
    {
        annonceslayout1.getChildren().clear();
        annonceslayout2.getChildren().clear();
        annonceslayout3.getChildren().clear();
        annonceslayout4.getChildren().clear();
        annonceslayout5.getChildren().clear();
        annonceslayout6.getChildren().clear();
        annonceslayout7.getChildren().clear();
        if(currentpage==0)
        {
            currentpage=1;
        }
        Instant now = Instant.now();
        dates[0] = (int)now.getEpochSecond()+(currentpage-1)*86400*7;
        dates[1] = dates[0]+86400;
        dates[2] = dates[0]+86400*2;
        dates[3] = dates[0]+86400*3;
        dates[4] = dates[0]+86400*4;
        dates[5] = dates[0]+86400*5;
        dates[6] = dates[0]+86400*6;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDateTime dateTime = LocalDateTime.ofEpochSecond(dates[0], 0, java.time.ZoneOffset.UTC);
        jour1.setText(dateTime.format(formatter));
        dateTime = LocalDateTime.ofEpochSecond(dates[1], 0, java.time.ZoneOffset.UTC);
        jour2.setText(dateTime.format(formatter));
        dateTime = LocalDateTime.ofEpochSecond(dates[2], 0, java.time.ZoneOffset.UTC);
        jour3.setText(dateTime.format(formatter));
        dateTime = LocalDateTime.ofEpochSecond(dates[3], 0, java.time.ZoneOffset.UTC);
        jour4.setText(dateTime.format(formatter));
        dateTime = LocalDateTime.ofEpochSecond(dates[4], 0, java.time.ZoneOffset.UTC);
        jour5.setText(dateTime.format(formatter));
        dateTime = LocalDateTime.ofEpochSecond(dates[5], 0, java.time.ZoneOffset.UTC);
        jour6.setText(dateTime.format(formatter));
        dateTime = LocalDateTime.ofEpochSecond(dates[6], 0, java.time.ZoneOffset.UTC);
        jour7.setText(dateTime.format(formatter));

        Date_M date_M = new Date_M(dates[0]);

        for (int i=0; i<7; i++){
            date_M = new Date_M(dates[i]);
            dates[i]=dates[i]-date_M.getHeure()*3600-date_M.getMinute()*60-date_M.getSeconde();
        }


        List<Reservation> resa;
        try {
            resa = Reservation();
            if(resa.size() == 0)
            {
                //System.out.println("pas de resa");
            }
            else
            {
                for (int i=0; i<resa.size(); i++){
                    mettredansleplanning(resa.get(i));
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void mettredansleplanning(Reservation resa)
    {
        
        int datedebut = resa.getDate_debut();
        int datefin = resa.getDate_fin();

        Date_M date = new Date_M(datedebut);
        int jourdebut = datedebut-date.getHeure()*3600-date.getMinute()*60-date.getSeconde();

        date = new Date_M(datefin);
        int jourfin = datefin-date.getHeure()*3600-date.getMinute()*60-date.getSeconde();

        afficherdateitem(jourdebut, datedebut,0);
        afficherdateitem(jourfin, datefin,1);
    }

    private List<Reservation> Reservation() throws Exception{
        List<Reservation> reservations = new ArrayList<>();
        ResultSet resultSet = API.getInstance().getReservationsparannonce(currentannonce);
        while (resultSet.next()) {
            Reservation resa = new Reservation(resultSet.getInt("id"));
            reservations.add(resa);
        }
        return reservations;
    }

    private void afficherdateitem(int jourdebut, int datedebut,int etat)
    {
        
        if(jourdebut==dates[0])
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("planningreservationlisteitem.fxml"));

            try{
                
                HBox hbox = loader.load();
                PlanningreslistitemController controller = loader.getController();
                controller.setData(datedebut,etat);
                annonceslayout1.getChildren().add(hbox);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        if(jourdebut==dates[1])
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("planningreservationlisteitem.fxml"));

            try{
                
                HBox hbox = loader.load();
                PlanningreslistitemController controller = loader.getController();
                controller.setData(datedebut,etat);
                annonceslayout2.getChildren().add(hbox);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        if(jourdebut==dates[2])
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("planningreservationlisteitem.fxml"));

            try{
                
                HBox hbox = loader.load();
                PlanningreslistitemController controller = loader.getController();
                controller.setData(datedebut,etat);
                annonceslayout3.getChildren().add(hbox);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        if(jourdebut==dates[3])
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("planningreservationlisteitem.fxml"));

            try{
                
                HBox hbox = loader.load();
                PlanningreslistitemController controller = loader.getController();
                controller.setData(datedebut,etat);
                annonceslayout4.getChildren().add(hbox);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        if(jourdebut==dates[4])
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("planningreservationlisteitem.fxml"));

            try{
                
                HBox hbox = loader.load();
                PlanningreslistitemController controller = loader.getController();
                controller.setData(datedebut,etat);
                annonceslayout5.getChildren().add(hbox);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        if(jourdebut==dates[5])
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("planningreservationlisteitem.fxml"));

            try{
                
                HBox hbox = loader.load();
                PlanningreslistitemController controller = loader.getController();
                controller.setData(datedebut,etat);
                annonceslayout6.getChildren().add(hbox);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        if(jourdebut==dates[6])
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("planningreservationlisteitem.fxml"));

            try{
                
                HBox hbox = loader.load();
                PlanningreslistitemController controller = loader.getController();
                controller.setData(datedebut,etat);
                annonceslayout7.getChildren().add(hbox);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    


    @FXML
    private void pageSuivante() throws Exception {
        currentpage++;
        Page.setText(Integer.toString(currentpage));
        annonceslayout1.getChildren().clear();
        annonceslayout2.getChildren().clear();
        annonceslayout3.getChildren().clear();
        annonceslayout4.getChildren().clear();
        annonceslayout5.getChildren().clear();
        annonceslayout6.getChildren().clear();
        annonceslayout7.getChildren().clear();
        afficherdate();
    }

    @FXML
    private void pagePrecedente() throws Exception {
        if (currentpage > 1) {
            currentpage--;
            Page.setText(Integer.toString(currentpage));
        }
        annonceslayout1.getChildren().clear();
        annonceslayout2.getChildren().clear();
        annonceslayout3.getChildren().clear();
        annonceslayout4.getChildren().clear();
        annonceslayout5.getChildren().clear();
        annonceslayout6.getChildren().clear();
        annonceslayout7.getChildren().clear();
        afficherdate();
    }
    
    @FXML
    private void retour() throws Exception {
        App.setRoot("profil");
    }
}
