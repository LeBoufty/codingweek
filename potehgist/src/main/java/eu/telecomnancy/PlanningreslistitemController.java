package eu.telecomnancy;

import java.net.URL;
import java.util.ResourceBundle;

import eu.telecomnancy.Model.Date_M;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PlanningreslistitemController {

    @FXML
    private Label Date;

    @FXML
    private Label Moment;

    public void setData(int date, int debutfint){ //debutfint = 0 debut, debutfint = 1 fin
        Date_M date_M = new Date_M(date);
        Date.setText(String.valueOf(date_M.getHeure()+"h"+date_M.getMinute()));
        if(debutfint == 0)
            Moment.setText("Début");
        else
            Moment.setText("Fin");
    }

    public void initialize(URL location, ResourceBundle ressources) {

    }    
}
