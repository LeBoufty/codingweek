package eu.telecomnancy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import eu.telecomnancy.Model.Annonce;

public class PrereservationVendeurItemController {

    @FXML
    private Label Date_debut;

    @FXML
    private Label Date_fin;

    @FXML
    private Label Titre;

    @FXML
    private Label id_acheteur;

    @FXML
    void Refuse(ActionEvent event) {

    }

    @FXML
    void Validate(ActionEvent event) {

    }

    public void initialize() throws Exception {
        Annonce annonce = App.getAnnonce();
        Titre.setText(annonce.getTitre());
    }

}