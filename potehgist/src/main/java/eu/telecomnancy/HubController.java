package eu.telecomnancy;

import java.io.IOException;

import javafx.fxml.FXML;

public class HubController {
    @FXML
    private void depot() throws IOException {
        App.setRoot("creationannonce");
    }

    @FXML
    private void liste_annonce() throws IOException {
        App.setPageAnnonce(1);
        App.setRoot("listeannonce");
    }
}