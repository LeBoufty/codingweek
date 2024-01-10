module eu.telecomnancy {
    requires transitive javafx.base;
    requires transitive javafx.graphics;
    requires transitive javafx.controls;
    requires transitive javafx.fxml;
    requires transitive java.sql;
    requires transitive junit;

    opens eu.telecomnancy to javafx.fxml;
    exports eu.telecomnancy;
    exports eu.telecomnancy.Model;
}
