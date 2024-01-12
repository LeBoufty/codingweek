package eu.telecomnancy;

import java.io.File;

import eu.telecomnancy.Model.Annonce_en_creation;
import eu.telecomnancy.Model.ImageBlob;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

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

    private boolean checkinteger(String s)
        {
            try {
                Integer.parseInt(s);
            } catch (NumberFormatException e) {
                return false;
            } catch (NullPointerException e) {
                return false;
            }
            return true;
        }
    
    private boolean checkbox(ChoiceBox<String> box)
        {
            try {
                if(box.getValue().equals(null))
                {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            } catch (NullPointerException e) {
                return false;
            }
            return true;
        }


    @FXML
    private void create() throws Exception {
        // //System.Out.println("Création de l'annonce");
        // //System.Out.println("Nom : " + name.getText());
        // //System.Out.println("Description : " + Description.getText());
        // //System.Out.println("Prix : " + prix.getText());
        // //System.Out.println("Catégorie : " + categorie.getValue());
        // //System.Out.println("Vendeur : " + App.getUser().getId());
        //API.getInstance().addOffre(name.getText(), Description.getText(), Integer.parseInt(prix.getText()), App.getUser().getId(), categorie.getValue(), ImageBlob.imageViewToBytes(imageView)); 


        // si l'image est vide, on met une image par défaut
        if (imageView.getImage() == null) {
            Image image = new Image(getClass().getResource("/eu/telecomnancy/assets/placeholder.png").toExternalForm());
            imageView.setImage(image);
        }
        
        if(!checkinteger(prix.getText()))
        {
            prix.setText("Entrer un entier pour le prix");
        }
        else
        {
           if(checkbox(categorie))
            {
                App.annonce_en_creation = new Annonce_en_creation(name.getText(), Description.getText(), Integer.parseInt(prix.getText()), ImageBlob.imageViewToBytes(imageView), categorie.getValue());
            if (categorie.getValue().equals("Matériel")) {
                App.setRoot("creationannonce_planning_materiel");
            } else {
                App.setRoot("creationannonce_planning_service");
            }
            }
            
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
