package eu.telecomnancy;

import java.io.File;

import eu.telecomnancy.BDD_App.API;
import eu.telecomnancy.Model.ImageBlob;
import eu.telecomnancy.Model.Utilisateur;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

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
    private ImageView imageView;

    @FXML
    private void updateprofile() throws Exception {

        

        Utilisateur user = App.getUser();
        // Si le nom d'utilisateur ou l'e-mail est déjà pris on affiche un message
        if(!username.getText().equals("")) {
            if (API.getInstance().usernamePris(username.getText())) {
                App.error("Nom d'utilisateur déjà pris");
            } else {
                user.setNom(username.getText());
            }
        }

        if(!email.getText().equals("")) {
            if (API.getInstance().emailPris(email.getText())) {
                App.error("E-mail déjà pris");
            } else {
                user.setEmail(email.getText());
            }
        }

        if(!password1.getText().equals("")) {
            if (!password1.getText().equals(password2.getText())) {
                App.error("Les mots de passe ne correspondent pas");
            } else {
                user.setMot_de_passe(password1.getText());
            }
        }

        if(!codepostal.getText().equals("")) {
            user.setCode_postal(codepostal.getText());
        }

        // si l'image est vide, on met une image par défaut
        if (imageView.getImage() != null) {
            user.setImage(ImageBlob.imageViewToBytes(imageView));
        }
        


        user.save();
        App.setRoot("profil");

    }
    
    @FXML
    private void returntoprofile() throws Exception {
        App.setRoot("profil");
    }

    @FXML
    private void uploadImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg")
        );

        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            // Load the selected image and set it to the ImageView
            Image image = new Image(selectedFile.toURI().toString());
            imageView.setImage(image);
        }
    }
}
