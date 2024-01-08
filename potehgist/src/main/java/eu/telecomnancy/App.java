package eu.telecomnancy;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

<<<<<<< HEAD
import java.io.IOException;


=======
>>>>>>> 4d141d6a54d97f370f80c10ba8ae74e7337b1b62
/**
 * JavaFX App test potagit
 */
public class App extends Application {

    private static Scene scene;
    private static String userid;

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

    static void setUserid(String id) {
        userid = id;
    }

    static String getUserid() {
        return userid;
    }

    static boolean loggedIn() {
        return userid != null;
    }

    public static void main(String[] args) {
        launch(args);
    }

}