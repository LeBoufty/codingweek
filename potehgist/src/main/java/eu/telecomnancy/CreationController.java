package eu.telecomnancy;

import eu.telecomnancy.BDD_App.API;
import javafx.fxml.FXML;

public class CreationController {

    @FXML
    private javafx.scene.control.TextField username;

    @FXML
    private javafx.scene.control.TextField email;

    @FXML
    private javafx.scene.control.TextField codepostal;

    @FXML
    private javafx.scene.control.TextField password;

    @FXML
    private void create() throws Exception {
        // Si le nom d'utilisateur ou l'e-mail est déjà pris on affiche un message
        if (API.getInstance().usernamePris(username.getText()) || API.getInstance().emailPris(email.getText())) {
            System.out.println("Nom d'utilisateur ou e-mail déjà pris");
        } else {
            // Sinon on ajoute l'utilisateur à la base de données
            API.getInstance().addUser(username.getText(), password.getText(), email.getText());
            // On redirige vers la page de connexion
            App.setRoot("connect");
        }
    }
    
}
