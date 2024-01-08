package eu.telecomnancy;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App test potagit
 */
public class App extends Application {

    private static Scene scene;
    private static int userid = 0;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("connect"), 640, 480);
        stage.setTitle("PotehGist");
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

    static void setUserid(int id) {
        userid = id;
    }

    static int getUserid() {
        return userid;
    }

    static boolean loggedIn() {
        return userid != 0;
    }

    public static void main(String[] args) {
        launch(args);
    }

}