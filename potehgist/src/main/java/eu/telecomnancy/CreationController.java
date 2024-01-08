package eu.telecomnancy;

import java.io.IOException;

import javafx.fxml.FXML;

public class CreationController {

    @FXML
    private javafx.scene.control.TextField username;

    @FXML
    private javafx.scene.control.TextField email;

    @FXML
    private javafx.scene.control.TextField codepostal;

    @FXML
    private javafx.scene.control.TextField password1;

    @FXML
    private javafx.scene.control.TextField password2;

    @FXML
    private void create() throws IOException {
        System.out.println(username.getText()+"\n"+email.getText()+"\n"+password1.getText()+"\n"+password2.getText()+"\n"+codepostal.getText());
    }
    
}
