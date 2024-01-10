package eu.telecomnancy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import eu.telecomnancy.Model.Annonce;

public class ReserverController {

    @FXML
    private Label Description;

    @FXML
    private Label Prix;

    @FXML
    private Label Titre;
    
    @FXML
    private DatePicker date_debut;

    @FXML
    private DatePicker date_fin;

    public void initialize() throws Exception {
        Annonce annonce = App.getAnnonce();
        Description.setText(annonce.getDescription());
        Prix.setText(annonce.getPrix().toString());
        Titre.setText(annonce.getTitre());
    }

    @FXML
    void reserver(ActionEvent event) {
        
    }

}
