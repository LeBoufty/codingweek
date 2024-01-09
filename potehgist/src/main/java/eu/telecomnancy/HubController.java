package eu.telecomnancy;

import java.io.IOException;
import java.util.Date;

import eu.telecomnancy.BDD_App.API;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HubController {


    @FXML
    private Label description1;

    @FXML
    private Label description2;

    @FXML
    private Label description3;

    @FXML
    private Label description4;

    @FXML
    private Label date1;

    @FXML
    private Label date2;

    @FXML
    private Label date3;

    @FXML
    private Label date4;

    @FXML
    private Label page;

    @FXML
    private void initialize()
    {
        
        App.numpageannonce=1;
        page.setText(String.valueOf(App.numpageannonce));
        String[] messages = API.getInstance().getthreedescriptionnotif(App.getUser().getId(), App.numpageannonce);
        Date[] dates = API.getInstance().getthreedatesnotif(App.getUser().getId(), App.numpageannonce);
        int[] ids = API.getInstance().getthreeidnotif(App.getUser().getId(), App.numpageannonce);
        if(messages!=null){
            if(messages[0]!=null){
                description1.setText(messages[0]);
                date1.setText(dates[0].toString());
                API.getInstance().mettrenotifenvu(ids[0]);
            }
            if(messages[1]!=null){
                description2.setText(messages[1]);
                date2.setText(dates[1].toString());
                API.getInstance().mettrenotifenvu(ids[1]);
            }
            if(messages[2]!=null){
                description3.setText(messages[2]);
                date3.setText(dates[2].toString());
                API.getInstance().mettrenotifenvu(ids[2]);
            }
            if(messages[3]!=null){
                description4.setText(messages[3]);
                date4.setText(dates[3].toString());
                API.getInstance().mettrenotifenvu(ids[3]);
            }
        }
    }

    @FXML
    private void depot() throws IOException {
        App.setRoot("creationannonce");
    }

    @FXML
    private void liste_annonce() throws IOException {
        App.setRoot("listeannonce");
    }

    @FXML
    void Nextpage() throws IOException
    {
        App.numpageannonce++;
        page.setText(String.valueOf(App.numpageannonce));
        String[] messages = API.getInstance().getthreedescriptionnotif(App.getUser().getId(), App.numpageannonce);
        Date[] dates = API.getInstance().getthreedatesnotif(App.getUser().getId(), App.numpageannonce);
        int[] ids = API.getInstance().getthreeidnotif(App.getUser().getId(), App.numpageannonce);
        if(messages!=null){
        if(messages[0]!=null){
            description1.setText(messages[0]);
            date1.setText(dates[0].toString());
            API.getInstance().mettrenotifenvu(ids[0]);
        }
        else
        {
            description1.setText("");
            date1.setText("");
        }
        if(messages[1]!=null){
            description2.setText(messages[1]);
            date2.setText(dates[1].toString());
            API.getInstance().mettrenotifenvu(ids[1]);
        }
        else
        {
            description2.setText("");
            date2.setText("");
        }
        if(messages[2]!=null){
            description3.setText(messages[2]);
            date3.setText(dates[2].toString());
            API.getInstance().mettrenotifenvu(ids[2]);
        }
        else
        {
            description3.setText("");
            date3.setText("");
        }
        if(messages[3]!=null){
            description4.setText(messages[3]);
            date4.setText(dates[3].toString());
            API.getInstance().mettrenotifenvu(ids[3]);
        }
        else
        {
            description4.setText("");
            date4.setText("");
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
            int[] ids = API.getInstance().getthreeidnotif(App.getUser().getId(), App.numpageannonce);
            if(messages!=null){
            if(messages[0]!=null){
            description1.setText(messages[0]);
            date1.setText(dates[0].toString());
            API.getInstance().mettrenotifenvu(ids[0]);
            }
            else
            {
                description1.setText("");
                date1.setText("");
            }
            if(messages[1]!=null){
                description2.setText(messages[1]);
                date2.setText(dates[1].toString());
                API.getInstance().mettrenotifenvu(ids[1]);
            }
            else
            {
                description2.setText("");
                date2.setText("");
            }
            if(messages[2]!=null){
                description3.setText(messages[2]);
                date3.setText(dates[2].toString());
                API.getInstance().mettrenotifenvu(ids[2]);
            }
            else
            {
                description3.setText("");
                date3.setText("");
            }
            if(messages[3]!=null)
            {
                description4.setText(messages[3]);
                date4.setText(dates[3].toString());
                API.getInstance().mettrenotifenvu(ids[3]);
            }
            else
            {
                description4.setText("");
                date4.setText("");
            }
        }
    }
    }
}