package eu.telecomnancy;

import java.io.IOException;

import eu.telecomnancy.BDD_App.API;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class ReclamationController {

    @FXML
    private TextArea message;

    @FXML
    private void send() throws Exception {
        System.out.println(message.getText());
        try {
            API.getInstance().addReclamation(App.getUserid(), message.getText());
            if (App.getUserid() == 0) {
                App.setRoot("connect");
            } else {
                App.setRoot("hub");
            }
        } catch (IOException e) {
            e.printStackTrace();
            App.setRoot("connect"); 
        }
    }

    @FXML
    private void connex() throws IOException {
        App.setRoot("connect");
    }
}