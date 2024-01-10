package eu.telecomnancy;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import eu.telecomnancy.BDD_App.API;
import eu.telecomnancy.Model.Annonce;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ListeAnnonceController {
    
    @FXML
    private VBox annonceslayout;

    public void initialize() throws Exception{
        System.out.println("ListeAnnonceController");
        List<Annonce> annonces = new ArrayList<>(annonces());
        System.out.println(annonces);
        for (int i=0; i<annonces.size(); i++){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("annoncelisteitem.fxml"));

            try{
                System.out.println("try");
                HBox hbox = loader.load();
                AnnoncelisteItemController controller = loader.getController();
                controller.setData(annonces.get(i));
                annonceslayout.getChildren().add(hbox);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private List<Annonce> annonces() throws Exception{
        List<Annonce> annonces = new ArrayList<>();
        ResultSet resultSet = API.getInstance().getAnnonces();

        while (resultSet.next()) {
            Annonce annonce = new Annonce();
            annonce.setDescription(resultSet.getString("description"));
            annonce.setTitre(resultSet.getString("nom"));
            annonce.setPrix(resultSet.getInt("prix"));

            annonces.add(annonce);
        }
        return annonces;
    }
}
/*nom text NOT NULL,\n"
+ "	id integer PRIMARY KEY AUTOINCREMENT,\n"
+ "	id_vendeur integer NOT NULL,\n"
+ "	prix integer NOT NULL,\n"
+ " categorie text NOT NULL,\n" // service ou matériel
+ " description text,\n"
+ " date_depot datetime NOT NULL,\n" */