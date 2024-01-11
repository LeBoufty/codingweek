package eu.telecomnancy;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class NotifItemController{

    @FXML
    private Label Description;

    @FXML
    private Label Date;

    @FXML
    private Button voir;

    public void setData(String description, int date, int type, int iduser2){
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
        Description.setText(description);
        Date.setText(dateTime.format(formatter));

    }

    public void initialize(URL location, ResourceBundle ressources) {

    }    
}
