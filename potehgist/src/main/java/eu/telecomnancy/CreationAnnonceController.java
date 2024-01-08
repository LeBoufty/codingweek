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
        API.getInstance().addOffre(name.getText(), Description.getText(), Integer.parseInt(prix.getText()), App.getUserid(), categorie.getValue());
        App.setRoot("hub");
    }
    
}
