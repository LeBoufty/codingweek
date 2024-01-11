package eu.telecomnancy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import eu.telecomnancy.BDD_App.API;
import eu.telecomnancy.Model.Reservation;
import eu.telecomnancy.Model.Utilisateur;

public class PrereservationVendeurItemController {

    private Reservation reservation;

    private boolean isVendeur;

    @FXML
    private Label Date_debut;

    @FXML
    private Label Date_fin;

    @FXML
    private Label Titre;

    @FXML
    private Label id_acheteur;

    @FXML
    private Label id_offre;

    @FXML
    private Label id;

    @FXML
    private Button Button_validate;

    @FXML
    void Refuse(ActionEvent event) throws Exception {
        Utilisateur user = new Utilisateur(reservation.getId_utilisateur());
        user.addArgent(reservation.getAnnonce().getPrix());
        isVendeur = isVendeur();
        API.getInstance().deletePreReservation(reservation.getId());
        if (isVendeur) {
            App.setRoot("prereservationvendeur");
        }
        else {
            App.setRoot("prereservationuser");
        }
    }

    @FXML
    void Validate(ActionEvent event) throws Exception{
        App.getUser().addArgent(reservation.getAnnonce().getPrix());
        isVendeur = isVendeur();
        API.getInstance().acceptPreReservation(reservation.getId());
        if (isVendeur) {
            App.setRoot("prereservationvendeur");
        }
        else {
            App.setRoot("prereservationuser");
        }
    }

    public void setData(Reservation reservation) throws Exception {
        this.reservation = reservation;

        Titre.setText(reservation.getAnnonce().getTitre());
        id_offre.setText(String.valueOf(reservation.getId_offre()));
        id.setText(String.valueOf(reservation.getId()));
        String Nom_Acheteur = API.getInstance().getUsername(reservation.getId_utilisateur());
        id_acheteur.setText(Nom_Acheteur);
        Date_debut.setText(String.valueOf(reservation.getdate_debutString()));
        Date_fin.setText(String.valueOf(reservation.getdate_finString()));

        if (App.getUser().getId() == reservation.getId_utilisateur()) {
            Button_validate.setVisible(false);
        }
    }

    public void showAnnonce(ActionEvent event) throws Exception {
        App.setidannonce(reservation.getId_offre());
        App.setRoot("annonce");
    }

    public boolean isVendeur() throws Exception{
        if (App.getUser().getId() != API.getInstance().getPreReservationUserId(Integer.parseInt(id_offre.getText()))) {
            return true;
        }
        return false;
    }
}