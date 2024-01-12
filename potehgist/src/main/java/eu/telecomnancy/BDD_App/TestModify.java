package eu.telecomnancy.BDD_App;

import java.io.File;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestModify {
    
    public static void main(String[] args) {
        
        // Test de la modification d'un utilisateur sans l'API
        
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:/tmp/potehgist.db")) {
            // Montre tout ce qu'il y a dans la table utilisateurs
            String insertQuery = "INSERT INTO test_images (image) VALUES (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            File imageFile = new File("/home/toyhugs/gitlab/codingweek-01/docu/michiru.jpg");            



            //System.Out.println(imageFile.exists());
            // InputStream inputStream2 = new FileInputStream(imageFile);
            byte[] imageData = Files.readAllBytes(imageFile.toPath());
            
            preparedStatement.setBytes(1, imageData);
            preparedStatement.executeUpdate();
            //System.Out.println("Image insérée");


            String selectQuery = "SELECT image FROM test_images WHERE id = ?";
            preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setInt(1, 1);
            byte[] imageBytes = preparedStatement.executeQuery().getBytes(1);
            //System.Out.println(imageBytes.length);
            // InputStream inputStream = new ByteArrayInputStream(imageBytes);
            String outputpath = "/home/toyhugs/gitlab/codingweek-01/docu/michiru2.jpg";
            Files.write(new File(outputpath).toPath(), imageBytes);
            //System.Out.println("Image extraite");                      
            
            
        } catch (Exception e) {
            //System.Out.println(e.getMessage());
        }

        
    }
}
