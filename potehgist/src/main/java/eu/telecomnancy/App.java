package eu.telecomnancy;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * JavaFX App test potagit
 */
public class App extends Application {

    private static Scene scene;
    private static Utilisateur user = new Utilisateur();
    public static int numpagechat;
    private static Utilisateur user2;



    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("connect"), 640, 480);
        stage.setTitle("PotehGist");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("assets/logo.png")));
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
        user = new Utilisateur(id);
    }

    static Utilisateur getUser() {
        return user;
    }

    static Utilisateur getUser2() {
        return user2;
    }

    static int getUser2id() {
        return user2.getId();
    }

    static boolean loggedIn() {
        return user.getId() != 0;
    }

    public static void main(String[] args) {
        launch(args);
    }

}