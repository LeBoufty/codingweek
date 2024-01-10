package eu.telecomnancy;

import java.io.IOException;
import java.util.Date;

import eu.telecomnancy.BDD_App.API;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HubController {

    public int[] ids;

    @FXML
    private Label description1;

    @FXML
    private Label description2;

    @FXML
    private Label description3;

    @FXML
    private Label date1;

    @FXML
    private Label date2;

    @FXML
    private Label date3;

    @FXML
    private Label vu1;

    @FXML
    private Label vu2;

    @FXML
    private Label vu3;

    @FXML
    private Label page;

    @FXML
    private Button bouton1;

    @FXML
    private Button bouton2;

    @FXML
    private Button bouton3;

    @FXML
    private Button boutonleft;

    @FXML
    private Button boutonright;

    @FXML
    private void initialize()
    {
        
        App.numpageannonce=1;
        page.setText(String.valueOf(App.numpageannonce));
        String[] messages = API.getInstance().getthreedescriptionnotif(App.getUser().getId(), App.numpageannonce);
        Date[] dates = API.getInstance().getthreedatesnotif(App.getUser().getId(), App.numpageannonce);
        ids = API.getInstance().getthreeidnotif(App.getUser().getId(), App.numpageannonce);
        if(messages!=null){
            if(messages[0]==null && messages[1]==null && messages[2]==null)
            {
                bouton1.setVisible(false);
                bouton2.setVisible(false);
                bouton3.setVisible(false);
                boutonleft.setVisible(false);
                boutonright.setVisible(false);
            }
            if(messages[0]!=null){
                if(API.getInstance().checkvunotif(ids[0]))
            {
                vu1.setText("vu");
            }
            else
            {
                vu1.setText("");
            }
                description1.setText(messages[0]);
                date1.setText(dates[0].toString());
                API.getInstance().mettrenotifenvu(ids[0]);
                 bouton1.setVisible(true);
            }
            else
            {
                description1.setText("");
                date1.setText("");
                vu1.setText("");
                bouton1.setVisible(false);
            }
            if(messages[1]!=null){
                if(API.getInstance().checkvunotif(ids[1]))
            {
                vu2.setText("vu");
            }
            else
            {
                vu2.setText("");
            }
                description2.setText(messages[1]);
                date2.setText(dates[1].toString());
                API.getInstance().mettrenotifenvu(ids[1]);
                bouton2.setVisible(true);
            }
            else
            {
                description2.setText("");
                date2.setText("");
                vu2.setText("");
                bouton2.setVisible(false);
            }
            if(messages[2]!=null){
                if(API.getInstance().checkvunotif(ids[2]))
            {
                vu3.setText("vu");
            }
            else
            {
                vu3.setText("");
            }
                description3.setText(messages[2]);
                date3.setText(dates[2].toString());
                API.getInstance().mettrenotifenvu(ids[2]);
                bouton3.setVisible(true);
            }
            else
            {
                description3.setText("");
                date3.setText("");
                vu3.setText("");
                bouton3.setVisible(false);
            }
        }
    }

    @FXML
    private void depot() throws IOException {
        App.setRoot("creationannonce");
    }

    @FXML
    private void liste_annonce() throws IOException {
        App.setTypeRecherche(TypeRecherche.ALL);
        App.setRoot("listeannonce");
    }

    @FXML
    void Nextpage() throws IOException
    {
        App.numpageannonce++;
        page.setText(String.valueOf(App.numpageannonce));
        String[] messages = API.getInstance().getthreedescriptionnotif(App.getUser().getId(), App.numpageannonce);
        Date[] dates = API.getInstance().getthreedatesnotif(App.getUser().getId(), App.numpageannonce);
        ids = API.getInstance().getthreeidnotif(App.getUser().getId(), App.numpageannonce);
        if(messages!=null){
        if(messages[0]!=null){
            if(API.getInstance().checkvunotif(ids[0]))
            {
                vu1.setText("vu");
            }
            else
            {
                vu1.setText("");
            }
            description1.setText(messages[0]);
            date1.setText(dates[0].toString());
            API.getInstance().mettrenotifenvu(ids[0]);
            bouton1.setVisible(true);
        }
        else
        {
            description1.setText("");
            date1.setText("");
            vu1.setText("");
            bouton1.setVisible(false);
        }
        if(messages[1]!=null){
            if(API.getInstance().checkvunotif(ids[1]))
            {
                vu2.setText("vu");
            }
            else
            {
                vu2.setText("");
            }
            description2.setText(messages[1]);
            date2.setText(dates[1].toString());
            API.getInstance().mettrenotifenvu(ids[1]);
            bouton2.setVisible(true);
        }
        else
        {
            description2.setText("");
            date2.setText("");
            vu2.setText("");
            bouton2.setVisible(false);
        }
        if(messages[2]!=null){
            if(API.getInstance().checkvunotif(ids[2]))
            {
                vu3.setText("vu");
            }
            else
            {
                vu3.setText("");
            }
            description3.setText(messages[2]);
            date3.setText(dates[2].toString());
            API.getInstance().mettrenotifenvu(ids[2]);
            bouton3.setVisible(true);
            
        }
        else
        {
            description3.setText("");
            date3.setText("");
            vu3.setText("");
            bouton3.setVisible(false);
        }
    }
    }

    @FXML
    void Previouspage() throws IOException
    {
        if(App.numpageannonce>1)
        {
            App.numpageannonce--;
            page.setText(String.valueOf(App.numpageannonce));
            String[] messages = API.getInstance().getthreedescriptionnotif(App.getUser().getId(), App.numpageannonce);
            Date[] dates = API.getInstance().getthreedatesnotif(App.getUser().getId(), App.numpageannonce);
            ids = API.getInstance().getthreeidnotif(App.getUser().getId(), App.numpageannonce);
            if(messages!=null){
            if(messages[0]!=null){
                if(API.getInstance().checkvunotif(ids[0]))
            {
                vu1.setText("vu");
            }
            else
            {
                vu1.setText("");
            }
            description1.setText(messages[0]);
            date1.setText(dates[0].toString());
            API.getInstance().mettrenotifenvu(ids[0]);
            }
            else
            {
                description1.setText("");
                date1.setText("");
                vu1.setText("");
                bouton1.setVisible(false);
            }
            if(messages[1]!=null){
                if(API.getInstance().checkvunotif(ids[1]))
            {
                vu2.setText("vu");
            }
            else
            {
                vu2.setText("");
            }
                description2.setText(messages[1]);
                date2.setText(dates[1].toString());
                API.getInstance().mettrenotifenvu(ids[1]);
            }
            else
            {
                description2.setText("");
                date2.setText("");
                vu2.setText("");
            }
            if(messages[2]!=null){
                if(API.getInstance().checkvunotif(ids[2]))
            {
                vu3.setText("vu");
            }
            else
            {
                vu3.setText("");
            }
                description3.setText(messages[2]);
                date3.setText(dates[2].toString());
                API.getInstance().mettrenotifenvu(ids[2]);
            }
            else
            {
                description3.setText("");
                date3.setText("");
                vu3.setText("");
            }
        }
    }
    }
    public void del1()
    {
        API.getInstance().dlnotif(ids[0]);
    }

    public void del2()
    {
        API.getInstance().dlnotif(ids[1]);
    }

    public void del3()
    {
        API.getInstance().dlnotif(ids[2]);
    }
}