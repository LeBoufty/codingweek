package eu.telecomnancy.BDD_App;

import java.io.File;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import eu.telecomnancy.Outils.Formater;





public class RemplirBDD {
    
    private Connection conn;
    private String url;

    public void remplir()
    {
        try {
            // Supprime le fichier de la BDD
            java.io.File file = new java.io.File(url);
            if (file.delete()) {
                System.out.println("[DEBUG] La base de données a été supprimée.");
            } else {
                System.out.println("[DEBUG] La base de données n'a pas été supprimée.");
            }
            CreateBDD.createNewDatabase("/tmp/potehgist.db");
            url = "jdbc:sqlite:/tmp/potehgist.db";
            conn = DriverManager.getConnection(url);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        // Ajout des utilisateurs

    }

    public void ajoututilisateur(String nom, String mdp, String email, int argent, String code_postal, String imagename, boolean admin)
    {
        email = Formater.format(email);
        code_postal = Formater.format(code_postal);
        String query = "INSERT INTO utilisateurs (nom, mot_de_passe, email, argent, admin, code_postal, image_profil) VALUES (?, ?, ?, ?, ?, ?, ?);";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, nom);
            pstmt.setString(2, mdp);
            pstmt.setString(3, email);
            pstmt.setInt(4, 0);
            pstmt.setBoolean(5, false);
            pstmt.setString(6, code_postal);
            // System.out.println(getClass().getResource("/eu/telecomnancy/assets/placeholder.png").toExternalForm());
            String path = getClass().getResource("/eu/telecomnancy/assets/"+imagename).toExternalForm();
            path = path.substring(5);
            File imageFile = new File(path);
            byte[] imageData = Files.readAllBytes(imageFile.toPath());
            pstmt.setBytes(7, imageData);
            pstmt.executeUpdate();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Erreur lors de l'ajout de l'utilisateur");
        }
        
    }

    public void ajoutoffre(String nom, int id_vendeur, int prix, String categorie, String description, String date_depot)
    {
        String query = "INSERT INTO offres (nom, id_vendeur, prix, categorie, description, date_depot) VALUES (?, ?, ?, ?, ?, ?);";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, nom);
            pstmt.setInt(2, id_vendeur);
            pstmt.setInt(3, prix);
            pstmt.setString(4, categorie);
            pstmt.setString(5, description);
            pstmt.setString(6, date_depot);
            pstmt.executeUpdate();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Erreur lors de l'ajout de l'offre");
        }
    }

    public void ajoutevaluation(int id_offre, int id_evaluant, int valeur_evaluation)
    {
        String query = "INSERT INTO evaluations (id_offre, id_evaluant, valeur_evaluation) VALUES (?, ?, ?);";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id_offre);
            pstmt.setInt(2, id_evaluant);
            pstmt.setInt(3, valeur_evaluation);
            pstmt.executeUpdate();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Erreur lors de l'ajout de l'évaluation");
        }
    }

    public void ajoutmessages(int id_utilisateur_envoie, int id_utilisateur_recoit, String message, int jour, int mois, int annee, int heure, int minute)
    {
        String date_envoi = ""+annee+"-"+mois+"-"+jour+" "+heure+":"+minute;
        String query = "INSERT INTO messages (id_utilisateur_envoie, id_utilisateur_recoit, message, date_envoi) VALUES (?, ?, ?, ?);";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id_utilisateur_envoie);
            pstmt.setInt(2, id_utilisateur_recoit);
            pstmt.setString(3, message);
            pstmt.setString(4, date_envoi);
            pstmt.executeUpdate();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Erreur lors de l'ajout du message");
        }
    }

    public void ajoutplanningreservation(int id_utilisateur, int id_offre, int jourdebut, int moisdebut, int anneedebut, int heuredebut, int minutedebut, int jourfin, int moisfin, int anneefin, int heurefin, int minutefin)
    {
        String date_debut = ""+anneedebut+"-"+moisdebut+"-"+jourdebut+" "+heuredebut+":"+minutedebut;
        String date_fin = ""+anneefin+"-"+moisfin+"-"+jourfin+" "+heurefin+":"+minutefin;
        String query = "INSERT INTO liste_attente (id_utilisateur, id_offre, date_debut, date_fin) VALUES (?, ?, ?, ?);";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id_utilisateur);
            pstmt.setInt(2, id_offre);
            pstmt.setString(3, date_debut);
            pstmt.setString(4, date_fin);
            pstmt.executeUpdate();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Erreur lors de l'ajout de la réservation");
        }
    }

    public void ajoutnotifications(int id_utilisateur, String message, int jour, int mois, int annee, int heure, int minute, boolean vu)
    {
        String date_envoi = ""+annee+"-"+mois+"-"+jour+" "+heure+":"+minute;
        String query = "INSERT INTO notifications (id_utilisateur, message, date, vue) VALUES (?, ?, ?, ?);";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id_utilisateur);
            pstmt.setString(2, message);
            pstmt.setString(3, date_envoi);
            pstmt.setBoolean(4, vu);
            pstmt.executeUpdate();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Erreur lors de l'ajout de la notification");
        }
    }

    public void ajoutreclamations(int id_utilisateur, String message, int jour, int mois, int annee, int heure, int minute, boolean resolu)
    {
        String date_envoi = ""+annee+"-"+mois+"-"+jour+" "+heure+":"+minute;
        String query = "INSERT INTO reclamations (id_utilisateur, message, date, resolu) VALUES (?, ?, ?, ?);";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id_utilisateur);
            pstmt.setString(2, message);
            pstmt.setString(3, date_envoi);
            pstmt.setBoolean(4, resolu);
            pstmt.executeUpdate();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Erreur lors de l'ajout de la réclamation");
        }
    }

}
