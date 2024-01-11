package eu.telecomnancy;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import eu.telecomnancy.Outils.Formater;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class ChatItemController {

    @FXML
    private Text Description;

    @FXML
    private Label Auteur;

    @FXML
    private Label Date;

    public void setData(String description, int date, String auteur){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime dateTime = LocalDateTime.ofEpochSecond(date, 0, java.time.ZoneOffset.UTC);
        Description.setText(Formater.addNewlines(description, 140));
        Date.setText(dateTime.format(formatter));
        Auteur.setText(auteur);

    }

    public void initialize(URL location, ResourceBundle ressources) {

    }    
}
