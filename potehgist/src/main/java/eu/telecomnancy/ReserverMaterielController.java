package eu.telecomnancy;

import java.util.List;

import eu.telecomnancy.BDD_App.API;
import eu.telecomnancy.Model.Annonce;
import eu.telecomnancy.Model.Date_M;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ReserverMaterielController {

    @FXML
    private Label Description;

    @FXML
    private Label Prix;

    @FXML
    private Label Titre;
    
    @FXML
    private DatePicker date_debut;

    @FXML
    private DatePicker date_fin;

    @FXML
    private Label debut_dispo;

    @FXML
    private Label fin_dispo;

    @FXML
    private TextField heure_debut;

    @FXML
    private TextField heure_fin;

    @FXML
    private TextField minute_fin;

    @FXML
    private VBox planning;

    public void initialize() throws Exception {
        Annonce annonce = App.getAnnonce();
        Description.setText(annonce.getDescription());
        Prix.setText(annonce.getPrix().toString());
        Titre.setText(annonce.getTitre());

        List<Date_M> dates = API.getInstance().getDatePlaningOffre(annonce.getId());
        System.out.println(dates.size());
        if(dates.size() == 0)
        {
            debut_dispo.setText("Pas de date disponible");
            fin_dispo.setText("Pas de date disponible");
        }
        else
        {
            debut_dispo.setText(dates.get(0).toString());
            fin_dispo.setText(dates.get(1).toString());
        }
        App.currentannonce = annonce.getId();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("planningreservation.fxml"));

        HBox hbox = loader.load();
        
        PlanningReservationController controller = loader.getController();
        
        planning.getChildren().add(hbox);
    }

}

