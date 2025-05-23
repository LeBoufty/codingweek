package eu.telecomnancy;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import eu.telecomnancy.Outils.Formater;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class HeaderController {

    @FXML
    private Label price;
    
    @FXML
    private ChoiceBox<String> header_burger;

    @FXML
    private void initialize() {

    // Mapping between display names and corresponding FXML files
    Map<String, String> pageMappings = new HashMap<>();
    pageMappings.put("Creation Annonce", "creationannonce");
    pageMappings.put("Mon Profil", "profil");
    pageMappings.put("Mes Chats", "mainchat");
    pageMappings.put("Deconnexion", "connect");

    header_burger.getItems().addAll("Creation Annonce", "Mon Profil","Mes Chats" ,"Deconnexion");

    header_burger.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
        try {
            if (newValue.equals("Deconnexion")) {
                App.setUser(0);
            }
            App.setRoot(pageMappings.get(newValue));
        } catch (IOException e) {
            e.printStackTrace();
        }
    });

    price.setText(Formater.shortenPrice(App.getUser().getArgent()));

    }

    @FXML
    private void homeButton() throws IOException {
        App.setRoot("hub");
    }

    @FXML
    private void searchButton() throws IOException {
        App.setRoot("rechercheannonce");
    }

}