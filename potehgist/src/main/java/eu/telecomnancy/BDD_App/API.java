package eu.telecomnancy.BDD_App;

import java.sql.Connection;
// import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import eu.telecomnancy.Formater;

public class API {
    private static API instance = null;
    private Connection conn;
    //private DatabaseMetaData meta;
    private static String url;

    private API() {
        CreateBDD.createNewDatabase("/tmp/potehgist.db");
        try {
            url = "jdbc:sqlite:/tmp/potehgist.db";
            conn = DriverManager.getConnection(url);
            // meta = conn.getMetaData();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static API getInstance() {
        if (instance == null) {
            instance = new API();
        }
        return instance;
    }

    public int getUserid(String username) {
        ResultSet rs;
        try {
            rs = conn.createStatement().executeQuery("SELECT id FROM utilisateurs WHERE nom = '" + username + "';");
            return rs.getInt(1);
        } catch (SQLException e) {
            return 0;
        }
    }

    public String getUsername(int userid) throws Exception {
        ResultSet rs = conn.createStatement().executeQuery("SELECT nom FROM utilisateurs WHERE id = " + userid + ";");
        return rs.getString(1);
    }

    public String getemail(int userid) throws Exception {
        ResultSet rs = conn.createStatement().executeQuery("SELECT email FROM utilisateurs WHERE id = " + userid + ";");
        return rs.getString(1);
    }

    public String getcode_postal(int userid) throws Exception {
        ResultSet rs = conn.createStatement().executeQuery("SELECT code_postal FROM utilisateurs WHERE id = " + userid + ";");
        return rs.getString(1);
    }

    public void modifyUsername(int userid, String newname) throws Exception {
        String query = "UPDATE utilisateurs SET nom = ? WHERE id = ?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, newname);
            pstmt.setInt(2, userid);
            
            pstmt.executeUpdate();
        }
    }


    public void modifyemail(int userid, String newemail) throws Exception {
        String query = "UPDATE utilisateurs SET email = ? WHERE id = ?";
        newemail = Formater.format(newemail);
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, newemail);
            pstmt.setInt(2, userid);
            
