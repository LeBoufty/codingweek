package eu.telecomnancy;

import java.net.URL;
import java.util.ResourceBundle;

import eu.telecomnancy.BDD_App.API;
import eu.telecomnancy.Model.Annonce;
import eu.telecomnancy.Model.Date_M;
import eu.telecomnancy.Outils.Formater;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
//import javafx.scene.image.Image;

public class AnnoncelisteItemController{

    @FXML
    private Label note_float;

    @FXML
    private Button button;

    @FXML
    private Label parheure;

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

    public void setData(Annonce annonce) throws Exception{
        // Image image = new Image(annonce.getImgSrc());
        // img.setImage(image);

        title.setText(annonce.getTitre());
        description.setText(Formater.addNewlines(annonce.getDescription(), 120));
        price.setText(Formater.shortenPrice(annonce.getPrix()));
        categorie.setText(annonce.getCategorie());
        int Date=Integer.parseInt(annonce.getDate_depot());
        Date_M date = new Date_M(Date);
        date_depot.setText(date.getAlldateJJMMAAAA());
        code_postal.setText(annonce.getCode_postal());
        idannonce.setText(String.valueOf(annonce.getId()));
        note_float.setText(String.valueOf(annonce.note));
        API.getInstance().getImageAnnonce(annonce.getId());
        Image image = new Image(getClass().getResource("/eu/telecomnancy/assets/annonce_image.png").toExternalForm());
        img.setImage(image);

        if (annonce.getCategorie().equals("Service")){
            parheure.setVisible(false);
        } else {
            parheure.setVisible(true);
        }
        

    }

    public void initialize(URL location, ResourceBundle ressources) {
    }    

    @FXML
    void showAnnonce(ActionEvent event) throws Exception{
        App.setidannonce(Integer.valueOf(idannonce.getText()));
        //System.out.println("Annonce n°" + App.idannonce);
        App.setRoot("annonce");
    }
}
