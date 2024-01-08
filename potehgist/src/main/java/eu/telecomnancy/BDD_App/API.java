package eu.telecomnancy.BDD_App;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class API {
    private static API instance = null;
    private Connection conn;
    private DatabaseMetaData meta;
    private static String url;

    private API() {
        try {
            url = "jdbc:sqlite:"+getClass().getResource("/potehgist.db").toExternalForm();
            conn = DriverManager.getConnection(url);
            meta = conn.getMetaData();
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

    public int getUserid(String username) throws Exception {
        ResultSet rs = conn.createStatement().executeQuery("SELECT id FROM utilisateurs WHERE nom = '" + username + "';");
        return rs.getInt(1);
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
    
    try (PreparedStatement pstmt = conn.prepareStatement(query)) {
        pstmt.setString(1, newemail);
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
    String query = "UPDATE utilisateurs SET code_postal = ? WHERE id = ?";
    
    try (PreparedStatement pstmt = conn.prepareStatement(query)) {
        pstmt.setString(1, newcode);
        pstmt.setInt(2, userid);
        
        pstmt.executeUpdate();
        }
    }

    public boolean checkPassword(String username, String password) throws Exception {
        ResultSet rs = conn.createStatement().executeQuery("SELECT mot_de_passe FROM utilisateurs WHERE nom = '" + username + "';");
        return rs.getString(1).equals(password);
    }

    public int getMaxID() throws Exception {
        ResultSet rs = conn.createStatement().executeQuery("SELECT MAX(id) FROM utilisateurs;");
        try {
            return rs.getInt(1);
        } catch (Exception e) {
            return 0;
        }
    }

    public void addUser(String username, String password, String email, String code_postal) throws Exception {
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
        conn.createStatement().execute("INSERT INTO offres (nom, description, prix, vendeur, categorie, date_depot) VALUES ('" + nom + "', '" + description + "', " + prix + ", " + vendeur + ", '" + categorie + "', GETDATE());");
    }

    public boolean isAdmin(int userid) throws Exception {
        ResultSet rs = conn.createStatement().executeQuery("SELECT admin FROM utilisateurs WHERE id = " + userid + ";");
        return rs.getBoolean(1);
    }
}
