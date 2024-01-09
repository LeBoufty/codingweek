package eu.telecomnancy;

import eu.telecomnancy.BDD_App.API;

public class Utilisateur {
    private int id;
    private String nom;
    private String mot_de_passe;
    private String email;
    private int argent;
    private String code_postal;
    private boolean admin;
    private static int id_max = API.getInstance().getMaxID();

    public Utilisateur(String nom, String mot_de_passe, String email, String code_postal) {
        this.nom = nom;
        this.mot_de_passe = Formater.hash(mot_de_passe);
        this.email = email;
        this.argent = 0;
        this.code_postal = code_postal;
        this.admin = false;
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
            this.admin = Boolean.parseBoolean(infos[5]);
        } catch (Exception e) {
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
        } catch (Exception e) {
            System.out.println("[DEBUG] Erreur lors de l'ajout de l'utilisateur");
        }
    }

    public int getId() {
        return id;
    }
}
