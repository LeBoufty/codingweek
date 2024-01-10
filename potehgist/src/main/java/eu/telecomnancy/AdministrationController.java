package eu.telecomnancy;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import eu.telecomnancy.BDD_App.API;
import eu.telecomnancy.Model.Reclamation;

import java.sql.ResultSet;
import java.sql.SQLException;


import java.time.LocalDateTime;

public class AdministrationController {

    @FXML
    private TableView<Reclamation> tableView;

    @FXML
    private TableColumn<Reclamation, Integer> idColumn;

    @FXML
    private TableColumn<Reclamation, Integer> idUtilisateurColumn;

    @FXML
    private TableColumn<Reclamation, String> messageColumn;

    @FXML
    private TableColumn<Reclamation, LocalDateTime> dateColumn;

    @FXML
    private javafx.scene.control.TextField idrésolu;

    private ObservableList<Reclamation> reclamations = FXCollections.observableArrayList();

    public void initialize() throws Exception{
        // Set up the columns
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        idUtilisateurColumn.setCellValueFactory(new PropertyValueFactory<>("id_utilisateur"));
        messageColumn.setCellValueFactory(new PropertyValueFactory<>("message"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        // Load data from the database and populate the table
        loadDataFromDatabase();
        tableView.setItems(reclamations);
    }

    private void loadDataFromDatabase() throws Exception{
        try {
            ResultSet resultSet = API.getInstance().getReclamations();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int id_utilisateur = resultSet.getInt("id_utilisateur");
                String message = resultSet.getString("message");
                LocalDateTime date = resultSet.getTimestamp("date").toLocalDateTime();

                Reclamation reclamation = new Reclamation(id, id_utilisateur, message, date);
                reclamations.add(reclamation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void resolu() throws Exception {
        API.getInstance().resolu(Integer.parseInt(idrésolu.getText()));
        App.setRoot("administration");
    }
}

