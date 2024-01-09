package eu.telecomnancy;

import java.io.IOException;

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
        username.setText("Nom d'utilisateur: "+ user.getNom());
        email.setText("email: "+ user.getEmail());
        codepostal.setText("code postal: "+ user.getCode_postal());
        if(getClass().getResource("assets/imagedeprofile/"+user.getId()+".png")!=null)
        {   
            Image image = new Image(getClass().getResource("assets/imagedeprofile/"+user.getId()+".png").toExternalForm());
            imageView.setImage(image);
        }
    }


    @FXML
    private void toMesoffres() throws IOException {
        System.out.println("to MesOffres");
    }


    @FXML
    private void toMonPlanning() throws IOException {
        System.out.println("to MonPlanning");
    }

    @FXML
    private void toModifProfile() throws IOException {
        App.setRoot("modprofil");
    }
    
}
