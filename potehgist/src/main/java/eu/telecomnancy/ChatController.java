package eu.telecomnancy;

import eu.telecomnancy.BDD_App.API;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class ChatController {

    @FXML
    private TextArea message_a_envoyer;

    @FXML
    private TextField nomutilisateur;

    @FXML
    private Label message_recu1;

    @FXML
    private Label message_recu2;

    @FXML
    private Label message_recu3;

    @FXML
    private Label message_recu4;

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
        App.setUser2(0);
    }

    @FXML
    private void chargerconvo() throws Exception {
        App.setUser2(API.getInstance().getUserid(nomutilisateur.getText()));
        if(App.getUser2id() != 0) {
            App.numpagechat = 1;
            nomuser2.setText(nomutilisateur.getText());
            nomutilisateur.setText("");
            
            String[] messages = API.getInstance().getmessages(App.getUser().getId(), App.getUser2id());
            if(messages[3] != null) {
                message_recu1.setText(messages[3]);
                emeteur1.setText(nomutilisateur.getText());
            }
            if(messages[2] != null) {
                message_recu2.setText(messages[2]);
                emeteur2.setText(nomutilisateur.getText());
            }
            if(messages[1] != null) {
                message_recu3.setText(messages[1]);
                emeteur3.setText(nomutilisateur.getText());
            }
            if(messages[0] != null) {
                message_recu4.setText(messages[0]);
                emeteur4.setText(nomutilisateur.getText());
            }
        } 
    }

    @FXML
    private void envoyermessage()
    {
        if(App.getUser2id() != 0) {
            String message = message_a_envoyer.getText();
            API.getInstance().addmessage(App.getUser().getId(), App.getUser2id(), message);
            message_a_envoyer.setText("");
            try {
                nomutilisateur.setText(nomuser2.getText());
                chargerconvo();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void pagesuivante()
    {
        if(App.getUser2id() != 0) {
            App.numpagechat++;
            String[] messages = API.getInstance().getmessages(App.getUser().getId(), App.getUser2id());
            if(messages[App.numpagechat*4-1] != null) {
                message_recu4.setText(messages[App.numpagechat*4-1]);
                emeteur1.setText(nomutilisateur.getText());
            }
            if(messages[App.numpagechat*4-2] != null) {
                message_recu3.setText(messages[App.numpagechat*4-2]);
                emeteur2.setText(nomutilisateur.getText());
            }
            if(messages[App.numpagechat*4-3] != null) {
                message_recu2.setText(messages[App.numpagechat*4-3]);
                emeteur3.setText(nomutilisateur.getText());
            }
            if(messages[App.numpagechat*4-4] != null) {
                message_recu1.setText(messages[App.numpagechat*4-4]);
                emeteur4.setText(nomutilisateur.getText());
            }
        }
    }

    @FXML
    private void pageprecedente()
    {
        if(App.getUser2id() != 0 && App.numpagechat > 1) {
            App.numpagechat--;
            String[] messages = API.getInstance().getmessages(App.getUser().getId(), App.getUser2id());
            if(messages[App.numpagechat*4-1] != null) {
                message_recu1.setText(messages[App.numpagechat*4-1]);
                emeteur1.setText(nomutilisateur.getText());
            }
            if(messages[App.numpagechat*4-2] != null) {
                message_recu2.setText(messages[App.numpagechat*4-2]);
                emeteur2.setText(nomutilisateur.getText());
            }
            if(messages[App.numpagechat*4-3] != null) {
                message_recu3.setText(messages[App.numpagechat*4-3]);
                emeteur3.setText(nomutilisateur.getText());
            }
            if(messages[App.numpagechat*4-4] != null) {
                message_recu4.setText(messages[App.numpagechat*4-4]);
                emeteur4.setText(nomutilisateur.getText());
            }
        }
    }

}
