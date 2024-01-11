package eu.telecomnancy;

import java.io.IOException;

import eu.telecomnancy.Model.Annonce;
import eu.telecomnancy.Model.Annonce_Recherche;
import eu.telecomnancy.Model.Annonce_en_creation;
import eu.telecomnancy.Model.Utilisateur;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * JavaFX App test potagit 2
 */
public class App extends Application {

    private static Scene scene;
    private static Utilisateur user = new Utilisateur();
    public static int numpagechat;
    public static int numpageannonce;
    private static Utilisateur user2;
    public static int idannonce;
    public static Annonce_Recherche annonce_recherche = new Annonce_Recherche();
    private static TypeRecherche type_recherche = TypeRecherche.ALL;
    public static Annonce_en_creation annonce_en_creation;
    private static Stage popup; 
    public static int currentannonce;


    private static int page_annonce = 1;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("connect"), 1200, 720);
        stage.setTitle("PotehGist");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("assets/favicon.png")));
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        Font.loadFont(getClass().getResource("fonts/RobotoLight.ttf").toExternalForm(), 10);
        Font.loadFont(getClass().getResource("fonts/RobotoBlack.ttf").toExternalForm(), 10);
        Font.loadFont(getClass().getResource("fonts/RobotoBold.ttf").toExternalForm(), 10);
        Font.loadFont(getClass().getResource("fonts/Minecrafter.ttf").toExternalForm(), 10);
        Font.loadFont(getClass().getResource("fonts/LEMONMILKBold.otf").toExternalForm(), 10);
        stage.setScene(scene);
        stage.show();
    }

    public static void error(String message) throws IOException {
        closePopup();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(App.class.getResource("error.fxml"));
        Scene scene = new Scene(loader.load(), 480, 164);
        Stage stage = new Stage();
        stage.setTitle("Erreur");
        stage.setScene(scene);
        stage.show();
        popup = stage;
        ErrorController controller = loader.getController();
        controller.setData(message);
    }

    public static void closePopup() {
        if(popup != null)
            popup.close();
    }

    static void setTypeRecherche(TypeRecherche type) {
        type_recherche = type;
    }

    static TypeRecherche getTypeRecherche() {
        return type_recherche;
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    static void setUser(int id) {
        user = new Utilisateur(id);
    }

    static void setUser2(int id) {
        user2 = new Utilisateur(id);
    }

    public static Utilisateur getUser() {
        return user;
    }

    static Utilisateur getUser2() {
        return user2;
    }

    static int getUser2id() {
        if(user2 == null)
            return 0;
        return user2.getId();
    }

    static boolean loggedIn() {
        return user.getId() != 0;
    }

    public static void setPageAnnonce(int page) {
        page_annonce = page;
    }

    public static int getPageAnnonce() {
        return page_annonce;
    }

    public static void setRecherche(Annonce_Recherche recherche) {
        annonce_recherche = recherche;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void setidannonce(int id) {
        idannonce = id;
    }

    public static int getidannonce() {
        return idannonce;
    }

    public static Annonce getAnnonce() {
        return new Annonce(idannonce);
    }
}