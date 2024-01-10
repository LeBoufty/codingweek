package eu.telecomnancy;

import java.sql.ResultSet;
import java.time.LocalDate;
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


    private LocalDate[] dates;


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
        Page.setText(Integer.toString(currentpage));
        System.out.println("ListeAnnonceController");
        dates = new LocalDate[7];
        dates[0] = LocalDate.now().plusDays((currentpage-1)*7);
        dates[1] = dates[0].plusDays(1);
        dates[2] = dates[0].plusDays(2);
        dates[3] = dates[0].plusDays(3);
        dates[4] = dates[0].plusDays(4);
        dates[5] = dates[0].plusDays(5);
        dates[6] = dates[0].plusDays(6);
        jour1.setText(dates[0].toString());
        jour2.setText(dates[1].toString());
        jour3.setText(dates[2].toString());
        jour4.setText(dates[3].toString());
        jour5.setText(dates[4].toString());
        jour6.setText(dates[5].toString());
        jour7.setText(dates[6].toString());
        List<Reservation> resa = Reservation();
        System.out.println(resa);
        for (int i=0; i<resa.size(); i++){
            mettredansleplanning(resa.get(i));
        }
    }

    private void mettredansleplanning(Reservation resa)
    {
        int[] DatesFormatees = new int[7]; 
        int datedebut = resa.getDate_debut();
        int datefin = resa.getDate_fin();
        for(int i=0;i<7;i++)
        {
            DatesFormatees[i]=dates[i].getYear()*10000+dates[i].getMonthValue()*100+dates[i].getDayOfMonth();
        }
        System.out.println(DatesFormatees);
        System.out.println(datedebut);
        System.out.println(datefin);
        if(datedebut<=DatesFormatees[0] && datefin>=DatesFormatees[0])
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
        if(datedebut<=DatesFormatees[1] && datefin>=DatesFormatees[1])
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
        if(datedebut<=DatesFormatees[2] && datefin>=DatesFormatees[2])
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
        if(datedebut<=DatesFormatees[3] && datefin>=DatesFormatees[3])
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
        if(datedebut<=DatesFormatees[4] && datefin>=DatesFormatees[4])
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
        if(datedebut<=DatesFormatees[5] && datefin>=DatesFormatees[5])
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
        if(datedebut<=DatesFormatees[6] && datefin>=DatesFormatees[6])
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
