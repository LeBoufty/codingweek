package eu.telecomnancy;

import java.io.IOException;

import eu.telecomnancy.BDD_App.API;
import eu.telecomnancy.BDD_App.RemplirBDD;
import eu.telecomnancy.Outils.Formater;
import javafx.fxml.FXML;

public class ConnectController {

    @FXML
    private javafx.scene.control.TextField username;

    @FXML
    private javafx.scene.control.TextField password;

    // Vu que l'username peut peut-être contenir des espaces, on devrait peut-être utiliser l'email
    @FXML
    private void connect() throws Exception {
        // Non
        //System.Out.println(username.getText()+" "+password.getText());
        
        // On vérifie si le couple username/password est valide
        if (valide(username.getText(), password.getText())) {
            // Si c'est valide on récupère l'id de l'utilisateur
            App.setUser(getUserid(username.getText()));
            // On redirige vers le hub
            App.setRoot("hub");
        } else {
            // Si c'est invalide on affiche un message
            App.error("Nom d'utilisateur ou mot de passe incorrect");;
        }
    }

    private boolean valide(String username, String password) throws Exception {
        password = Formater.hash(password);
        return API.getInstance().checkPassword(username, password);
    }

    private int getUserid(String username) throws Exception {
        return API.getInstance().getUserid(username);
    }
    
    @FXML
    private void remplirBDD() throws Exception {
        API.getInstance().closeAPI();
        RemplirBDD remplirBDD = new RemplirBDD();
        remplirBDD.remplir();
        App.setRoot("connect");
    }

    @FXML
    private void create() throws IOException {
        App.setRoot("creationcompte");
    }
    
}
