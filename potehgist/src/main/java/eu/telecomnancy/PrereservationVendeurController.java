package eu.telecomnancy;

import eu.telecomnancy.BDD_App.API;
import eu.telecomnancy.Model.Reservation;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.util.List;
import java.util.ArrayList;
import javafx.fxml.FXMLLoader;

public class PrereservationVendeurController {
    
    @FXML
    private VBox prereservationlayout;

    public void initialize() throws Exception{
        List<Reservation> reservations = new ArrayList<>();

        reservations = new ArrayList<>(Reservations());

        for (int i=0; i<reservations.size(); i++){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("reservationlisteitem.fxml"));

            try{
                HBox hbox = loader.load();
                PrereservationVendeurItemController controller = loader.getController();
                controller.setData(reservations.get(i));
                prereservationlayout.getChildren().add(hbox);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private List<reservation> reservations() throws Exception{
        List<reservation> reservations = new ArrayList<>();
        reservations = API.getInstance().getreservationsRecherche(App.reservation_recherche);

        return reservations;
    }
}
