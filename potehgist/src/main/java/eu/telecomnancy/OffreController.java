package eu.telecomnancy;

import eu.telecomnancy.BDD_App.API;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class OffreController {
    
    @FXML
    private Label categorie;

    @FXML
    private Text description;

    @FXML
    private ImageView image;

    @FXML
    private Label nom_annonce;
    
    @FXML
    private Label nom_vendeur;

    @FXML
    private Label prix;

    //entrer en chat
    //réserver

    public void initialize() throws Exception
    {
        
    }

    public void entrerchat() throws Exception
    {
        App.setUser2(API.getInstance().getUserid(nom_vendeur.getText().toString()));
        App.setRoot("chat");
    }

    public void reserver() throws Exception
    {
        //à faire
        System.out.println("Réservation de l'offre");
    }
}
