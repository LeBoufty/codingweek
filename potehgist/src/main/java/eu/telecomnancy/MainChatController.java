package eu.telecomnancy;

import java.sql.ResultSet;

import eu.telecomnancy.BDD_App.API;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;


public class MainChatController {


    @FXML
    private TextField nomutilisateur;

    @FXML
    private ChoiceBox<String> Boxnom;
    


    @FXML
    private void initialize()
    {
        String[] users = API.getInstance().getLastFiveChat(App.getUser().getId());
        for(int i=0; i<users.length; i++){
            if(users[i]!=""){
                Boxnom.getItems().add(users[i]);
            }
        }
    }

    @FXML
    private void chargerconvo() throws Exception
    {
        if(!nomutilisateur.getText().equals("")){
            App.setUser2(API.getInstance().getUserid(nomutilisateur.getText().toString()));
            ResultSet messages = API.getInstance().getmessages(App.getUser2id(), App.getUser().getId());
            if(messages.next()){
                App.setRoot("chat");
            }
            else{
                System.out.println("Pas de conversation");
                App.setUser2(0);
                nomutilisateur.setText("");
            }
        }
        if(Boxnom.getValue() != null){
            App.setUser2(API.getInstance().getUserid(Boxnom.getValue()));
            ResultSet messages = API.getInstance().getmessages(App.getUser2id(), App.getUser().getId());
            if(messages.next()){
                App.setRoot("chat");
            }
            else{
                System.out.println("Pas de conversation");
                App.setUser2(0);
            }
        }
    } 
}
