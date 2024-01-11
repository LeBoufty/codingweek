package eu.telecomnancy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CreationAnnonce_Planning_Service {

    private int type_planning_int = 0;

    @FXML
    private VBox layout_planning_service;

    @FXML
    private ChoiceBox<String> type_planning;

    @FXML
    private Button button_planning_select;

    public void initialize() {
        type_planning.getItems().addAll("Ponctuel", "Récurrent");

    }

    @FXML
    void create_annonce(ActionEvent event) {
        System.out.println("Create annonce");
    }

    @FXML
    void select_planning_action(ActionEvent event) {
        System.out.println("Select planning");
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
    }


}
