package eu.telecomnancy;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class element_planing_ponctuelController {

    private CreationAnnonce_Planning_Service parent_controller;

    public void setParent_controller(CreationAnnonce_Planning_Service parent_controller) {
        this.parent_controller = parent_controller;
    }

    @FXML
    private DatePicker date_ponctuel;

    @FXML
    private TextField heure_ponctuel;

    @FXML
    private TextField minute_ponctuel;

    @FXML
    private HBox box_ponctuel;

    @FXML
    void minus_ponctuel(ActionEvent event) {
        int num_int = box_ponctuel.getParent().getChildrenUnmodifiable().indexOf(box_ponctuel);
        parent_controller.notif_sup(num_int);
    }

    public void initialize() {

    }    

}
