package eu.telecomnancy;

import eu.telecomnancy.BDD_App.API;
import eu.telecomnancy.Model.Reservation;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class EvaluationController {

    @FXML
    private VBox prereservationlayout;
    
    public void initialize() throws Exception {
        ArrayList<Reservation> reservations = new ArrayList<>();

        reservations = API.getInstance().getEvaluation(App.getUser().getId());

        for (int i=0; i<reservations.size(); i++){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("element_evaluation.fxml"));

            HBox hbox = loader.load();
            Element_EvaluationController controller = loader.getController();
            controller.setData(reservations.get(i));
            prereservationlayout.getChildren().add(hbox);
        }
    }

}

