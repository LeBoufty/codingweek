package eu.telecomnancy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import eu.telecomnancy.BDD_App.API;
import eu.telecomnancy.Model.Reservation;

public class Element_EvaluationController {

    private Reservation reservation;

    @FXML
    private Button Button_validate;

    @FXML
    private Label Date_debut;

    @FXML
    private Label Date_fin;

    @FXML
    private Label Titre;

    @FXML
    private Label id;

    @FXML
    private Label id_acheteur;

    @FXML
    private Label id_offre;

    @FXML
    private Slider note;

    @FXML
    void Validate(ActionEvent event) throws Exception {
        // Regarde la note et l'ajoute à la BDD
        API.getInstance().addEvaluation(reservation.getId(), (int) note.getValue());
        // Retourne à la page d'évaluation
        App.setRoot("evaluation");

    }

    public void setData(Reservation reservation) throws Exception {
        
        this.reservation = reservation;
        Date_debut.setText(String.valueOf(reservation.getdate_debutString()));
        Date_fin.setText(String.valueOf(reservation.getdate_finString()));
        Titre.setText(reservation.getAnnonce().getTitre());
        id.setText(String.valueOf(reservation.getId()));
        String Nom_Acheteur = API.getInstance().getUsername(reservation.getId_utilisateur());
        id_acheteur.setText(Nom_Acheteur);
        id_offre.setText(String.valueOf(reservation.getId_offre()));

    }

}
