package eu.telecomnancy;

import java.io.IOException;

import eu.telecomnancy.BDD_App.API;
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
        username.setText("Nom d'utilisateur: "+API.getInstance().getUsername(App.getUser().getId()));
        email.setText("email: "+API.getInstance().getemail(App.getUser().getId()));
        codepostal.setText("code postal: "+API.getInstance().getcode_postal(App.getUser().getId()));
        if(getClass().getResource("assets/imagedeprofile/"+App.getUser().getId()+".png")!=null)
        {   
            Image image = new Image(getClass().getResource("assets/imagedeprofile/"+App.getUser().getId()+".png").toExternalForm());
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
