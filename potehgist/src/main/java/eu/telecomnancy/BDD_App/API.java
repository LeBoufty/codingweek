package eu.telecomnancy.BDD_App;

import java.io.File;
import java.nio.file.Files;
import java.sql.Connection;
// import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

import eu.telecomnancy.App;
import eu.telecomnancy.Model.Annonce;
import eu.telecomnancy.Model.Annonce_Recherche;
import eu.telecomnancy.Model.Annonce_en_creation;
import eu.telecomnancy.Model.Date_M;
import eu.telecomnancy.Model.Utilisateur;
import eu.telecomnancy.Outils.Formater;

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

    public void modifyimage(int userid, byte[] image) throws Exception {
        String query = "UPDATE utilisateurs SET image_profil = ? WHERE id = ?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setBytes(1, image);
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
            if (!rs.next()) {
                return false;
            }
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

    public int getMaxOffreID() {
        try {
            ResultSet rs = conn.createStatement().executeQuery("SELECT MAX(id) FROM offres;");
            return rs.getInt(1);
        } catch (Exception e) {
            return 0;
        }
    }

    public int getMaxMessageID() {
        try {
            ResultSet rs = conn.createStatement().executeQuery("SELECT MAX(id) FROM messages;");
            return rs.getInt(1);
        } catch (Exception e) {
            return 0;
        }
    }

    public int getMaxReservationID() {
        try {
            ResultSet rs = conn.createStatement().executeQuery("SELECT MAX(id) FROM plannings_reservations;");
            return rs.getInt(1);
        } catch (Exception e) {
            return 0;
        }
    }

    public int getMaxNotificationID() {
        try {
            ResultSet rs = conn.createStatement().executeQuery("SELECT MAX(id) FROM notifications;");
            return rs.getInt(1);
        } catch (Exception e) {
            return 0;
        }
    }

    public void addUser(String username, String password, String email, String code_postal) throws Exception {
        email = Formater.format(email);
        code_postal = Formater.format(code_postal);
        String query = "INSERT INTO utilisateurs (nom, mot_de_passe, email, argent, admin, code_postal, image_profil) VALUES (?, ?, ?, ?, ?, ?, ?);";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, email);
            pstmt.setInt(4, 0);
            pstmt.setBoolean(5, false);
            pstmt.setString(6, code_postal);
            // System.out.println(getClass().getResource("/eu/telecomnancy/assets/placeholder.png").toExternalForm());
            String path = getClass().getResource("/eu/telecomnancy/assets/placeholder.png").toExternalForm();
            // retire file: au début
            path = path.substring(5);
            // System.out.println(path);
            File imageFile = new File(path);
            // System.out.println(imageFile.exists());
            byte[] imageData = Files.readAllBytes(imageFile.toPath());
            pstmt.setBytes(7, imageData);
            pstmt.executeUpdate();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Erreur lors de l'ajout de l'utilisateur");
        }
    }

    public void getImageUser(int userid) throws Exception {
        ResultSet rs = conn.createStatement().executeQuery("SELECT image_profil FROM utilisateurs WHERE id = " + userid + ";");
        byte[] imageBytes = rs.getBytes(1);
        String outputpath = getClass().getResource("/eu/telecomnancy/assets/").toExternalForm() + "user_photo.png";
        outputpath = outputpath.substring(5);
        
        Files.write(new File(outputpath).toPath(), imageBytes);
    }

    public ArrayList<Integer> getOffresFromUser(int userid) throws Exception {
        ResultSet rs = conn.createStatement().executeQuery("SELECT id FROM offres WHERE id_vendeur = " + userid + ";");
        ArrayList<Integer> offres = new ArrayList<Integer>();
        while (rs.next()) {
            offres.add(rs.getInt(1));
        }
        return offres;
    }

    public boolean usernamePris(String username) throws Exception {
        ResultSet rs = conn.createStatement().executeQuery("SELECT COUNT(*) FROM utilisateurs WHERE nom = '" + username + "';");
        return rs.getInt(1)!=0;
    }

    public boolean emailPris(String email) throws Exception {
        ResultSet rs = conn.createStatement().executeQuery("SELECT COUNT(*) FROM utilisateurs WHERE email = '" + email + "';");
        return rs.getInt(1)!=0;
    }

    public ArrayList<Date_M> getDatePlaningOffre(int offreid) throws Exception {
        String query = "SELECT date_debut, date_fin FROM plannings_offres WHERE id_offre = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setInt(1, offreid);
        ResultSet rs = preparedStatement.executeQuery();
        ArrayList<Date_M> dates = new ArrayList<Date_M>();
        while (rs.next()) {
            dates.add(new Date_M(rs.getInt(1)));
            dates.add(new Date_M(rs.getInt(2)));
        }
        return dates;
    }

    public void addPreReservation(int userid, int offreid, int datedebut, int datefin) throws Exception {
        String query = "INSERT INTO plannings_prereservations (id_utilisateur, id_offre, date_debut, date_fin) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        
        preparedStatement.setInt(1, userid);
        preparedStatement.setInt(2, offreid);
        preparedStatement.setInt(3, datedebut);
        preparedStatement.setInt(4, datefin);

        preparedStatement.execute();
    }

    public void addPlaningMateriel(Annonce_en_creation annonce) throws Exception {
        String insertInfoSQL = "INSERT INTO plannings_offres (id_offre, date_debut, date_fin) VALUES (?, ?, ?)";
        PreparedStatement preparedStatementInfo = conn.prepareStatement(insertInfoSQL);
        preparedStatementInfo.setInt(1, getMaxOffreID());
        preparedStatementInfo.setInt(2, (int) annonce.date_debut_materiel);
        preparedStatementInfo.setInt(3, (int) annonce.date_fin_materiel);
        preparedStatementInfo.executeUpdate();
    }

    public void addPlaningService(Annonce_en_creation annonce) throws Exception {
        for (int i = 0; i < annonce.date_debut_service_ponctuel.size(); i++) {
            String insertInfoSQL = "INSERT INTO plannings_offres (id_offre, date_debut, date_fin) VALUES (?, ?, ?)";
            PreparedStatement preparedStatementInfo = conn.prepareStatement(insertInfoSQL);
            preparedStatementInfo.setInt(1, getMaxOffreID());
            Long date_debut = annonce.date_debut_service_ponctuel.get(i);
            preparedStatementInfo.setInt(2, date_debut.intValue());
            Long date_fin = date_debut + annonce.nb_minute_service * 60;
            preparedStatementInfo.setInt(3, date_fin.intValue());
            preparedStatementInfo.executeUpdate();
        }
    }

    public void addOffre(Annonce_en_creation annonce) throws Exception {
        Utilisateur user = App.getUser();
        addOffre(annonce.titre, annonce.description, annonce.prix, user.getId(), annonce.categorie, annonce.photo);
    }

    public void addOffre(String nom, String description, int prix, int vendeur, String categorie, byte[] photo) throws Exception {

        addOffre(nom, description, prix, vendeur, categorie);
    
        // Get the ID of the last inserted row
        int offreID = getMaxOffreID();
    
        // Insert the photo into the database using the obtained ID
        String insertPhotoSQL = "UPDATE offres SET photo = ? WHERE id = ?";
        try (PreparedStatement preparedStatementPhoto = conn.prepareStatement(insertPhotoSQL)) {
            preparedStatementPhoto.setBytes(1, photo);
            preparedStatementPhoto.setInt(2, offreID);
            preparedStatementPhoto.executeUpdate();
        }
    }
    

    public void addOffre(String nom, String description, int prix, int vendeur, String categorie) throws Exception {
        nom = Formater.format(nom);
        description = Formater.format(description);
    
        // Insert basic information into the database
        String insertInfoSQL = "INSERT INTO offres (nom, description, prix, id_vendeur, categorie, date_depot) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatementInfo = conn.prepareStatement(insertInfoSQL)) {
            preparedStatementInfo.setString(1, nom);
            preparedStatementInfo.setString(2, description);
            preparedStatementInfo.setInt(3, prix);
            preparedStatementInfo.setInt(4, vendeur);
            preparedStatementInfo.setString(5, categorie);
            preparedStatementInfo.setInt(6, (int) Date_M.now().getDate());
            preparedStatementInfo.executeUpdate();
        }
    }

    public void addReservation(int userid, int offreid, int datedebut, int datefin) throws Exception {
        conn.createStatement().execute("INSERT INTO plannings_reservations (id_utilisateur, id_offre, date_debut, date_fin) VALUES (" + userid + ", " + offreid + ", '" + datedebut + "', '" + datefin + "');");
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
        conn.createStatement().execute("INSERT INTO reclamations (id_utilisateur, message, date) VALUES (" + userid + ", '" + message + "', "+(int)Instant.now().getEpochSecond()+" );");
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
            ResultSet rs = conn.createStatement().executeQuery("SELECT nom, mot_de_passe, email, argent, code_postal,image_profil, admin FROM utilisateurs WHERE id = " + id + ";");
            String[] infos = new String[7];
            infos[0] = rs.getString(1);
            infos[1] = rs.getString(2);
            infos[2] = rs.getString(3);
            infos[3] = String.valueOf(rs.getInt(4));
            infos[4] = rs.getString(5);
            infos[5] = rs.getString(6);
            infos[6] = String.valueOf(rs.getBoolean(7));
            return infos;
        } catch (Exception e) {
            return null;
        }
    }

    public String[] getMessagesInfos(int id) {
        try {
            ResultSet rs = conn.createStatement().executeQuery("SELECT id_utilisateur_envoie, id_utilisateur_recoit, message, date_envoi FROM messages WHERE id = " + id + ";");
            String[] infos = new String[4];
            infos[0] = String.valueOf(rs.getInt(1));
            infos[1] = String.valueOf(rs.getInt(2));
            infos[2] = rs.getString(3);
            infos[3] = String.valueOf(rs.getInt(4));

            return infos;
        } catch (Exception e) {
            return null;
        }
    }

    public String[] getOffreInfos(int id) {
        try {
            ResultSet rs = conn.createStatement().executeQuery("SELECT nom, id_vendeur, prix, categorie, description, date_depot FROM offres WHERE id = " + id + ";");
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

    public String[] getNotifInfos(int id) {
        try {
            ResultSet rs = conn.createStatement().executeQuery("SELECT id_utilisateur, message, date, vue, type, iduser2 FROM notifications WHERE id = " + id + ";");
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

    public void getImageAnnonce(int annonce_id) throws Exception {
        ResultSet rs = conn.createStatement().executeQuery("SELECT photo FROM offres WHERE id = " + annonce_id + ";");
        byte[] imageBytes = rs.getBytes(1);
        String outputpath = getClass().getResource("/eu/telecomnancy/assets/").toExternalForm() + "annonce_image.png";
        outputpath = outputpath.substring(5);
        
        Files.write(new File(outputpath).toPath(), imageBytes);
    }

    public int[] getReservationInfos(int id) {
        try {
            ResultSet rs = conn.createStatement().executeQuery("SELECT id_utilisateur, id_offre, date_debut, date_fin FROM plannings_reservations WHERE id = " + id + ";");
            int[] infos = new int[4];
            infos[0] = rs.getInt(1);
            infos[1] = rs.getInt(2);
            infos[2] = rs.getInt(3);
            infos[3] = rs.getInt(4);
            return infos;
        } catch (Exception e) {
            return null;
        }
    }

    public void updateReservation(int id, String datedebut, String datefin) throws Exception {
        conn.createStatement().execute("UPDATE plannings_reservations SET date_debut = '" + datedebut + "', date_fin = '" + datefin + "' WHERE id = " + id + ";");
    }

    public void updateOffre(int id, String nom, String description, int prix, String categorie) throws Exception {
        nom = Formater.format(nom);
        description = Formater.format(description);
        conn.createStatement().execute("UPDATE offres SET nom = '" + nom + "', description = '" + description + "', prix = " + prix + ", categorie = '" + categorie + "' WHERE id = " + id + ";");
    }

    public void updateNotif(int id, int id_utilisateur, String description, int date, boolean vue) throws Exception {
        description = Formater.format(description);
        conn.createStatement().execute("UPDATE notifications SET id_utilisateur = '" + id_utilisateur + "', message = '" + description + "', date = " + date + ", vue = '" + vue + "' WHERE id = " + id + ";");
    }
    public void updateMessage(int id, int id_utilisateur_envoie,int id_utilisateur_recoit, String message, int date) throws Exception {
        message = Formater.format(message);
        conn.createStatement().execute("UPDATE messages SET id_utilisateur_envoie = '" + id_utilisateur_envoie + "', id_utilisateur_recoit = '" + id_utilisateur_recoit + "', message = '" + message + "', date_envoi = " + date + " WHERE id = " + id + ";");
    }

    public ResultSet getmessages(int iduser1,int iduser2) throws Exception {
        return conn.createStatement().executeQuery("SELECT * FROM messages WHERE ( id_utilisateur_envoie = " + iduser1 + " AND id_utilisateur_recoit = " + iduser2 + " ) OR ( id_utilisateur_envoie = " + iduser2 + " AND id_utilisateur_recoit = " + iduser1 + " ) ORDER BY date_envoi ASC;");
        
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
            conn.createStatement().execute("INSERT INTO messages (id_utilisateur_envoie, id_utilisateur_recoit, message,date_envoi) VALUES (" + iduser1 + "," + iduser2 + ",'" + message + "', "+(int)Instant.now().getEpochSecond()+" );");
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

    public String[] getLastFiveChat(int iduser) {
        // Renvoie les 5 derniers utilisateurs avec qui l'utilisateur a discuté
        try {
            ResultSet rs = conn.createStatement().executeQuery("SELECT id_utilisateur_envoie, id_utilisateur_recoit FROM messages WHERE id_utilisateur_envoie = " + iduser + " OR id_utilisateur_recoit = " + iduser + " ORDER BY date_envoi DESC;");
            ArrayList<Integer> users = new ArrayList<Integer>();

            while (rs.next()) {
                int id1 = rs.getInt(1);
                int id2 = rs.getInt(2);
                if (id1 != iduser && !users.contains(id1)) {
                    users.add(id1);
                }
                if (id2 != iduser && !users.contains(id2)) {
                    users.add(id2);
                }
            }

            String[] usernames = new String[5];
            for (int i = 0; i < 5; i++) {
                if (i < users.size()) {
                    usernames[i] = getUsername(users.get(i));
                } else {
                    usernames[i] = "";
                }
            }
            return usernames;

        } catch (Exception e) {
            return null;
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

    public ArrayList<Annonce> getAnnoncesRecherche(Annonce_Recherche recherche) throws Exception {

        ArrayList<Annonce> list_annonces = new ArrayList<Annonce>();

        String code_postal = recherche.recherche_code_postal;
        String date_apres = recherche.recherche_date_apres;
        String date_avant = recherche.recherche_date_avant;
        String text = recherche.recherche_text;
        boolean materiel = recherche.recherche_materiel;
        boolean service = recherche.recherche_service;
        int florin_min = recherche.recherche_florin_min;
        int florin_max = recherche.recherche_florin_max;
        int note_min = recherche.recherche_note_min;

        String query = "SELECT * FROM offres WHERE ";
        if (!code_postal.equals("")) {
            query += " id_vendeur IN (SELECT id FROM utilisateurs WHERE code_postal = '" + code_postal + "') AND ";
        }
        if (!date_apres.equals("")) {
            query += "date_depot >= '" + date_apres + "' AND ";
        }
        if (!date_avant.equals("")) {
            query += "date_depot <= '" + date_avant + "' AND ";
        }
        if (!text.equals("")) {
            query += "nom LIKE '%" + text + "%' AND ";
        }
        if (materiel && !service) {
            query += "categorie = 'materiel' AND ";
        }
        if (!materiel && service) {
            query += "categorie = 'service' AND ";
        }
        if (florin_min != -1) {
            query += "prix >= " + florin_min + " AND ";
        }
        if (florin_max != -1) {
            query += "prix <= " + florin_max + " AND ";
        }
        if (note_min != -1) { // fait la moyenne des notes de l'utilisateur : si la moyenne est inférieure à note_min, on ne renvoie pas l'annonce
            query += "id_vendeur IN (SELECT id_vendeur FROM offres JOIN evaluations ON offres.id = evaluations.id_offre GROUP BY id_vendeur HAVING AVG(valeur_evaluation) >= " + note_min + ") AND ";
        }
        query += "1=1";
        query += " ORDER BY date_depot DESC;";

        System.out.println(query);
        ResultSet rs = conn.createStatement().executeQuery(query);
        while (rs.next()) {
            Annonce annonce = new Annonce(rs.getInt("id"));
            list_annonces.add(annonce);
        }
        
        return list_annonces;
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

    public Date[] getthreedatesnotif(int iduser, int page)
    {
        try {
            ResultSet rs = conn.createStatement().executeQuery("SELECT date FROM notifications WHERE id_utilisateur = " + iduser + " ORDER BY date DESC LIMIT 3 OFFSET " + (page-1)*3 + ";");
            Date[] dates = new Date[3];
            int i = 0;
            while (rs.next()) {
                dates[i] = rs.getDate(1);
                i++;
            }
            return dates;
        } catch (Exception e) {
            return null;
        }
    }

    public int[] getthreeidnotif(int iduser, int page)
    {
        try {
            ResultSet rs = conn.createStatement().executeQuery("SELECT id FROM notifications WHERE id_utilisateur = " + iduser + " ORDER BY date DESC LIMIT 3 OFFSET " + (page-1)*3 + ";");
            int[] id = new int[3];
            int i = 0;
            while (rs.next()) {
                id[i] = rs.getInt(1);
                i++;
            }
            return id;
        } catch (Exception e) {
            return null;
        }
    }

    public String[] getthreedescriptionnotif(int iduser, int page)
    {
        try {
            ResultSet rs = conn.createStatement().executeQuery("SELECT message FROM notifications WHERE id_utilisateur = " + iduser + " ORDER BY date DESC LIMIT 3 OFFSET " + (page-1)*3 + ";");
            String[] descriptions = new String[3];
            int i = 0;
            while (rs.next()) {
                descriptions[i] = rs.getString(1);
                i++;
            }
            return descriptions;
        } catch (Exception e) {
            return null;
        }
    }

    public void mettrenotifenvu(int id)
    {
        try {
            conn.createStatement().execute("UPDATE notifications SET vue = true WHERE id = " + id+ " ;");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void addnotif(int iduser, String message, int type, int iduser2)
    {
        try {
            conn.createStatement().execute("INSERT INTO notifications (id_utilisateur, message, date, vue, type, iduser2) VALUES (" + iduser + ", '" + message + "', "+(int)Instant.now().getEpochSecond()+", false, "+ type +", "+iduser2+");");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void addnotif(int iduser, String message, int type)
    {
        try {
            conn.createStatement().execute("INSERT INTO notifications (id_utilisateur, message, date, vue, type, iduser2) VALUES (" + iduser + ", '" + message + "', "+(int)Instant.now().getEpochSecond()+", false, "+ type +", "+ 0 +");");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void dlnotif(int id)
    {
        try {
            conn.createStatement().execute("DELETE FROM notifications WHERE id = " + id + ";");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean checkvunotif(int id)
    {
        try {
            ResultSet rs = conn.createStatement().executeQuery("SELECT vue FROM notifications WHERE id = " + id + ";");
                return rs.getBoolean(1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public ResultSet getReservations(int iduser) throws Exception {
        return conn.createStatement().executeQuery("SELECT * FROM plannings_reservations WHERE id_utilisateur = " + iduser + ";");
        
    }

    public ResultSet getReservationsparannonce(int idannonce) throws Exception {
        return conn.createStatement().executeQuery("SELECT * FROM plannings_reservations WHERE id_offre = " + idannonce + ";");
        
    }

    public ResultSet getNotif(int iduser) throws Exception {
        return conn.createStatement().executeQuery("SELECT * FROM notifications WHERE id_utilisateur = " + iduser + ";");
        
    }

    public void addreservation(int id_utilisateur, int id_offre, int date_debut, int date_fin) {
        try {
            String query = "INSERT INTO plannings_reservations (id_utilisateur, id_offre, date_debut, date_fin) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
    
            preparedStatement.setInt(1, id_utilisateur);
            preparedStatement.setInt(2, id_offre);
            preparedStatement.setInt(3, date_debut);
            preparedStatement.setInt(4, date_fin);
    
            preparedStatement.execute();
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void addSommeils(int id_utilisateur, int date_debut, int date_fin) {
        try {
            String query = "INSERT INTO sommeils (id_utilisateur, date_debut, date_fin) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
    
            preparedStatement.setInt(1, id_utilisateur);
            preparedStatement.setInt(2, date_debut);
            preparedStatement.setInt(3, date_fin);
    
            preparedStatement.execute();
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteSommeils(int id) {
        try {
            String query = "DELETE FROM sommeils WHERE id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
    
            preparedStatement.setInt(1, id);
    
            preparedStatement.execute();
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int getidSommeils(int id_utilisateur, int date_debut, int date_fin) {
        try {
            ResultSet rs = conn.createStatement().executeQuery("SELECT id FROM sommeils WHERE id_utilisateur = " + id_utilisateur + " AND date_debut = " + date_debut + " AND date_fin = " + date_fin + ";");
            return rs.getInt(1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public ResultSet getSommeils(int iduser) throws Exception {
        int date = (int) Instant.now().getEpochSecond();
        return conn.createStatement().executeQuery("SELECT * FROM sommeils WHERE id_utilisateur = " + iduser + " AND "+ date + " < date_fin ;");   
    }
}


    


