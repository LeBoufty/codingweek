package eu.telecomnancy;

import java.io.IOException;

import eu.telecomnancy.BDD_App.API;
import javafx.fxml.FXML;

public class ConnectController {

    @FXML
    private javafx.scene.control.TextField username;

    @FXML
    private javafx.scene.control.TextField password;

    // Vu que l'username peut peut-être contenir des espaces, on devrait peut-être utiliser l'email
    @FXML
    private void connect() throws Exception {
        System.out.println(username.getText()+" "+password.getText());
        // On vérifie si le couple username/password est valide
        if (valide(username.getText(), password.getText())) {
            // Si c'est valide on récupère l'id de l'utilisateur
            App.setUserid(getUserid(username.getText()));
            // On redirige vers le hub
            App.setRoot("hub");
        } else {
            // Si c'est invalide on affiche un message
            System.out.println("Mauvais couple username/password");
        }
    }

    private boolean valide(String username, String password) throws Exception {
        return API.getInstance().checkPassword(username, password);
    }

    private int getUserid(String username) throws Exception {
        return API.getInstance().getUserid(username);
    }

    @FXML
    private void create() throws IOException {
        App.setRoot("creationcompte");
    }
    
}