            pstmt.executeUpdate();
        }
    }

    public void modifyargent(int userid, int newargent) throws Exception {
        String query = "UPDATE utilisateurs SET argent = ? WHERE id = ?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, newargent);
            pstmt.setInt(2, userid);
            
            pstmt.executeUpdate();
        }
    }

    public void modifyadmin(int userid, boolean newadmin) throws Exception {
        String query = "UPDATE utilisateurs SET admin = ? WHERE id = ?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setBoolean(1, newadmin);
            pstmt.setInt(2, userid);
            
            pstmt.executeUpdate();
        }
    }

    public void modifymdp(int userid, String newmdp) throws Exception {
        String query = "UPDATE utilisateurs SET mot_de_passe = ? WHERE id = ?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, newmdp);
            pstmt.setInt(2, userid);
            
            pstmt.executeUpdate();
        }
    }

    public void modify_code_postal(int userid, String newcode) throws Exception {
        newcode = Formater.format(newcode);
        String query = "UPDATE utilisateurs SET code_postal = ? WHERE id = ?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, newcode);
            pstmt.setInt(2, userid);
            
            pstmt.executeUpdate();
        }
    }

    public boolean checkPassword(String username, String password) {
        ResultSet rs;
        try {
            rs = conn.createStatement().executeQuery("SELECT mot_de_passe FROM utilisateurs WHERE nom = '" + username + "';");
            return rs.getString(1).equals(password);
        } catch (SQLException e) {
            return false;
        }
    }

    public int getMaxID() {
        try {
            ResultSet rs = conn.createStatement().executeQuery("SELECT MAX(id) FROM utilisateurs;");
            return rs.getInt(1);
        } catch (Exception e) {
            return 0;
        }
    }

    public void addUser(String username, String password, String email, String code_postal) throws Exception {
        email = Formater.format(email);
        code_postal = Formater.format(code_postal);
        conn.createStatement().execute("INSERT INTO utilisateurs (nom, mot_de_passe, email, argent, admin, code_postal) VALUES ('" + username + "', '" + password + "', '" + email + "', 0, false, +'"+code_postal+"');");
    }

    public boolean usernamePris(String username) throws Exception {
        ResultSet rs = conn.createStatement().executeQuery("SELECT COUNT(*) FROM utilisateurs WHERE nom = '" + username + "';");
        return rs.getInt(1)!=0;
    }

    public boolean emailPris(String email) throws Exception {
        ResultSet rs = conn.createStatement().executeQuery("SELECT COUNT(*) FROM utilisateurs WHERE email = '" + email + "';");
        return rs.getInt(1)!=0;
    }

    public void addOffre(String nom, String description, int prix, int vendeur, String categorie) throws Exception {
        nom = Formater.format(nom);
        description = Formater.format(description);
        conn.createStatement().execute("INSERT INTO offres (nom, description, prix, id_vendeur, categorie, date_depot) VALUES ('" + nom + "', '" + description + "', " + prix + ", " + vendeur + ", '" + categorie + "', strftime('%Y-%m-%d %H:%M:%S', datetime('now')) );");
    }

    public boolean isAdmin(int userid) throws Exception {
        ResultSet rs = conn.createStatement().executeQuery("SELECT admin FROM utilisateurs WHERE id = " + userid + ";");
        return rs.getBoolean(1);
    }

    public void addAdmin(int userid) throws Exception {
        conn.createStatement().execute("UPDATE utilisateurs SET admin = true WHERE id = " + userid + ";");
    }

    public void removeAdmin(int userid) throws Exception {
        conn.createStatement().execute("UPDATE utilisateurs SET admin = false WHERE id = " + userid + ";");
    }

    public void addReclamation(int userid, String message) throws Exception {
        message = Formater.format(message);
        conn.createStatement().execute("INSERT INTO reclamations (id_utilisateur, message, date) VALUES (" + userid + ", '" + message + "', strftime('%Y-%m-%d %H:%M:%S', datetime('now')) );");
    }

    public Date getdatedebut(int offreid) throws Exception {
        ResultSet rs = conn.createStatement().executeQuery("SELECT date_debut FROM plannings_reservations WHERE id_offre = " + offreid + ";");
        return rs.getDate(1);
    }

    public Date getdatefin(int offreid) throws Exception {
        ResultSet rs = conn.createStatement().executeQuery("SELECT date_fin FROM plannings_reservations WHERE id_offre = " + offreid + ";");
        return rs.getDate(1);
    }

    public int[] getOffresPlanning(int userid) throws Exception {
        ResultSet rs = conn.createStatement().executeQuery("SELECT id FROM plannings_reservations WHERE id_utilisateur = " + userid + ";");
        int[] offres = new int[100];
        int i = 0;
        while (rs.next()) {
            offres[i] = rs.getInt(1);
            i++;
        }
        return offres;
    }

    public String getNomOffre(int offreid) throws Exception {
        ResultSet rs = conn.createStatement().executeQuery("SELECT nom FROM offres WHERE id = " + offreid + ";");
        return rs.getString(1);
    }
    public String[] getUserInfos(int id) {
        try {
            ResultSet rs = conn.createStatement().executeQuery("SELECT nom, mot_de_passe, email, argent, code_postal, admin FROM utilisateurs WHERE id = " + id + ";");
            String[] infos = new String[6];
            infos[0] = rs.getString(1);
            infos[1] = rs.getString(2);
            infos[2] = rs.getString(3);
            infos[3] = rs.getString(4);
            infos[4] = rs.getString(5);
            infos[5] = rs.getString(6);
            return infos;
        } catch (Exception e) {
            return null;
        }
    }

    public String[] getmessages(int iduser1,int iduser2, int page)
    {
        try {
            ResultSet rs = conn.createStatement().executeQuery("SELECT message FROM messages WHERE ( id_utilisateur_envoie = " + iduser1 + " AND id_utilisateur_recoit = " + iduser2 + " ) OR ( id_utilisateur_envoie = " + iduser2 + " AND id_utilisateur_recoit = " + iduser1 + " ) ORDER BY date_envoi DESC LIMIT 4 OFFSET " + (page-1)*4 + ";");
            String[] messages = new String[4];
            int i = 0;
            while (rs.next()) {
                messages[i] = rs.getString(1);
                // Debug
                System.out.println(messages[i]);
                i++;
            }
            return messages;
        }
        catch (Exception e) {
            return null;
        }
    }

    public String[] getOffreInfosAccueil(int page) {
        // Les pages donnent les annoncent 4 par 4
        // La requète demande les dernières annonces enregistrées

        try {
            ResultSet rs = conn.createStatement().executeQuery("SELECT nom, id_vendeur, prix, categorie, description, date_depot FROM offres ORDER BY date_depot DESC LIMIT 4 OFFSET " + (page-1)*4 + ";");
            String[] infos = new String[24];
            int i = 0;
            while (rs.next()) {
                infos[i] = rs.getString(1);
                infos[i+1] = rs.getString(2);
                infos[i+2] = rs.getString(3);
                infos[i+3] = rs.getString(4);
                infos[i+4] = rs.getString(5);
                infos[i+5] = rs.getString(6);
                i += 6;
            }
            return infos;
        } catch (Exception e) {
            return null;
        }
    }

    public void addmessage(int iduser1,int iduser2,String message)
    {
        try {
            conn.createStatement().execute("INSERT INTO messages (id_utilisateur_envoie,id_utilisateur_recoit,message,date_envoi) VALUES (" + iduser1 + "," + iduser2 + ",'" + message + "', strftime('%Y-%m-%d %H:%M:%S', datetime('now')));");
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    public double getNote(int offreid) throws Exception {
        ResultSet rs = conn.createStatement().executeQuery("SELECT AVG(valeur_evaluation) FROM evaluations WHERE id_offre = " + offreid + ";");
        double sortie = rs.getDouble(1);
        sortie = Math.round(sortie * 10) / 10; // Arrondi à 1 chiffre après la virgule
        return sortie;
    }

    public double getUserNoteMoyenne(int userid) throws Exception {
        ResultSet rs = conn.createStatement().executeQuery("SELECT AVG(valeur_evaluation) FROM evaluations JOIN offres ON evaluations.id_offre = offres.id WHERE offres.id_vendeur = " + userid + ";");
        double sortie = rs.getDouble(1);
        sortie = Math.round(sortie * 10) / 10; // Arrondi à 1 chiffre après la virgule
        return sortie;
    }

    public void addEvaluation(int notant, int offre, int valeur) {
        try {
            conn.createStatement().execute("INSERT INTO evaluations (id_offre, id_evaluant, valeur_evaluation) VALUES (" + offre + ", " + notant + ", " + valeur + ");");
        } catch (Exception e) {
            System.out.println("[DEBUG] Erreur lors de l'ajout de l'évaluation");
        }
    }

    public boolean isEvaluable(int notant, int offre) {
        try {
            ResultSet rs = conn.createStatement().executeQuery("SELECT COUNT(*) FROM evaluations WHERE id_offre = " + offre + " AND id_evaluant = " + notant + ";");
            return rs.getInt(1) == 0;
        } catch (Exception e) {
            return false;
        }
    }

    public ResultSet getReclamations() throws Exception {
        return conn.createStatement().executeQuery("SELECT * FROM reclamations WHERE resolu=false;");
    }

    public ResultSet getAllReclamations() throws Exception {
        return conn.createStatement().executeQuery("SELECT * FROM reclamations;");
    }

    public void resolu(int id) throws Exception {
        conn.createStatement().execute("UPDATE reclamations SET resolu = true WHERE id = " + id + ";");
    }

    public int getmessagewriter(String message, int iduser1, int iduser2)
    {
        try {
            ResultSet rs = conn.createStatement().executeQuery("SELECT id_utilisateur_envoie FROM messages WHERE message = '" + message + "' AND ( id_utilisateur_envoie = " + iduser1 + " AND id_utilisateur_recoit = " + iduser2 + " ) OR ( id_utilisateur_envoie = " + iduser2 + " AND id_utilisateur_recoit = " + iduser1 + ");");
            return rs.getInt(1);
        } catch (Exception e) {
            return 0;
        }
    }

}

