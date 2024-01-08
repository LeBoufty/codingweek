package eu.telecomnancy;

import java.io.IOException;

import javafx.fxml.FXML;

public class ConnectController {

    @FXML
    private javafx.scene.control.TextField username;

    @FXML
    private javafx.scene.control.TextField password;

    @FXML
    private void connect() throws IOException {
        System.out.println(username.getText()+" "+password.getText());
    }

    @FXML
    private void create() throws IOException {
        App.setRoot("creationcompte");
    }
    
}
