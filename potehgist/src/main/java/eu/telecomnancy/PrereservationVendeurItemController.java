package eu.telecomnancy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import eu.telecomnancy.Model.Reservation;

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
    private Label id_offre;

    @FXML
    private Label id;

    @FXML
    void Refuse(ActionEvent event) {

    }

    @FXML
    void Validate(ActionEvent event) {

    }

    public void setData(Reservation reservation) {
        Titre.setText(reservation.getAnnonce().getTitre());
        id_offre.setText(String.valueOf(reservation.getId_offre()));
        id.setText(String.valueOf(reservation.getId()));
    }

    public void showAnnonce(ActionEvent event) throws Exception {
        App.setidannonce(Integer.valueOf(id_offre.getText()));
        App.setRoot("annonce");
    }
}