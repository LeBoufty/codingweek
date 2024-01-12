package eu.telecomnancy;

import java.time.ZoneId;

import eu.telecomnancy.Model.Annonce_Recherche;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class RechercheAnnoncesController {

    @FXML
    private CheckBox Checkbox_Codepostal;

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
    void checkbox_Codepostal(ActionEvent event) {
        if (Checkbox_Codepostal.isSelected()){
            recherche_code_postal.setDisable(true);
        } else {
            recherche_code_postal.setDisable(false);
        }
    }

    @FXML
    void recherche_button(ActionEvent event) {
        //System.out.println("recherche_button clicked");
        //System.out.println("recherche_text: " + annonce_recherche.getText() + " recherche_code_postal: "
        // + recherche_code_postal.getText() + " recherche_date_apres: " + recherche_date_apres.getValue()
        // + " recherche_date_avant: " + recherche_date_avant.getValue() + " recherche_materiel: "
        // + recherche_materiel.isSelected() + " recherche_service: " + recherche_service.isSelected()
        // + " recherche_florin_min: " + recherche_florin_min.getText() + " recherche_florin_max: "
        // + recherche_florin_max.getText());

        Annonce_Recherche recherche = new Annonce_Recherche();
        if(!annonce_recherche.getText().equals(""))
        {
            recherche.recherche_text = annonce_recherche.getText();
        }
        if (Checkbox_Codepostal.isSelected()){
            recherche.recherche_code_postal = App.getUser().getCode_postal();
        }
        else if (!recherche_code_postal.getText().equals("")){
            recherche.recherche_code_postal = recherche_code_postal.getText();
        }
        if(recherche_date_apres.getValue()!=null)
        {
            recherche.recherche_date_apres = (int)recherche_date_apres.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant().getEpochSecond();
        }
        if(recherche_date_avant.getValue()!=null)
        {
            recherche.recherche_date_avant = (int)recherche_date_avant.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant().getEpochSecond();
        }
        if(recherche_materiel.isSelected())
        {
            recherche.recherche_materiel = recherche_materiel.isSelected();
        }
        if(recherche_service.isSelected())
        {
            recherche.recherche_service = recherche_service.isSelected();
        }
        if(!recherche_florin_min.getText().equals(""))
        {
            recherche.recherche_florin_min = Integer.parseInt(recherche_florin_min.getText());
        }
        if(!recherche_florin_max.getText().equals(""))
        {
            recherche.recherche_florin_max = Integer.parseInt(recherche_florin_max.getText());
        }
        if(recherche_note_min.getValue()!=0)
        {   
            recherche.recherche_note_min = (double) recherche_note_min.getValue();
        }
        App.setRecherche(recherche);
        App.setTypeRecherche(TypeRecherche.ALL);
        try {
            App.setRoot("listeannonce");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
