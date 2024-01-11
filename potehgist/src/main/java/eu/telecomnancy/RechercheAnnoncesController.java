package eu.telecomnancy;

import eu.telecomnancy.Model.Annonce_Recherche;
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

        Annonce_Recherche recherche = new Annonce_Recherche();
        if (!annonce_recherche.getText().isEmpty()) {
            recherche.recherche_text = annonce_recherche.getText();
        }
        if (!recherche_code_postal.getText().isEmpty()) {
            recherche.recherche_code_postal = recherche_code_postal.getText();
        }
        if (recherche_date_apres.getValue() != null) {
            recherche.recherche_date_apres = recherche_date_apres.getValue().toString();
        }
        if (recherche_date_avant.getValue() != null) {
            recherche.recherche_date_avant = recherche_date_avant.getValue().toString();
        }
        recherche.recherche_materiel = recherche_materiel.isSelected();
        recherche.recherche_service = recherche_service.isSelected();
        if (!recherche_florin_min.getText().isEmpty()) {
            recherche.recherche_florin_min = Integer.parseInt(recherche_florin_min.getText());
        } else {
            recherche.recherche_florin_min = -1;
        }
        if (!recherche_florin_max.getText().isEmpty()) {
            recherche.recherche_florin_max = Integer.parseInt(recherche_florin_max.getText());
        } else {
            recherche.recherche_florin_max = -1;
        }
        if (recherche_note_min.getValue() != 0) {
            recherche.recherche_note_min = (int) recherche_note_min.getValue();
        } else {
            recherche.recherche_note_min = -1;
        }
        App.setRecherche(recherche);
        App.setTypeRecherche(TypeRecherche.ALL);
        try {
            App.setRoot("liste_annonces");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
