package eu.telecomnancy;

import java.time.LocalDate;
import java.util.Date;

import eu.telecomnancy.BDD_App.API;
import eu.telecomnancy.Model.Utilisateur;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class PlanningController {

    public int currentpage=1;

    @FXML
    private ChoiceBox<String> Offres;

    @FXML
    private Label Page;

    @FXML
    private Label jour1;

    @FXML
    private Label jour2;

    @FXML
    private Label jour3;

    @FXML
    private Label jour4;

    @FXML
    private Label jour5;

    @FXML
    private Label jour6;

    @FXML
    private Label jour7;


    private LocalDate[] dates;


    @FXML
    private javafx.scene.control.TextArea Description;



    @FXML
    private void initialize() throws Exception{
        Page.setText(Integer.toString(currentpage));
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
        dates[0] = LocalDate.now().plusDays((currentpage-1)*7);
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
    private void pageSuivante() throws Exception {
        currentpage++;
        Page.setText(Integer.toString(currentpage));
        initialize();
    }

    @FXML
    private void pagePrecedente() throws Exception {
        if (currentpage > 1) {
            currentpage--;
            Page.setText(Integer.toString(currentpage));
        }
        initialize();
    }

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
                
            }
        }
    }
    
}
