package eu.telecomnancy;

import java.io.IOException;

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
    private javafx.scene.control.TextField Description;

    @FXML
    private void create() throws IOException {

        System.out.println(name.getText()+"\n"+prix.getText()+"\n"+categorie.getValue()+"\n"+Description.getText());
    }
    
}
