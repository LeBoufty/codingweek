package eu.telecomnancy;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class element_planing_ponctuelController {

    @FXML
    private DatePicker date_ponctuel;

    @FXML
    private TextField heure_ponctuel;

    @FXML
    private TextField minute_ponctuel;

    @FXML
    private Label numero_ponctuel;

    @FXML
    void minus_ponctuel(ActionEvent event) {

    }

    public void initialize(URL location, ResourceBundle ressources) {
    }    

}
