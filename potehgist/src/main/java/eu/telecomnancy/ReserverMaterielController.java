package eu.telecomnancy;

import java.time.LocalDate;
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
    private TextField minute_debut;

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
        //System.out.println(dates.size());
        if(dates.size() == 0)
        {
            debut_dispo.setText("Pas de date disponible");
            fin_dispo.setText("Pas de date disponible");
        }
        else
        {
            int debut=(int)dates.get(0).date;
            int fin=(int)dates.get(1).date;
            Date_M date = new Date_M(debut);
            String aff=date.getAlldateJJMMAAAA();
            debut_dispo.setText(aff);
            date = new Date_M(fin);
            aff=date.getAlldateJJMMAAAA();
            fin_dispo.setText(aff);
        }
        App.currentannonce = annonce.getId();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("planningreservation.fxml"));

        HBox hbox = loader.load();
        
        //PlanningReservationController controller = loader.getController();
        
        planning.getChildren().add(hbox);

        date_debut.setValue(LocalDate.now());
        date_fin.setValue(LocalDate.now().plusDays(1));
    }


    @FXML
    public void reserver() throws Exception{
        Date_M date_debut = new Date_M(this.date_debut.getValue().getYear(), this.date_debut.getValue().getMonthValue(), this.date_debut.getValue().getDayOfMonth(), Integer.parseInt(heure_debut.getText()), Integer.parseInt(minute_debut.getText()));
        Date_M date_fin = new Date_M(this.date_fin.getValue().getYear(), this.date_fin.getValue().getMonthValue(), this.date_fin.getValue().getDayOfMonth(), Integer.parseInt(heure_fin.getText()), Integer.parseInt(minute_fin.getText()));

        int nb_hours = Date_M.getNbHours(date_debut, date_fin);

        if (App.getUser().removeArgent(App.getAnnonce().getPrix()*nb_hours)){
            API.getInstance().addPreReservation(App.getUser().getId(), App.getAnnonce().getId(),(int)date_debut.getDate(),(int)date_fin.getDate());
            App.setRoot("hub");
        } else {
            App.error("Vous n'avez pas assez d'argent pour effectuer cette réservation");
        }
    }
}

