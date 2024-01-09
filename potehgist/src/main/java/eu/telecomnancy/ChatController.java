package eu.telecomnancy;

import java.time.LocalDate;

import eu.telecomnancy.BDD_App.API;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


public class ChatController {

    @FXML
    private TextArea message_a_envoyer;

    @FXML
    private TextField nomutilisateur;

    @FXML
    private Text message_recu1;

    @FXML
    private Text message_recu2;

    @FXML
    private Text message_recu3;

    @FXML
    private Text message_recu4;

    @FXML
    private Label emeteur1;

    @FXML
    private Label emeteur2;

    @FXML
    private Label emeteur3;

    @FXML
    private Label emeteur4;
    
    @FXML
    private Label page;

    @FXML
    private Label nomuser2;
    


    @FXML
    private void initialize() {
        message_recu1.setText("");
        message_recu2.setText("");
        message_recu3.setText("");
        message_recu4.setText("");
        emeteur1.setText("");
        emeteur2.setText("");
        emeteur3.setText("");
        emeteur4.setText("");
        App.numpagechat = 1;
        page.setText(Integer.toString(App.numpagechat));
    }

    @FXML
    private void chargerconvo() throws Exception {
        App.setUser2(API.getInstance().getUserid(nomutilisateur.getText().toString()));
        if(App.getUser2id() != 0) {
            App.numpagechat = 1;
            page.setText(Integer.toString(App.numpagechat));
            nomuser2.setText(nomutilisateur.getText());
            nomutilisateur.setText("");
            
            String[] messages = API.getInstance().getmessages(App.getUser().getId(), App.getUser2id(),App.numpagechat);
            System.out.println("\nVoici les messages: "+messages+"\n");
            if(messages!=null)
            {
                
                if(messages[3] != null)
                {
                    message_recu1.setText(messages[3]);
                    emeteur1.setText(nomutilisateur.getText());
                }
                if(messages[2] != null)
                {
                    message_recu2.setText(messages[2]);
                    emeteur2.setText(nomutilisateur.getText());
                }
                if(messages[1] != null)
                {
                    message_recu3.setText(messages[1]);
                    emeteur3.setText(nomutilisateur.getText());
                }
                if(messages[0] != null)
                {
                    message_recu4.setText(messages[0]);
                    emeteur4.setText(nomutilisateur.getText());
                }
            }
            
        } 
    }

    @FXML
    private void envoyermessage()
    {
        if(App.getUser2id() != 0) {
            String message = message_a_envoyer.getText();
            App.numpagechat = 1;
            LocalDate date = LocalDate.now();
            java.sql.Date Datemessage=java.sql.Date.valueOf(date);;
            API.getInstance().addmessage(App.getUser().getId(), App.getUser2id(), message, Datemessage);
            message_a_envoyer.setText("");
            String[] messages = API.getInstance().getmessages(App.getUser().getId(), App.getUser2id(),App.numpagechat);
            if(messages!=null)
            {
                if(messages[3] != null)
                {
                    message_recu1.setText(messages[3]);
                    emeteur1.setText(nomutilisateur.getText());
                }
                if(messages[2] != null)
                {
                    message_recu2.setText(messages[2]);
                    emeteur2.setText(nomutilisateur.getText());
                }
                if(messages[1] != null)
                {
                    message_recu3.setText(messages[1]);
                    emeteur3.setText(nomutilisateur.getText());
                }
                if(messages[0] != null)
                {
                    message_recu4.setText(messages[0]);
                    emeteur4.setText(nomutilisateur.getText());
                }
            }
        }
    }

    @FXML
    private void pagesuivante()
    {
        if(App.getUser2id() != 0) {
            App.numpagechat++;
            String[] messages = API.getInstance().getmessages(App.getUser().getId(), App.getUser2id(),App.numpagechat);
            if(messages!=null)
            {
                if(messages[0] != null)
                {
                    message_recu4.setText(messages[0]);
                    emeteur1.setText(nomutilisateur.getText());
                }
                if(messages[1] != null)
                {
                    message_recu3.setText(messages[1]);
                    emeteur2.setText(nomutilisateur.getText());
                }
                if(messages[2] != null)
                {
                    message_recu2.setText(messages[2]);
                    emeteur3.setText(nomutilisateur.getText());
                }
                if(messages[4] != null)
                {
                    message_recu1.setText(messages[4]);
                    emeteur4.setText(nomutilisateur.getText());
                }
            }
            
        }
    }

    @FXML
    private void pageprecedente()
    {
        if(App.getUser2id() != 0 && App.numpagechat > 1) {
            App.numpagechat--;
            String[] messages = API.getInstance().getmessages(App.getUser().getId(), App.getUser2id(),App.numpagechat);
            if(messages!=null)
            {
                if(messages[0] != null)
                {
                    message_recu4.setText(messages[0]);
                    emeteur1.setText(nomutilisateur.getText());
                }
                if(messages[1] != null)
                {
                    message_recu3.setText(messages[1]);
                    emeteur2.setText(nomutilisateur.getText());
                }
                if(messages[2] != null)
                {
                    message_recu2.setText(messages[2]);
                    emeteur3.setText(nomutilisateur.getText());
                }
                if(messages[4] != null)
                {
                    message_recu1.setText(messages[4]);
                    emeteur4.setText(nomutilisateur.getText());
                }
            }
            
        }
    }

}
