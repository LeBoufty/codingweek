package eu.telecomnancy;

import eu.telecomnancy.BDD_App.API;
import eu.telecomnancy.Model.Utilisateur;
import eu.telecomnancy.Outils.Formater;
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
            App.error("Nom d'utilisateur ou e-mail déjà pris");
            }
        else if(username.getText().equals(""))
            {
                App.error("Veuillez entrer un nom d'utilisateur");
            }
        else if(email.getText().equals(""))
            {
                App.error("Veuillez entrer un e-mail");
            }
        else if(codepostal.getText().equals(""))
            {
                App.error("Veuillez entrer un code postal");
            }
        else if(password1.getText().equals(""))
            {
                App.error("Veuillez entrer un mot de passe");
            }
        else if(password2.getText().equals(""))
            {
                App.error("Veuillez confirmer votre mot de passe");
            }
        else{
            if (!password1.getText().equals(password2.getText())) {
                App.error("Les mots de passe ne correspondent pas");
            }
            else if (!Formater.checkPassword(password1.getText())) {
                App.error("Mot de passe trop court");
            }
            else if (!Formater.checkUsername(username.getText())) {
                App.error("Nom d'utilisateur invalide");
            }
            else if (!Formater.checkCodePostal(codepostal.getText())) {
                App.error("Code postal invalide");
            }
            else if (!Formater.checkMail(email.getText())) {
                App.error("E-mail invalide");
            }
            
            else {
                // Sinon on ajoute l'utilisateur à la base de données
                Utilisateur user = new Utilisateur(username.getText(), password1.getText(), email.getText(), codepostal.getText());
                user.saveAsNew();
                // On redirige vers la page de connexion
                App.setRoot("connect");
            }
        }
    }

    @FXML
    private void annuler() throws Exception {
        App.setRoot("connect");
    }
    
}
