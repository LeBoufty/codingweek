package eu.telecomnancy;

import eu.telecomnancy.BDD_App.API;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.util.List;
import java.util.ArrayList;
import javafx.fxml.FXMLLoader;

public class ListeAnnonceController {
    
    @FXML
    private VBox annonceslayout;

    public void initialize() {
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

    private List<Annonce> annonces(){
        List<Annonce> annonces = new ArrayList<>();
        Annonce annonce = new Annonce();

        annonce.setTitre("Titre de l'annonce tttt");
        annonce.setPrix(101);
        annonce.setImgSrc("assets/imagedeprofile/1.png");
        annonce.setDescription("Description de l'annonce ddddd");

        annonces.add(annonce);

        annonce = new Annonce();
        annonce.setTitre("Ti de l'annonce tttt");
        annonce.setPrix(11);
        annonce.setImgSrc("assets/imagedeprofile/1.png");
        annonce.setDescription("Description de ce ddddd");

        annonces.add(annonce);

        return annonces;
    }
}
