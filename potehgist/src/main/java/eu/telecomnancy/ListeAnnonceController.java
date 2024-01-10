package eu.telecomnancy;

import eu.telecomnancy.BDD_App.API;
import eu.telecomnancy.Model.Annonce;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import javafx.fxml.FXMLLoader;

public class ListeAnnonceController {
    
    @FXML
    private VBox annonceslayout;

    public void initialize() throws Exception{
        System.out.println("ListeAnnonceController");
        List<Annonce> annonces = new ArrayList<>();
        switch (App.getTypeRecherche()) {
            case ALL:
                annonces = new ArrayList<>(annonces());
                break;
            case MESANNONCES:
                annonces = new ArrayList<>(App.getUser().getAnnonces());
                break;
            default:
                break;
        }
        System.out.println(annonces);
        for (int i=0; i<annonces.size(); i++){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("annoncelisteitem.fxml"));

            try{
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

        // ResultSet resultSet = API.getInstance().getAnnonces();

        while (resultSet.next()) {
            Annonce annonce = new Annonce();
            annonce.setDescription(resultSet.getString("description"));
            annonce.setTitre(resultSet.getString("nom"));
            annonce.setPrix(resultSet.getInt("prix"));
            annonce.setCategorie(resultSet.getString("categorie"));
            annonce.setDate_depot(resultSet.getString("date"));
            annonce.setCode_postal(resultSet.getString("code_postal"));

        //     annonces.add(annonce);
        // }
        
        annonces = API.getInstance().getAnnoncesRecherche(App.annonce_recherche);

        return annonces;
    }
}