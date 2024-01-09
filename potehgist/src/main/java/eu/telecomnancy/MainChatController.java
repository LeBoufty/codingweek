package eu.telecomnancy;

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
        
    }

    @FXML
    private void chargerconvo() throws Exception
    {
        if(!nomutilisateur.getText().equals("")){
            App.setUser2(API.getInstance().getUserid(nomutilisateur.getText().toString()));
            if(API.getInstance().getmessages(App.getUser2id(), App.getUser().getId(), 1)[0]!=null){
                App.setRoot("chat");
            }
            else{
                System.out.println("Pas de conversation");
                App.setUser(0);
                nomutilisateur.setText("");
            }
        }
        else if(!Boxnom.getValue().equals("")){
            App.setUser2(API.getInstance().getUserid(nomutilisateur.getText().toString()));
            if(API.getInstance().getmessages(App.getUser2id(), App.getUser().getId(), 1)[0]!=null){
                App.setRoot("chat");
            }
            else{
                System.out.println("Pas de conversation");
                App.setUser(0);
                nomutilisateur.setText("");
            }
        }
    } 
}
