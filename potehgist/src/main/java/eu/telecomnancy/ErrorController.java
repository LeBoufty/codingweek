package eu.telecomnancy;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ErrorController {

    @FXML
    private Label description;

    public void setData(String desc) {
        description.setText(desc);
    }

    @FXML
    private void close() {
        App.closePopup();
    }
}
