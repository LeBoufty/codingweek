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


    public void initialize()
    {
        username.setText("test");
        Image image = new Image("logo.png");
        imageView.setImage(image);
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
        System.out.println("to ModifProfile");
    }
    
}
