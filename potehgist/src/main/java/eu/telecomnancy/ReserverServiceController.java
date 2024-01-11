package eu.telecomnancy;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import eu.telecomnancy.Model.Date_M;

import java.util.ArrayList;

import eu.telecomnancy.BDD_App.API;

public class ReserverServiceController {

    public ArrayList<Integer> planning_restant = new ArrayList<Integer>();

    @FXML
    private Label Description;

    @FXML
    private Label Prix;

    @FXML
    private Label Titre;

    @FXML
    private VBox vbox_layout;

    public void initialize() throws Exception{
        int id = App.getAnnonce().getId();
        Description.setText(App.getAnnonce().getDescription());
        Prix.setText(App.getAnnonce().getPrix().toString());
        Titre.setText(App.getAnnonce().getTitre());

        planning_restant = API.getInstance().getDatePlaningServiceRestant(id);
        for(int i = 0; i < planning_restant.size(); i++){

            ArrayList<Date_M> date = API.getInstance().getDatePlaningServiceRestantDate(planning_restant.get(i));
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("element_reserver_service.fxml"));

            HBox hbox = loader.load();
            element_reserver_serviceController controller = loader.getController();
            controller.date_debut = (int) date.get(0).getDate();
            controller.date_fin = (int) date.get(1).getDate();
            controller.id_offre = id;
            controller.initialize();

            vbox_layout.getChildren().add(hbox);
        }
        
    }
    

}
