package eu.telecomnancy;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.fxml.FXML;

public class HubController {

    @FXML
    private Button creatioannonce;

    @FXML
    private void initialize() {
        creatioannonce.setOnAction(this::handlecreateButtonClick);
    }

    private void handlecreateButtonClick(ActionEvent event) {
        try {
            App.setRoot("creationannonce");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}