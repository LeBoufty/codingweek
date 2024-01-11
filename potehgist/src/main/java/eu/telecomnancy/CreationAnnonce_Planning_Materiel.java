package eu.telecomnancy;

import java.time.Instant;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import eu.telecomnancy.BDD_App.API;
import eu.telecomnancy.Model.Date;

public class CreationAnnonce_Planning_Materiel {

    @FXML
    private DatePicker date_debut;

    @FXML
    private DatePicker date_fin;

    @FXML
    void create_annonce(ActionEvent event) throws Exception {
        System.out.println("Create annonce materiel");
        App.annonce_en_création.date_debut_materiel = Date.getDate_FXML(date_debut.getValue());
        App.annonce_en_création.date_fin_materiel = Date.getDate_FXML(date_fin.getValue());
        API.getInstance().addOffre(App.annonce_en_création);
        System.out.println("Request sent to API to add annonce");
        API.getInstance().addPlaningMateriel(App.annonce_en_création);
        System.out.println("Request sent to API to add planning");
        App.setRoot("hub");
    }

}