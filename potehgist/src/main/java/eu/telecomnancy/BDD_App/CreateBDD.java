package eu.telecomnancy.BDD_App;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateBDD {
    public static final String BDD_NAME = "potehgist.db";
    public static void createNewDatabase(String fileName) {
 
        String url = "jdbc:sqlite:potehgist/" + fileName;
 
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("[DEBUG] Le nom du driver est " + meta.getDriverName());
                System.out.println("[DEBUG] Une nouvelle base de données a été créée.");

                // Création de la table "users"
                String utilisateurs = "CREATE TABLE IF NOT EXISTS utilisateurs (\n"
                        + "	id integer PRIMARY KEY,\n"
                        + "	nom text NOT NULL,\n"
                        + "	mot_de_passe text NOT NULL,\n"
                        + "	email text NOT NULL UNIQUE,\n"
                        + "	argent integer NOT NULL,\n"
                        + "	admin bool NOT NULL\n"
                        + ");";

                // Ajout dans la BDD
                conn.createStatement().execute(utilisateurs);

                // Fermerture de la connexion
                conn.close();

            }
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
 
    public static void main(String[] args) {
        createNewDatabase(BDD_NAME);
    }
}
