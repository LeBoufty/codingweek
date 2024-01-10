package eu.telecomnancy;

import java.time.LocalDate;
import java.util.Date;

import eu.telecomnancy.BDD_App.API;
import eu.telecomnancy.Model.Utilisateur;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class PlanningController {

    @FXML
    private ChoiceBox<String> Offres;

    @FXML
    private Label jour1;

    @FXML
    private Label jour1bool;

    @FXML
    private Label jour2;

    @FXML
    private Label jour2bool;

    @FXML
    private Label jour3;

    @FXML
    private Label jour3bool;

    @FXML
    private Label jour4;

    @FXML
    private Label jour4bool;

    @FXML
    private Label jour5;

    @FXML
    private Label jour5bool;

    @FXML
    private Label jour6;

    @FXML
    private Label jour6bool;

    @FXML
    private Label jour7;

    @FXML
    private Label jour7bool;


    private LocalDate[] dates;

    @FXML
    private void initialize() throws Exception{
        // Initialiser les éléments de la ChoiceBox
        Utilisateur user = App.getUser();
        int userid = user.getId();
        int [] taboffres = API.getInstance().getOffresPlanning(userid);
        for (int i = 0; i < taboffres.length; i++) {
            if(taboffres[i]!=0)
            {
                Offres.getItems().add(API.getInstance().getNomOffre(taboffres[i]));
            }  
        }
        dates = new LocalDate[7];
        dates[0] = LocalDate.now();
        dates[1] = dates[0].plusDays(1);
        dates[2] = dates[0].plusDays(2);
        dates[3] = dates[0].plusDays(3);
        dates[4] = dates[0].plusDays(4);
        dates[5] = dates[0].plusDays(5);
        dates[6] = dates[0].plusDays(6);
        jour1.setText(dates[0].toString());
        jour2.setText(dates[1].toString());
        jour3.setText(dates[2].toString());
        jour4.setText(dates[3].toString());
        jour5.setText(dates[4].toString());
        jour6.setText(dates[5].toString());
        jour7.setText(dates[6].toString());

    }

    @FXML
    private javafx.scene.control.TextArea Description;

    @FXML
    private void afficherPlanning() throws Exception {
        Utilisateur user = App.getUser();
        int userid = user.getId();
        int [] taboffres = API.getInstance().getOffresPlanning(userid);
        Date[] DatesFormatees = new Date[7]; 

        for(int i=0;i<7;i++)
        {
            DatesFormatees[i]=Date.from(dates[i].atStartOfDay().toInstant(null));
        }
        for (int i=1;i<=7;i++)
        {
            for (int j=0;j<taboffres.length;j++)
            {
                Date datedebut = API.getInstance().getdatedebut(taboffres[j]);
                Date datefin = API.getInstance().getdatefin(taboffres[j]);
                if (DatesFormatees[j].after(datedebut) && DatesFormatees[j].before(datefin))
                {
                    switch (i) {
                        case 1:
                            jour1bool.setText("Réservé");
                            break;
                        case 2:
                            jour2bool.setText("Réservé");
                            break;
                        case 3:
                            jour3bool.setText("Réservé");
                            break;
                        case 4:
                            jour4bool.setText("Réservé");
                            break;
                        case 5:
                            jour5bool.setText("Réservé");
                            break;
                        case 6:
                            jour6bool.setText("Réservé");
                            break;
                        case 7:
                            jour7bool.setText("Réservé");
                            break;
                    }
                }
                else
                {
                    switch (i) {
                        case 1:
                            jour1bool.setText("Non Réservé");
                            break;
                        case 2:
                            jour2bool.setText("Non Réservé");
                            break;
                        case 3:
                            jour3bool.setText("Non Réservé");
                            break;
                        case 4:
                            jour4bool.setText("Non Réservé");
                            break;
                        case 5:
                            jour5bool.setText("Non Réservé");
                            break;
                        case 6:
                            jour6bool.setText("Non Réservé");
                            break;
                        case 7:
                            jour7bool.setText("Non Réservé");
                            break;
                    }
                }
            }
        }
    }
    
}
