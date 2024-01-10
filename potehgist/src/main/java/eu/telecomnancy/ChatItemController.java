package eu.telecomnancy;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

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
        Description.setText(description);
        Date.setText(dateTime.format(formatter));
        Auteur.setText(auteur);

    }

    public void initialize(URL location, ResourceBundle ressources) {

    }    
}
