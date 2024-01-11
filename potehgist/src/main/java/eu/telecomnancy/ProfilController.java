package eu.telecomnancy;

import java.io.IOException;

import eu.telecomnancy.BDD_App.API;
import eu.telecomnancy.Model.Utilisateur;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ProfilController {

    @FXML
    private Label username;

    @FXML
    private ImageView imageView;

    @FXML
    private Label email;

    @FXML
    private Label codepostal;

    public void initialize() throws Exception
    {
        Utilisateur user = App.getUser();
        username.setText(user.getNom());
        email.setText(user.getEmail());
        codepostal.setText(user.getCode_postal());
        API.getInstance().getImageUser(user.getId());
        Image image = new Image(getClass().getResource("/eu/telecomnancy/assets/user_photo.png").toExternalForm());
        imageView.setImage(image);
        
    }



    @FXML
    private void toMesoffres() throws IOException {
        App.setTypeRecherche(TypeRecherche.MESANNONCES);
        App.setRoot("listeannonce");
    }


    @FXML
    private void toMonPlanning() throws IOException {
        App.setRoot("planning");
    }

    @FXML
    private void toModifProfile() throws IOException {
        App.setRoot("modprofil");
    }
    
    @FXML
    private void toSommeils() throws IOException {
        App.setRoot("sommeils");
    }

    @FXML
    private void toReservationsVendeur() throws IOException {
        App.setRoot("prereservationvendeur");
    }

    @FXML
    private void toMesReservations() throws IOException {
        App.setRoot("prereservationuser");
    }
}
