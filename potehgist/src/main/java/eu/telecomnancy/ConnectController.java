package eu.telecomnancy;

import java.io.IOException;

import javafx.fxml.FXML;

public class ConnectController {

    @FXML
    private javafx.scene.control.TextField username;

    @FXML
    private javafx.scene.control.TextField password;

    // Vu que l'username peut peut-être contenir des espaces, on devrait peut-être utiliser l'email
    @FXML
    private void connect() throws IOException {
        System.out.println(username.getText()+" "+password.getText());
        // On vérifie si le couple username/password est valide
        // Si c'est invalide on affiche un message
        // Sinon on redirige vers le hub avec userid de défini.
    }

    private boolean valide(String username, String password) {
        return true;
    }

    private String getUserid(String username) {
        return "1";
    }
    
}
