package eu.telecomnancy.Model;

import eu.telecomnancy.BDD_App.API;

public class Notification {
    private String description;
    private int id_utilisateur;
    private int id;
    private int date;
    private boolean vue;
    private static int maxid = API.getInstance().getMaxNotificationID();
    


    public Notification(int id, int id_utilisateur, String description, int date, boolean vue) {
        this.description = description;
        this.id_utilisateur = id_utilisateur;
        this.date = date;
        this.id = ++maxid;
        this.vue = vue;
    }

    public Notification(){

    }

    public Notification(int id) {
        String[] infos = API.getInstance().getNotifInfos(id);
        this.id = id;
        this.id_utilisateur = Integer.parseInt(infos[0]);
        this.description = infos[1];
        this.date = Integer.parseInt(infos[2]);
        if(infos[3].equals("true"))
        {
            this.vue = true;
        }
        else
        {
            this.vue = false;
        }
    }

    public void save() {
        try {
            API.getInstance().updateNotif(id, id_utilisateur, description, date, vue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveAsNew() {
        try {
            API.getInstance().addnotif(id, description);
            this.id = API.getInstance().getMaxOffreID();
            maxid = id;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public int getdate() {
        return this.date;
    }

    public String getMessage() {
        return this.description;
    }

    public void setdate(int date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description.trim();
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie.trim();
    }

    public String getDate_depot() {
        return date_depot;
    }

    public void setDate_depot(String date_depot) {
        this.date_depot = date_depot.trim();
    }

    public Utilisateur getVendeur() {
        return vendeur;
    }

    public void setVendeur(Utilisateur vendeur) {
        this.vendeur = vendeur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        maxid = Math.max(maxid, id);
    }

    public String getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(String code_postal) {
        code_postal = code_postal.trim();
        this.code_postal = code_postal;
    }
}
