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
    private javafx.scene.control.TextField password1;

    @FXML
    private javafx.scene.control.TextField password2;

    @FXML
    private void create() throws Exception {
        // Si le nom d'utilisateur ou l'e-mail est déjà pris on affiche un message
        if (API.getInstance().usernamePris(username.getText()) || API.getInstance().emailPris(email.getText())) {
            System.out.println("Nom d'utilisateur ou e-mail déjà pris");
        } else {
            if (!password1.getText().equals(password2.getText())) {
                System.out.println("Les mots de passe ne correspondent pas");
            } else {
                // Sinon on ajoute l'utilisateur à la base de données
                API.getInstance().addUser(username.getText(), password1.getText(), email.getText(), codepostal.getText());
                // On redirige vers la page de connexion
                App.setRoot("connect");
            }
        }
    }
    
}
