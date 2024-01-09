package eu.telecomnancy;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
//import javafx.scene.image.Image;

public class AnnoncelisteItemController{

    @FXML
    private Label description;

    @FXML
    private ImageView img;

    @FXML
    private Label price;

    @FXML
    private Label title;

    public void setData(Annonce annonce){
        // Image image = new Image(annonce.getImgSrc());
        // img.setImage(image);

        title.setText(annonce.getTitre());
        description.setText(annonce.getDescription());
        price.setText(annonce.getPrix().toString());

    }

    public void initialize(URL location, ResourceBundle ressources) {

    }    
}
