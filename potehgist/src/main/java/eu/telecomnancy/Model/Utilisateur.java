package eu.telecomnancy.Model;

import java.util.ArrayList;

import eu.telecomnancy.BDD_App.API;
import eu.telecomnancy.Outils.Formater;

public class Utilisateur {
    private int id;
    private String nom;
    private String mot_de_passe;
    private String email;
    private int argent;
    private String code_postal;
    private boolean admin;
    private byte[] image;
    private static int id_max = API.getInstance().getMaxID();

    public Utilisateur(String nom, String mot_de_passe, String email, String code_postal, byte[] image) {
        this.nom = nom;
        this.mot_de_passe = Formater.hash(mot_de_passe);
        this.email = email;
        this.argent = 100;
        this.code_postal = code_postal;
        this.admin = false;
        this.image = image;
        this.id = ++id_max;
    }

    public Utilisateur(String nom, String mot_de_passe, String email, String code_postal) throws Exception {
        this.nom = nom;
        this.mot_de_passe = Formater.hash(mot_de_passe);
        this.email = email;
        this.argent = 100;
        this.code_postal = code_postal;
        this.admin = false;

        String path = getClass().getResource("/eu/telecomnancy/assets/").toExternalForm() + "logo.png";
        path = path.substring(5);

        this.image = ImageBlob.pathtToByte(path);
        this.id = ++id_max;
    }

    public Utilisateur(int id) {
        this.id = id;
        try {
            String[] infos = API.getInstance().getUserInfos(id);
            this.nom = infos[0];
            this.mot_de_passe = infos[1];
            this.email = infos[2];
            this.argent = Integer.parseInt(infos[3]);
            this.code_postal = infos[4];
            this.admin = infos[5].equals("true");
            this.image = infos[6].getBytes();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("[DEBUG] Utilisateur non trouvé");
        }
    }

    public Utilisateur() {
        this.id = 0;
        this.nom = "Invité";
        this.mot_de_passe = "12345678";
        this.email = "invite@potehgist.net";
        this.argent = 0;
        this.code_postal = "54000";
        this.admin = false;
    }

    public void saveAsNew() {
        try {
            API.getInstance().addUser(nom, mot_de_passe, email, code_postal);
            this.id = API.getInstance().getUserid(nom);
            id_max = API.getInstance().getMaxID();
            save();
        } catch (Exception e) {
            System.out.println("[DEBUG] Erreur lors de l'ajout de l'utilisateur");
        }
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public byte[] getImage() {
        return image;
    }

    public void save() {
        if (id == 0) {
            return;
        }
        try {
            API.getInstance().modifyUsername(id, nom);
            API.getInstance().modifyemail(id, email);
            API.getInstance().modifymdp(id, mot_de_passe);
            API.getInstance().modify_code_postal(id, code_postal);
            API.getInstance().modifyargent(id, argent);
            API.getInstance().modifyadmin(id, admin);
            API.getInstance().modifyimage(id, image);
        } catch (Exception e) {
            System.out.println("[DEBUG] Erreur lors de la modification de l'utilisateur");
        }
    }

    public boolean pay(int prix, int destinataire) {
        if (argent < prix) {
            return false;
        }
        try {
            argent -= prix;
            Utilisateur user = new Utilisateur(destinataire);
            user.argent += prix;
            user.save();
            save();
        } catch (Exception e) {
            System.out.println("[DEBUG] Erreur lors du paiement");
            return false;
        }
        return true;
    }

    public ArrayList<Annonce> getAnnonces() {
        ArrayList<Annonce> annonces = new ArrayList<>();
        try {
            ArrayList<Integer> ids = API.getInstance().getOffresFromUser(id);
            for (int id : ids) {
                annonces.add(new Annonce(id));
            }
        } catch (Exception e) {
            System.out.println("[DEBUG] Erreur lors de la récupération des annonces");
        }
        return annonces;
    }

    public void ajouterArgent(int montant) {
        argent += montant;
        save();
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public String getEmail() {
        return email;
    }

    public int getArgent() {
        return argent;
    }

    public String getCode_postal() {
        return code_postal;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = Formater.hash(mot_de_passe);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setArgent(int argent) {
        this.argent = argent;
    }

    public void setCode_postal(String code_postal) {
        this.code_postal = code_postal;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
