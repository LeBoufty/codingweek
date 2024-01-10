package eu.telecomnancy;

import java.net.URL;
import java.util.ResourceBundle;

import eu.telecomnancy.Model.Annonce;
import eu.telecomnancy.Outils.Formater;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
//import javafx.scene.image.Image;

public class AnnoncelisteItemController{

    @FXML
    private Button button;

    @FXML
    private Label categorie;

    @FXML
    private Label code_postal;

    @FXML
    private Label date_depot;

    @FXML
    private Label description;

    @FXML
    private ImageView img;

    @FXML
    private Label price;

    @FXML
    private Label title;

    @FXML
    private Label idannonce;

    public void setData(Annonce annonce){
        // Image image = new Image(annonce.getImgSrc());
        // img.setImage(image);

        title.setText(annonce.getTitre());
        description.setText(Formater.addNewlines(annonce.getDescription(), 120));
        price.setText(annonce.getPrix().toString());
        categorie.setText(annonce.getCategorie());
        date_depot.setText(annonce.getDate_depot());
        code_postal.setText(annonce.getCode_postal());
        idannonce.setText(String.valueOf(annonce.getId()));

    }

    public void initialize(URL location, ResourceBundle ressources) {
    }    

    @FXML
    void showAnnonce(ActionEvent event) throws Exception{
        App.idannonce = Integer.valueOf(idannonce.getText());
        System.out.println("Annonce n°" + App.idannonce);
        App.setRoot("annonce");
    }
}
