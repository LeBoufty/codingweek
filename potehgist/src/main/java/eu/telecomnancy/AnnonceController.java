package eu.telecomnancy;

import eu.telecomnancy.BDD_App.API;
import eu.telecomnancy.Model.Annonce;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AnnonceController {
    
    @FXML
    private Label categorie;

    @FXML
    private Label code_postal;

    @FXML
    private Label date_depot;

    @FXML
    private Label description;

    @FXML
    private Label idannonce;

    @FXML
    private ImageView img;

    @FXML
    private Label price;

    @FXML
    private Label title;

    @FXML
    private ImageView annonce_img;

    public void initialize() throws Exception {
        Annonce annonce = new Annonce(App.idannonce);
        title.setText(annonce.getTitre());
        description.setText(annonce.getDescription());
        price.setText(annonce.getPrix().toString());
        categorie.setText(annonce.getCategorie());
        date_depot.setText(annonce.getDate_depot());
        code_postal.setText(annonce.getCode_postal());

        API.getInstance().getImageAnnonce(annonce.getId());
        Image image = new Image(getClass().getResource("/eu/telecomnancy/assets/annonce_image.png").toExternalForm());
        annonce_img.setImage(image);
    }

    public void chat() throws Exception {
        App.setUser2(new Annonce(Integer.valueOf(idannonce.getText())).getVendeur().getId());
        App.setRoot("chat");
    }

    public void reservation() throws Exception {
        App.setRoot("reserver");
    }
}