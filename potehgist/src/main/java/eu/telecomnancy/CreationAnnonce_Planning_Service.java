package eu.telecomnancy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class CreationAnnonce_Planning_Service {

    private int type_planning_int = 0; // 1 = ponctuel, 2 = recurrent
    private ArrayList<element_planing_ponctuelController> ponctuels;
    private ArrayList<element_planing_recurrentController> recurrents;
    @FXML
    private VBox layout_planning_service;

    @FXML
    private ChoiceBox<String> type_planning;

    @FXML
    private Button button_planning_select;

    @FXML
    private TextField nb_minute_service;

    public void initialize() {
        type_planning.getItems().addAll("Ponctuel", "Récurrent");
        // type_planning.getItems().add("Ponctuel");
    }

    @FXML
    void create_annonce(ActionEvent event) throws Exception {
        try {
        System.out.println("Create annonce service");
        if (type_planning_int == 1) {
            // Va chercher les infos des ponctuels
            ArrayList<Long> dates = new ArrayList<Long>();
            for (element_planing_ponctuelController ponctuel : ponctuels) {
                System.out.println(ponctuel.get_date());
                dates.add(ponctuel.get_date());
            }
            int nb_minutes = Integer.parseInt(nb_minute_service.getText());
            App.annonce_en_creation.date_debut_service_ponctuel = dates;
            App.annonce_en_creation.nb_minute_service = nb_minutes;
            App.annonce_en_creation.create_annonce();

            App.setRoot("hub");
        }
        if (type_planning_int == 2) {
            // Va chercher les infos des recurrents
            ArrayList<Long> dates_debut = new ArrayList<Long>();
            ArrayList<Long> dates_fin = new ArrayList<Long>();

            for (element_planing_recurrentController recurrent : recurrents) {
                ArrayList<Long> dates = recurrent.get_date_debut();
                for (Long date : dates) {
                    dates_debut.add(date);
                    dates_fin.add(date + (Integer.parseInt(nb_minute_service.getText()) * 60 * 1000));
                }
            }

            App.annonce_en_creation.date_debut_service_ponctuel = dates_debut;
            App.annonce_en_creation.nb_minute_service = Integer.parseInt(nb_minute_service.getText());
            App.annonce_en_creation.create_annonce();

            App.setRoot("hub");

        }

        } catch (Exception e) {
            App.error("Erreur lors de la création de l'annonce");
            e.printStackTrace();
        }
    }

    @FXML
    void select_planning_action(ActionEvent event) {
        System.out.println("Select planning");
        ponctuels = new ArrayList<element_planing_ponctuelController>();
        recurrents = new ArrayList<element_planing_recurrentController>();

        FXMLLoader loader = new FXMLLoader();

        try {
        if (type_planning.getValue() == null) {
            return;
        }
        loader.setLocation(getClass().getResource("element_planing_add.fxml"));
        HBox hbox = loader.load();
        
        element_planing_addController controller = loader.getController();
        controller.setParent_controller(this);

        layout_planning_service.getChildren().clear();
        layout_planning_service.getChildren().add(hbox);

        if (type_planning.getValue().equals("Ponctuel")) {
            type_planning_int = 1;        
        } else {
            type_planning_int = 2;
        }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void notif_add() {
        System.out.println("Notif add");
        layout_planning_service.getChildren().remove(layout_planning_service.getChildren().size()-1); // remove the add button

        if (type_planning_int == 1) {
            FXMLLoader loader = new FXMLLoader();
            try {
                loader.setLocation(getClass().getResource("element_planing_ponctuel.fxml"));
                HBox hbox = loader.load();
                element_planing_ponctuelController controllerr = loader.getController();
                controllerr.setParent_controller(this);
                ponctuels.add(controllerr);
                
                layout_planning_service.getChildren().add(hbox);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            FXMLLoader loader = new FXMLLoader();
            try {
                loader.setLocation(getClass().getResource("element_planing_recurrent.fxml"));
                HBox hbox = loader.load();
                element_planing_recurrentController controllerr = loader.getController();
                controllerr.setParent_controller(this);
                recurrents.add(controllerr);

                layout_planning_service.getChildren().add(hbox);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // add the add button
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("element_planing_add.fxml"));
        try {
            HBox hbox = loader.load();
            element_planing_addController controller = loader.getController();
            controller.setParent_controller(this);
            layout_planning_service.getChildren().add(hbox);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void notif_sup(int numero) {
        System.out.println("Notif sup" + numero);
        layout_planning_service.getChildren().remove(numero);

        if (type_planning_int == 1) {
            ponctuels.remove(numero);
        } else {
            recurrents.remove(numero);
        }
    }


}
