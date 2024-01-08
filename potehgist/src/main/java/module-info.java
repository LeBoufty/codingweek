module eu.telecomnancy {
    requires transitive javafx.controls;
    requires transitive javafx.fxml;

    opens eu.telecomnancy to javafx.fxml;
    exports eu.telecomnancy;
}
