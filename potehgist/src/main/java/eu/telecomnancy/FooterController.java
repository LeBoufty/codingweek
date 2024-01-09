package eu.telecomnancy;

import java.io.IOException;
import javafx.fxml.FXML;

public class FooterController {
    
    @FXML
    private void reclamation() throws IOException {
        App.setRoot("reclamation");
    }

    @FXML
    private void administration() throws IOException {
        if (App.getUser().isAdmin()){
           App.setRoot("administration");
        }
    }

}