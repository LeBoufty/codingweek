package eu.telecomnancy;

import java.sql.ResultSet;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import eu.telecomnancy.BDD_App.API;
import eu.telecomnancy.Model.Message;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class ChatController {

    @FXML
    private TextArea message_a_envoyer;

    @FXML
    private Label nomuser2;

    @FXML VBox ChatVbox;
    
    @FXML
    private void retour() throws Exception
    {
        App.setUser2(0);
        App.setRoot("mainchat");
    }

    private List<Message> Message() throws Exception{
        ResultSet result = API.getInstance().getmessages(App.getUser().getId(), App.getUser2id());
        List<Message> chats = new ArrayList<>();
        while(result.next())
        {
            Message msg = new Message(result.getInt("id"));
            System.out.println(msg.getmessage());
            chats.add(msg);
        }
        return chats;
    }

    @FXML
    private void initialize() throws Exception {
        if(App.getUser2id() != 0) {
            nomuser2.setText(App.getUser2().getNom());
            List<Message> chats = Message();
            for (int i=0; i<chats.size(); i++)
            {
                FXMLLoader loader = new FXMLLoader();
                if (chats.get(i).getAuthor() == App.getUser().getNom())
                    loader.setLocation(getClass().getResource("chatitemuser.fxml"));
                else
                    loader.setLocation(getClass().getResource("chatitem.fxml"));
                try{
                    HBox hbox = loader.load();
                    ChatItemController controller = loader.getController();
                    controller.setData(chats.get(i).getmessage(), chats.get(i).getdate(), chats.get(i).getAuthor());
                    ChatVbox.getChildren().add(hbox);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        } 
    }

    @FXML
    private void envoyermessage()
    {
        if(App.getUser2id() != 0) {
            API.getInstance().addnotif(App.getUser2id(), "Vous avez reçu un message de " + App.getUser().getNom() + ".");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("chatitemuser.fxml"));
            try{
                HBox hbox = loader.load();
                ChatItemController controller = loader.getController();
                controller.setData(message_a_envoyer.getText(), (int)Instant.now().getEpochSecond(), App.getUser().getNom());
                ChatVbox.getChildren().add(hbox);
                message_a_envoyer.setText("");
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
