package eu.telecomnancy;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PlanningreslistitemController {

    @FXML
    private Label Date;

    public void setData(String date){
        Date.setText(date);

    }

    public void initialize(URL location, ResourceBundle ressources) {

    }    
}
