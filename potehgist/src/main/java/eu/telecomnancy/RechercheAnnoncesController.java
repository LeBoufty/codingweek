package eu.telecomnancy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class RechercheAnnoncesController {

    @FXML
    private TextField annonce_recherche;

    @FXML
    private TextField recherche_code_postal;

    @FXML
    private DatePicker recherche_date_apres;

    @FXML
    private DatePicker recherche_date_avant;

    @FXML
    private CheckBox recherche_materiel;

    @FXML
    private CheckBox recherche_service;

    @FXML
    private TextField recherche_florin_min;

    @FXML
    private TextField recherche_florin_max;

    @FXML
    private Slider recherche_note_min;

    @FXML
    void recherche_button(ActionEvent event) {
        System.out.println("recherche_button clicked");
        System.out.println("recherche_text: " + annonce_recherche.getText() + " recherche_code_postal: "
                + recherche_code_postal.getText() + " recherche_date_apres: " + recherche_date_apres.getValue()
                + " recherche_date_avant: " + recherche_date_avant.getValue() + " recherche_materiel: "
                + recherche_materiel.isSelected() + " recherche_service: " + recherche_service.isSelected()
                + " recherche_florin_min: " + recherche_florin_min.getText() + " recherche_florin_max: "
                + recherche_florin_max.getText());
        
        App.setAnnonce_recherche(annonce_recherche.getText(), recherche_code_postal.getText(), recherche_date_apres.getValue(), recherche_date_avant.getValue(), recherche_materiel.isSelected(), recherche_service.isSelected(), recherche_florin_min.getText(), recherche_florin_max.getText());
    }

}
