package eu.telecomnancy;

import java.sql.ResultSet;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import eu.telecomnancy.BDD_App.API;
import eu.telecomnancy.Model.Reservation;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class PlanningController {

    public int currentpage=1;

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
    public void initialize() throws Exception{
        Instant now = Instant.now();
        dates[0] = (int)now.getEpochSecond()+(currentpage-1)*86400*7;
        dates[1] = dates[0]+86400;
        dates[2] = dates[0]+86400*2;
        dates[3] = dates[0]+86400*3;
        dates[4] = dates[0]+86400*4;
        dates[5] = dates[0]+86400*5;
        dates[6] = dates[0]+86400*6;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
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
        List<Reservation> resa = Reservation();
        System.out.println(resa);
        for (int i=0; i<resa.size(); i++){
            mettredansleplanning(resa.get(i));
        }
    }

    private void mettredansleplanning(Reservation resa)
    {
        int[] dates = new int[7]; 
        int datedebut = resa.getDate_debut();
        int datefin = resa.getDate_fin();
        if(datedebut<=dates[0] && datefin>=dates[0])
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("reservationlisteitem.fxml"));

            try{
                System.out.println("try");
                HBox hbox = loader.load();
                ReservationlisteItemController controller = loader.getController();
                controller.setData(resa);
                annonceslayout1.getChildren().add(hbox);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        if(datedebut<=dates[1] && datefin>=dates[1])
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("reservationlisteitem.fxml"));

            try{
                System.out.println("try");
                HBox hbox = loader.load();
                ReservationlisteItemController controller = loader.getController();
                controller.setData(resa);
                annonceslayout2.getChildren().add(hbox);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        if(datedebut<=dates[2] && datefin>=dates[2])
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("reservationlisteitem.fxml"));

            try{
                System.out.println("try");
                HBox hbox = loader.load();
                ReservationlisteItemController controller = loader.getController();
                controller.setData(resa);
                annonceslayout3.getChildren().add(hbox);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        if(datedebut<=dates[3] && datefin>=dates[3])
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("reservationlisteitem.fxml"));

            try{
                System.out.println("try");
                HBox hbox = loader.load();
                ReservationlisteItemController controller = loader.getController();
                controller.setData(resa);
                annonceslayout4.getChildren().add(hbox);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        if(datedebut<=dates[4] && datefin>=dates[4])
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("reservationlisteitem.fxml"));

            try{
                System.out.println("try");
                HBox hbox = loader.load();
                ReservationlisteItemController controller = loader.getController();
                controller.setData(resa);
                annonceslayout5.getChildren().add(hbox);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        if(datedebut<=dates[5] && datefin>=dates[5])
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("reservationlisteitem.fxml"));

            try{
                System.out.println("try");
                HBox hbox = loader.load();
                ReservationlisteItemController controller = loader.getController();
                controller.setData(resa);
                annonceslayout6.getChildren().add(hbox);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        if(datedebut<=dates[6] && datefin>=dates[6])
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("reservationlisteitem.fxml"));

            try{
                System.out.println("try");
                HBox hbox = loader.load();
                ReservationlisteItemController controller = loader.getController();
                controller.setData(resa);
                annonceslayout7.getChildren().add(hbox);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
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

    @FXML
    private void pageSuivante() throws Exception {
        currentpage++;
        Page.setText(Integer.toString(currentpage));
        initialize();
    }

    @FXML
    private void pagePrecedente() throws Exception {
        if (currentpage > 1) {
            currentpage--;
            Page.setText(Integer.toString(currentpage));
        }
        initialize();
    }
    
    @FXML
    private void retour() throws Exception {
        App.setRoot("profil");
    }
}
