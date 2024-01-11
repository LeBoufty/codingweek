package eu.telecomnancy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import eu.telecomnancy.BDD_App.API;
import eu.telecomnancy.Model.Date_M;

public class CreationAnnonce_Planning_Materiel {

    @FXML
    private DatePicker date_debut;

    @FXML
    private DatePicker date_fin;

    @FXML
    void create_annonce(ActionEvent event) throws Exception {
        System.out.println("Create annonce materiel");
        App.annonce_en_creation.date_debut_materiel = Date_M.getDate_FXML(date_debut.getValue());
        App.annonce_en_creation.date_fin_materiel = Date_M.getDate_FXML(date_fin.getValue());
        API.getInstance().addOffre(App.annonce_en_creation);
        System.out.println("Request sent to API to add annonce");
        API.getInstance().addPlaningMateriel(App.annonce_en_creation);
        System.out.println("Request sent to API to add planning");
        App.setRoot("hub");
    }

}