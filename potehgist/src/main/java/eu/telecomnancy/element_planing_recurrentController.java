package eu.telecomnancy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class element_planing_recurrentController {
    
        private CreationAnnonce_Planning_Service parent_controller;

    public void setParent_controller(CreationAnnonce_Planning_Service parent_controller) {
        this.parent_controller = parent_controller;
    }

    @FXML
    private DatePicker date_debut_rec;

    @FXML
    private DatePicker date_fin_rec;

    @FXML
    private TextField heure_rec;

    @FXML
    private ChoiceBox<?> jour_semaine;

    @FXML
    private TextField minute_rec;

    @FXML
    private HBox box_ponctuel;

    @FXML
    void minus_recurrent(ActionEvent event) {
        int num_int = box_ponctuel.getParent().getChildrenUnmodifiable().indexOf(box_ponctuel);
        parent_controller.notif_sup(num_int);
    }

    public void initialize() {

    }
}
