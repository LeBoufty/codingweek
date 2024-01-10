package eu.telecomnancy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;

public class element_planing_addController {

    private CreationAnnonce_Planning_Service parent_controller;

    public void setParent_controller(CreationAnnonce_Planning_Service parent_controller) {
        this.parent_controller = parent_controller;
    }

    @FXML
    private HBox box;



    @FXML
    void maximum(ActionEvent event) {
        parent_controller.notif_add();
    }

}
