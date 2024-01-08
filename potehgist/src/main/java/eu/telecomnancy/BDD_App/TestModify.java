package eu.telecomnancy.BDD_App;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestModify {
    
    public static void main(String[] args) {
        
        // Test de la modification d'un utilisateur sans l'API
        
        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:potehgist/potehgist.db")) {
            // Montre tout ce qu'il y a dans la table utilisateurs
            conn.createStatement().executeQuery("SELECT * FROM utilisateurs;");
            System.out.println("Table utilisateurs :");
            // Ajout d'un utilisateur
            conn.createStatement().execute("INSERT INTO utilisateurs (nom, mot_de_passe, email, argent, admin, code_postal) VALUES ('tataa', 'tataa', 'tataa', 0, false, '54000');");
            System.out.println("Ajout de l'utilisateur tata");

            conn.prepareStatement("UPDATE utilisateurs SET email ='lol' WHERE id =1").execute();


            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        
    }
}
