package eu.telecomnancy;

import java.time.Instant;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;

import eu.telecomnancy.Model.Date;

public class CreationAnnonce_Planning_Materiel {

    @FXML
    private DatePicker date_debut;

    @FXML
    private DatePicker date_fin;

    @FXML
    void create_annonce(ActionEvent event) {
        System.out.println("Create annonce materiel");

        // Test avec le module date
        Date date = new Date(Instant.now().getEpochSecond());
        System.out.println(Date.getDate_FXML(date_debut.getValue()));
        System.out.println(Date.getDate_FXML(date_fin.getValue()));
    }

}