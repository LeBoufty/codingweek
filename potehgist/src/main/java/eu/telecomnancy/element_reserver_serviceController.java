package eu.telecomnancy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import eu.telecomnancy.Model.Date_M;

public class element_reserver_serviceController {

    public int date_debut;
    public int date_fin;

    @FXML
    private HBox box_ponctuel;

    @FXML
    private Label date;

    @FXML
    private Label duree;

    public void initialize() throws Exception{
        Date_M date_debut = new Date_M(this.date_debut);
        Date_M date_fin = new Date_M(this.date_fin - this.date_debut);
        date.setText(date_debut.getAlldateAAAAMMJJHHMM());
        duree.setText(date_fin.getAlldateHHMM());
    }

    @FXML
    void rerserver(ActionEvent event) {
    }

}
