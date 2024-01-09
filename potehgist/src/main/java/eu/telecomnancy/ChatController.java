package eu.telecomnancy;

import eu.telecomnancy.BDD_App.API;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;


public class ChatController {

    @FXML
    private TextArea message_a_envoyer;

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
    private void retour() throws Exception
    {
        App.setUser2(0);
        App.setRoot("mainchat");
    }

    @FXML
    private void initialize() {
        if(App.getUser2id() != 0) {
            App.numpagechat = 1;
            page.setText(Integer.toString(App.numpagechat));
            nomuser2.setText(App.getUser2().getNom());
            
            String[] messages = API.getInstance().getmessages(App.getUser().getId(), App.getUser2id(),App.numpagechat);
            if(messages!=null)
            {
                
                if(messages[3] != null)
                {
                    message_recu1.setText(messages[3]);
                    if(API.getInstance().getmessagewriter(messages[3], App.getUser().getId(), App.getUser2id())==App.getUser().getId())
                    {
                        emeteur4.setText(App.getUser().getNom());
                    }
                    else
                    {
                        emeteur4.setText(App.getUser2().getNom());
                    }
                }
                if(messages[2] != null)
                {
                    message_recu2.setText(messages[2]);
                    if(API.getInstance().getmessagewriter(messages[2], App.getUser().getId(), App.getUser2id())==App.getUser().getId())
                    {
                        emeteur3.setText(App.getUser().getNom());
                    }
                    else
                    {
                        emeteur3.setText(App.getUser2().getNom());
                    }
                }
                if(messages[1] != null)
                {
                    message_recu3.setText(messages[1]);
                    if(API.getInstance().getmessagewriter(messages[1], App.getUser().getId(), App.getUser2id())==App.getUser().getId())
                    {
                        emeteur2.setText(App.getUser().getNom());
                    }
                    else
                    {
                        emeteur2.setText(App.getUser2().getNom());
                    }
                }
                if(messages[0] != null)
                {
                    message_recu4.setText(messages[0]);
                    if(API.getInstance().getmessagewriter(messages[0], App.getUser().getId(), App.getUser2id())==App.getUser().getId())
                    {
                        emeteur1.setText(App.getUser().getNom());
                    }
                    else
                    {
                        emeteur1.setText(App.getUser2().getNom());
                    }
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
            API.getInstance().addmessage(App.getUser().getId(), App.getUser2id(), message);
            message_a_envoyer.setText("");
            String[] messages = API.getInstance().getmessages(App.getUser().getId(), App.getUser2id(),App.numpagechat);
            if(messages!=null)
            {
                if(messages[3] != null)
                {
                    message_recu1.setText(messages[3]);
                    if(API.getInstance().getmessagewriter(messages[3], App.getUser().getId(), App.getUser2id())==App.getUser().getId())
                    {
                        emeteur1.setText(App.getUser().getNom());
                    }
                    else
                    {
                        emeteur1.setText(App.getUser2().getNom());
                    }
                }
                if(messages[2] != null)
                {
                    message_recu2.setText(messages[2]);
                    if(API.getInstance().getmessagewriter(messages[2], App.getUser().getId(), App.getUser2id())==App.getUser().getId())
                    {
                        emeteur2.setText(App.getUser().getNom());
                    }
                    else
                    {
                        emeteur2.setText(App.getUser2().getNom());
                    }
                }
                if(messages[1] != null)
                {
                    message_recu3.setText(messages[1]);
                    if(API.getInstance().getmessagewriter(messages[1], App.getUser().getId(), App.getUser2id())==App.getUser().getId())
                    {
                        emeteur3.setText(App.getUser().getNom());
                    }
                    else
                    {
                        emeteur3.setText(App.getUser2().getNom());
                    }
                }
                if(messages[0] != null)
                {
                    message_recu4.setText(messages[0]);
                    if(API.getInstance().getmessagewriter(messages[0], App.getUser().getId(), App.getUser2id())==App.getUser().getId())
                    {
                        emeteur4.setText(App.getUser().getNom());
                    }
                    else
                    {
                        emeteur4.setText(App.getUser2().getNom());
                    }
                }
            }
        }
    }

    @FXML
    private void pagesuivante()
    {
        if(App.getUser2id() != 0) {
            App.numpagechat++;
            page.setText(Integer.toString(App.numpagechat));
            String[] messages = API.getInstance().getmessages(App.getUser().getId(), App.getUser2id(),App.numpagechat);
            if(messages!=null)
            {
                if(messages[0] != null)
                {
                    message_recu4.setText(messages[0]);
                    if(API.getInstance().getmessagewriter(messages[0], App.getUser().getId(), App.getUser2id())==App.getUser().getId())
                    {
                        emeteur4.setText(App.getUser().getNom());
                    }
                    else
                    {
                        emeteur4.setText(App.getUser2().getNom());
                    }
                }
                if(messages[1] != null)
                {
                    message_recu3.setText(messages[1]);
                    if(API.getInstance().getmessagewriter(messages[1], App.getUser().getId(), App.getUser2id())==App.getUser().getId())
                    {
                        emeteur3.setText(App.getUser().getNom());
                    }
                    else
                    {
                        emeteur3.setText(App.getUser2().getNom());
                    }
                }
                if(messages[2] != null)
                {
                    message_recu2.setText(messages[2]);
                    if(API.getInstance().getmessagewriter(messages[2], App.getUser().getId(), App.getUser2id())==App.getUser().getId())
                    {
                        emeteur2.setText(App.getUser().getNom());
                    }
                    else
                    {
                        emeteur2.setText(App.getUser2().getNom());
                    }
                }
                if(messages[3] != null)
                {
                    message_recu1.setText(messages[3]);
                    if(API.getInstance().getmessagewriter(messages[3], App.getUser().getId(), App.getUser2id())==App.getUser().getId())
                    {
                        emeteur1.setText(App.getUser().getNom());
                    }
                    else
                    {
                        emeteur1.setText(App.getUser2().getNom());
                    }
                }
            }
            
        }
    }

    @FXML
    private void pageprecedente()
    {
        if(App.getUser2id() != 0 && App.numpagechat > 1) {
            App.numpagechat--;
            page.setText(Integer.toString(App.numpagechat));
            String[] messages = API.getInstance().getmessages(App.getUser().getId(), App.getUser2id(),App.numpagechat);
            if(messages!=null)
            {
                if(messages[0] != null)
                {
                    message_recu4.setText(messages[0]);
                    if(API.getInstance().getmessagewriter(messages[0], App.getUser().getId(), App.getUser2id())==App.getUser().getId())
                    {
                        emeteur4.setText(App.getUser().getNom());
                    }
                    else
                    {
                        emeteur4.setText(App.getUser2().getNom());
                    }
                }
                if(messages[1] != null)
                {
                    message_recu3.setText(messages[1]);
                    if(API.getInstance().getmessagewriter(messages[1], App.getUser().getId(), App.getUser2id())==App.getUser().getId())
                    {
                        emeteur3.setText(App.getUser().getNom());
                    }
                    else
                    {
                        emeteur3.setText(App.getUser2().getNom());
                    }
                }
                if(messages[2] != null)
                {
                    message_recu2.setText(messages[2]);
                    if(API.getInstance().getmessagewriter(messages[2], App.getUser().getId(), App.getUser2id())==App.getUser().getId())
                    {
                        emeteur2.setText(App.getUser().getNom());
                    }
                    else
                    {
                        emeteur2.setText(App.getUser2().getNom());
                    }
                }
                if(messages[3] != null)
                {
                    message_recu1.setText(messages[3]);
                    if(API.getInstance().getmessagewriter(messages[3], App.getUser().getId(), App.getUser2id())==App.getUser().getId())
                    {
                        emeteur3.setText(App.getUser().getNom());
                    }
                    else
                    {
                        emeteur3.setText(App.getUser2().getNom());
                    }
                }
            }
            
        }
    }

}
