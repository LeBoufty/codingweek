package eu.telecomnancy;

import eu.telecomnancy.BDD_App.API;
import eu.telecomnancy.Model.Utilisateur;
import javafx.fxml.FXML;

public class modprofilController {

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
    private void updateprofile() throws Exception {
        Utilisateur user = App.getUser();
        // Si le nom d'utilisateur ou l'e-mail est déjà pris on affiche un message
        if(!username.getText().equals("")) {
            if (API.getInstance().usernamePris(username.getText())) {
                System.out.println("Nom d'utilisateur déjà pris");
            } else {
                user.setNom(username.getText());
            }
        }

        if(!email.getText().equals("")) {
            if (API.getInstance().emailPris(email.getText())) {
                System.out.println("E-mail déjà pris");
            } else {
                user.setEmail(email.getText());
            }
        }

        if(!password1.getText().equals("")) {
            if (!password1.getText().equals(password2.getText())) {
                System.out.println("Les mots de passe ne correspondent pas");
            } else {
                user.setMot_de_passe(password1.getText());
            }
        }

        if(!codepostal.getText().equals("")) {
            user.setCode_postal(codepostal.getText());
        }
        user.save();
        App.setRoot("profil");

    }
    
    @FXML
    private void returntoprofile() throws Exception {
        App.setRoot("profil");
    }
}
