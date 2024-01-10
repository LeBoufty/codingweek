package eu.telecomnancy;

import java.net.URL;
import java.util.ResourceBundle;

import eu.telecomnancy.BDD_App.API;
import eu.telecomnancy.Model.Reservation;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ReservationlisteItemController{

    @FXML
    private Label Acheteur;

    @FXML
    private Label title;

    public void setData(Reservation resa){
        // Image image = new Image(annonce.getImgSrc());
        // img.setImage(image);
        String titre =API.getInstance().getOffreInfos(resa.getId_offre())[0];
        String acheteur =API.getInstance().getOffreInfos(resa.getId_offre())[1];
        Acheteur.setText(acheteur);
        title.setText(titre);

    }

    public void initialize(URL location, ResourceBundle ressources) {

    }    
}
