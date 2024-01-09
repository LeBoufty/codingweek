package eu.telecomnancy;

import eu.telecomnancy.BDD_App.API;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class ListeAnnonceController {
    
    @FXML
    private Label categorie_1;

    @FXML
    private Label categorie_11;

    @FXML
    private Label categorie_111;

    @FXML
    private Label categorie_1111;

    @FXML
    private Text description_1;

    @FXML
    private Text description_11;

    @FXML
    private Text description_111;

    @FXML
    private Text description_1111;

    @FXML
    private ImageView image_1;

    @FXML
    private ImageView image_11;

    @FXML
    private ImageView image_111;

    @FXML
    private ImageView image_1111;

    @FXML
    private Label nom_annonce_1;

    @FXML
    private Label nom_annonce_11;

    @FXML
    private Label nom_annonce_111;

    @FXML
    private Label nom_annonce_1111;

    @FXML
    private Label nom_vendeur_1;

    @FXML
    private Label nom_vendeur_11;

    @FXML
    private Label nom_vendeur_111;

    @FXML
    private Label nom_vendeur_1111;

    @FXML
    private Label page_num;

    @FXML
    private Button pagemaximus;

    @FXML
    private Button pageminus;

    @FXML
    private Label prix_1;

    @FXML
    private Label prix_11;

    @FXML
    private Label prix_111;

    @FXML
    private Label prix_1111;


    public void initialize() throws Exception
    {
        int page = App.getPageAnnonce();
        page_num.setText("Page n°"+page);

        API api = API.getInstance();
        String[] annonces = api.getOffreInfosAccueil(page);

        nom_annonce_1.setText(annonces[0]);
        nom_vendeur_1.setText(annonces[1]);
        prix_1.setText(annonces[2]);
        categorie_1.setText(annonces[3]);
        description_1.setText(annonces[4]);
        // Ce sera pour date de depot
        nom_annonce_11.setText(annonces[6]);
        nom_vendeur_11.setText(annonces[7]);
        prix_11.setText(annonces[8]);
        categorie_11.setText(annonces[9]);
        description_11.setText(annonces[10]);
        // Ce sera pour date de depot
        nom_annonce_111.setText(annonces[12]);
        nom_vendeur_111.setText(annonces[13]);
        prix_111.setText(annonces[14]);
        categorie_111.setText(annonces[15]);
        description_111.setText(annonces[16]);
        // Ce sera pour date de depot
        nom_annonce_1111.setText(annonces[18]);
        nom_vendeur_1111.setText(annonces[19]);
        prix_1111.setText(annonces[20]);
        categorie_1111.setText(annonces[21]);
        description_1111.setText(annonces[22]);
        // Ce sera pour date de depot
    }

    @FXML
    private void pageplus() throws Exception {
        int page = App.getPageAnnonce();
        page++;
        App.setPageAnnonce(page);
        App.setRoot("listeannonce");
    }

    @FXML
    private void pagemoins() throws Exception {
        int page = App.getPageAnnonce();
        if(page>1)
        {
            page--;
            App.setPageAnnonce(page);
        }
        App.setRoot("listeannonce");
    }
}
