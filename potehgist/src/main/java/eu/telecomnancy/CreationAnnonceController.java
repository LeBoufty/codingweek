package eu.telecomnancy;

import java.io.File;

import eu.telecomnancy.BDD_App.API;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.scene.image.ImageView;
import eu.telecomnancy.Model.ImageBlob;
import eu.telecomnancy.Model.Annonce_en_creation;

public class CreationAnnonceController {

    @FXML
    private ImageView imageView;

    @FXML
    private javafx.scene.control.TextField name;

    @FXML
    private javafx.scene.control.TextField prix;

    @FXML
    private ChoiceBox<String> categorie;

    @FXML
    private void initialize() {
    // Initialiser les éléments de la ChoiceBox
    categorie.getItems().addAll("Matériel", "Service");
}

    @FXML
    private javafx.scene.control.TextArea Description;

    @FXML
    private void create() throws Exception {
        // System.out.println("Création de l'annonce");
        // System.out.println("Nom : " + name.getText());
        // System.out.println("Description : " + Description.getText());
        // System.out.println("Prix : " + prix.getText());
        // System.out.println("Catégorie : " + categorie.getValue());
        // System.out.println("Vendeur : " + App.getUser().getId());
        //API.getInstance().addOffre(name.getText(), Description.getText(), Integer.parseInt(prix.getText()), App.getUser().getId(), categorie.getValue(), ImageBlob.imageViewToBytes(imageView));

        
        // si l'image est vide, on met une image par défaut
        if (imageView.getImage() == null) {
            Image image = new Image(getClass().getResource("/eu/telecomnancy/assets/placeholder.png").toExternalForm());
            imageView.setImage(image);
        }

        App.annonce_en_création = new Annonce_en_creation(name.getText(), Description.getText(), Integer.parseInt(prix.getText()), ImageBlob.imageViewToBytes(imageView), categorie.getValue());
        if (categorie.getValue().equals("Matériel")) {
            App.setRoot("creationannonce_planning_materiel");
        } else {
            App.setRoot("creationannonce_planning_service");
        }
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
