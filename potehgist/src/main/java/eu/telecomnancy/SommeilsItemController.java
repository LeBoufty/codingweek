package eu.telecomnancy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SommeilsItemController {

    @FXML
    private Label Date_debut;

    @FXML
    private Label Date_fin;

    @FXML
    private Label idsommeil;

    @FXML
    public void delSommeils(ActionEvent event) {

    }

    public void setData(String id, String datedebut, String datefin) {
        idsommeil.setText(id);
        Date_debut.setText(datedebut);
        Date_fin.setText(datefin);
    }
}