package eu.telecomnancy;

import java.io.IOException;
import javafx.fxml.FXML;

public class HeaderController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
