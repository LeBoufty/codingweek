package eu.telecomnancy;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import eu.telecomnancy.BDD_App.API;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class NotifItemController {

    private int idannonce;

    @FXML
    private Label Description;

    @FXML
    private Label Date;

    @FXML
    private Button voir;

    public void setData(String description, int date, int type, int iduser2, int id){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime dateTime = LocalDateTime.ofEpochSecond(date, 0, java.time.ZoneOffset.UTC);
        if(type == 1)
            {
                voir.onActionProperty().set(event -> {
                    try {
                        App.setUser2(iduser2);
                        App.setRoot("chat");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
            else if(type==2)
            {
                voir.onActionProperty().set(event -> {
                    try {
                        App.idannonce=iduser2;
                        //System.Out.println("Annonce n°" + App.idannonce);
                        App.setRoot("annonce");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
        Description.setText(description);
        Date.setText(dateTime.format(formatter));
        this.idannonce = id;
    }

    public void supprimernotif() throws IOException {
        API.getInstance().dlnotif(idannonce);
        App.setRoot("hub");

    }    

    public void initialize(URL location, ResourceBundle ressources) {

    }    
}
