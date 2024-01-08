package eu.telecomnancy;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

public class HeaderController {
    
    @FXML
    private ChoiceBox<String> header_burger;
    @FXML
    private Button homeButton;

    @FXML
private void initialize() {

    homeButton.setOnAction(this::handleHomeButtonClick);
    // Mapping between display names and corresponding FXML files
    Map<String, String> pageMappings = new HashMap<>();
    pageMappings.put("Creation Annonce", "creationannonce");
    pageMappings.put("Creation Compte", "creationcompte");
    pageMappings.put("Mon Profil", "profil");
    pageMappings.put("Deconnexion", "connect");

    header_burger.getItems().addAll("Creation Annonce", "Creation Compte", "Mon Profil", "Deconnexion");

    header_burger.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
        try {   
            App.setRoot(pageMappings.get(newValue));
        } catch (IOException e) {
            e.printStackTrace();
        }
    });
}

    private void handleHomeButtonClick(ActionEvent event) {
        try {
            App.setRoot("hub");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }