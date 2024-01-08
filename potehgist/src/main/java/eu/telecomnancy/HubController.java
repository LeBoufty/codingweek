package eu.telecomnancy;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.fxml.FXML;

public class HubController {
    @FXML
    private void depot() throws IOException {
        App.setRoot("creationannonce");
    }
}