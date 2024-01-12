package eu.telecomnancy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import eu.telecomnancy.Model.Date_M;

public class element_planing_recurrentController {
    
    private CreationAnnonce_Planning_Service parent_controller;

    public void setParent_controller(CreationAnnonce_Planning_Service parent_controller) {
        this.parent_controller = parent_controller;
    }

    @FXML
    private DatePicker date_debut_rec;

    @FXML
    private DatePicker date_fin_rec;

    @FXML
    private TextField heure_rec;

    @FXML
    private ChoiceBox<String> jour_semaine;

    @FXML
    private TextField minute_rec;

    @FXML
    private HBox box_ponctuel;

    @FXML
    void minus_recurrent(ActionEvent event) {
        int num_int = box_ponctuel.getParent().getChildrenUnmodifiable().indexOf(box_ponctuel);
        parent_controller.notif_sup(num_int);
    }

    public void initialize() {
        jour_semaine.getItems().addAll("Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche");
    }

    public ArrayList<Long> get_date_debut() {
        // Renvoie les dates de debut en fonction du jour de la semaine sélectionné entre les deux dates
        ArrayList<Long> dates = new ArrayList<Long>();
        int jour_semaine_int = 0;
        if (jour_semaine.getValue() == "Lundi") {
            jour_semaine_int = 1;
        }
        if (jour_semaine.getValue() == "Mardi") {
            jour_semaine_int = 2;
        }
        if (jour_semaine.getValue() == "Mercredi") {
            jour_semaine_int = 3;
        }
        if (jour_semaine.getValue() == "Jeudi") {
            jour_semaine_int = 4;
        }
        if (jour_semaine.getValue() == "Vendredi") {
            jour_semaine_int = 5;
        }
        if (jour_semaine.getValue() == "Samedi") {
            jour_semaine_int = 6;
        }
        if (jour_semaine.getValue() == "Dimanche") {
            jour_semaine_int = 7;
        }
        List<Integer> dates_int = getDatesByDayOfWeek((int) date_debut_rec.getValue().toEpochDay(), (int) date_fin_rec.getValue().toEpochDay(), jour_semaine_int);
        for (int date_int_t : dates_int) {
            Date_M date = new Date_M(LocalDate.ofEpochDay(date_int_t), Integer.parseInt(heure_rec.getText()), Integer.parseInt(minute_rec.getText()));
            dates.add(date.getDate());
        }

        return dates;
    }

    public static ArrayList<Integer> getDatesByDayOfWeek(int start, int end, int dayOfWeek) {
        ArrayList<Integer> result = new ArrayList<>();

        // Convertir les dates en objets LocalDate
        LocalDate startDate = LocalDate.ofEpochDay(start);
        LocalDate endDate = LocalDate.ofEpochDay(end);

        // Convertir le numéro du jour en DayOfWeek
        DayOfWeek targetDay = DayOfWeek.of(dayOfWeek);

        // Parcourir toutes les dates entre startDate et endDate
        while (!startDate.isAfter(endDate)) {
            // Vérifier si la date correspond au jour de la semaine spécifié
            if (startDate.getDayOfWeek() == targetDay) {
                // Ajouter la date (en int) à la liste de résultats
                result.add((int) startDate.toEpochDay());
            }

            // Passer à la journée suivante
            startDate = startDate.plus(1, ChronoUnit.DAYS);
        }

        return result;
    }
}
