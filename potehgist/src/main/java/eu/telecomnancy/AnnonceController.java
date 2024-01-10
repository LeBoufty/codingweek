package eu.telecomnancy;

import eu.telecomnancy.Model.Annonce;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
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

    public void initialize() {
        Annonce annonce = new Annonce(App.idannonce);
        title.setText(annonce.getTitre());
        description.setText(annonce.getDescription());
        price.setText(annonce.getPrix().toString());
        categorie.setText(annonce.getCategorie());
        date_depot.setText(annonce.getDate_depot());
        code_postal.setText(annonce.getCode_postal());
        
    }
}