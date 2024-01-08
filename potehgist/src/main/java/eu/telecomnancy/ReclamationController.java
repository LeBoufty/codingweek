package eu.telecomnancy;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class ReclamationController {

    @FXML
    private TextArea message;

    @FXML
    private void send() throws IOException {
        System.out.println(message.getText());
        App.setRoot("connect");
    }

    @FXML
    private void connex() throws IOException {
        App.setRoot("connect");
    }
}