package eu.telecomnancy;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * JavaFX App test potagit
 */
public class App extends Application {

    private static Scene scene;
    private static Utilisateur user = new Utilisateur();
    public static int numpagechat;
    private static Utilisateur user2;


    private static int page_annonce = 1;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("connect"), 1200, 720);
        stage.setTitle("PotehGist");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("assets/logo.png")));
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        Font.loadFont(getClass().getResource("fonts/RobotoLight.ttf").toExternalForm(), 10);
        Font.loadFont(getClass().getResource("fonts/RobotoBlack.ttf").toExternalForm(), 10);
        Font.loadFont(getClass().getResource("fonts/RobotoBold.ttf").toExternalForm(), 10);
        Font.loadFont(getClass().getResource("fonts/Minecrafter.ttf").toExternalForm(), 10);
        Font.loadFont(getClass().getResource("fonts/LEMONMILKBold.otf").toExternalForm(), 10);
        stage.setScene(scene);
        stage.show();
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

    static Utilisateur getUser() {
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

    public static void main(String[] args) {
        launch(args);
    }

}