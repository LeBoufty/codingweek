package eu.telecomnancy;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import eu.telecomnancy.Model.Annonce;
import eu.telecomnancy.Model.Reservation;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ReservationlisteItemController{

    private int Idannonce;

    @FXML
    private Label Acheteur;

    @FXML
    private Label title;

    public void setData(Reservation resa){
        // Image image = new Image(annonce.getImgSrc());
        // img.setImage(image);
        Annonce offre = new Annonce(resa.getId_offre());
        String titre = offre.getTitre();
        String acheteur = offre.getVendeur().getNom();
        Acheteur.setText(acheteur);
        title.setText(titre);
        Idannonce=resa.getId_offre();
        
        //System.Out.println("Annonce n°" + App.idannonce);

    }

    public void initialize(URL location, ResourceBundle ressources) {

    }

    @FXML
    private void voir() throws IOException{
        App.idannonce=Idannonce;
        App.setRoot("annonce");
    }
}
