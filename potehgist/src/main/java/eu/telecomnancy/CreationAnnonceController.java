package eu.telecomnancy;

import eu.telecomnancy.BDD_App.API;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class CreationAnnonceController {

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
        System.out.println("Création de l'annonce");
        System.out.println("Nom : " + name.getText());
        System.out.println("Description : " + Description.getText());
        System.out.println("Prix : " + prix.getText());
        System.out.println("Catégorie : " + categorie.getValue());
        System.out.println("Vendeur : " + App.getUser().getId());
        API.getInstance().addOffre(name.getText(), Description.getText(), Integer.parseInt(prix.getText()), App.getUser().getId(), categorie.getValue());
        App.setRoot("hub");
    }
    
}
