package eu.telecomnancy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import eu.telecomnancy.BDD_App.API;
import eu.telecomnancy.Model.Date_M;
import eu.telecomnancy.Model.Sommeils;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXMLLoader;
import java.sql.ResultSet;

public class SommeilsController {

    @FXML
    private DatePicker Date_debut;

    @FXML
    private DatePicker Date_fin;

    @FXML
    private VBox sommeilslayout;

    @FXML
    public void AddSommeils(ActionEvent event) throws Exception{
        API.getInstance().addSommeils(App.getUser().getId(),(int)Date_M.getDate_FXML(Date_debut.getValue()),(int)Date_M.getDate_FXML(Date_fin.getValue()));
        App.setRoot("sommeils");
    }

    public void initialize() throws Exception{
        List<Sommeils> sommeils = new ArrayList<>();  

        int id = App.getUser().getId();
        sommeils = new ArrayList<Sommeils>();
        ResultSet resultSet = API.getInstance().getSommeils(id);
        while (resultSet.next()) {
            Sommeils sommeil = new Sommeils(resultSet.getInt("id"), resultSet.getInt("date_debut"), resultSet.getInt("date_fin"));
            sommeils.add(sommeil);
        }
        
        for (int i=0; i<sommeils.size(); i++){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("sommeilsItem.fxml"));

            try{
                HBox hbox = loader.load();
                SommeilsItemController controller = loader.getController();
                controller.setData(Integer.toString(sommeils.get(i).getId()), sommeils.get(i).getDateDebutString(), sommeils.get(i).getDateFinString());
                sommeilslayout.getChildren().add(hbox);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
