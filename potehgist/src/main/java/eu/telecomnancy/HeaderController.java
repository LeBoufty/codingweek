package eu.telecomnancy;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class HeaderController {
    
    @FXML
    private ChoiceBox<String> header_burger;

    @FXML
private void initialize() {
    // Mapping between display names and corresponding FXML files
    Map<String, String> pageMappings = new HashMap<>();
    pageMappings.put("Connexion", "connect");
    pageMappings.put("Creation Annonce", "creationannonce");
    pageMappings.put("Creation Compte", "creationcompte");

    header_burger.getItems().addAll("Connexion", "Creation Annonce", "Creation Compte");

    header_burger.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
        try {   
            App.setRoot(pageMappings.get(newValue));
        } catch (IOException e) {
            e.printStackTrace();
        }
    });
}

    }