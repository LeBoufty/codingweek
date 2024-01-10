package eu.telecomnancy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;

public class CreationAnnonce_Planning_Service {

    @FXML
    private VBox layout_planning_service;

    @FXML
    private ChoiceBox<String> type_planning;

    @FXML
    private Button button_planning_select;

    public void initialize() {
        type_planning.getItems().addAll("Ponctuel", "Récurrent");

    }

    @FXML
    void select_planning_action(ActionEvent event) {
        if (type_planning.getValue().equals("Ponctuel")) {
            try {
                App.setRoot("creationannonce_ponctuel");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (type_planning.getValue().equals("Récurrent")) {
            try {
                App.setRoot("creationannonce_recurrent");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }




}
