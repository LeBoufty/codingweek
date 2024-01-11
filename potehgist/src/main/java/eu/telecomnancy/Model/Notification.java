package eu.telecomnancy.Model;

import eu.telecomnancy.BDD_App.API;

public class Notification {
    private String description;
    private int id_utilisateur;
    private int id;
    private int date;
    private boolean vue;
    private int type; // 1 = message
    private int iduser2;
    private static int maxid = API.getInstance().getMaxNotificationID();
    


    public Notification(int id, int id_utilisateur, String description, int date, boolean vue, int type) {
        this.description = description;
        this.id_utilisateur = id_utilisateur;
        this.date = date;
        this.id = ++maxid;
        this.vue = vue;
        this.type = type;
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
        this.type = Integer.parseInt(infos[4]);
        this.iduser2 = Integer.parseInt(infos[5]);
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
            API.getInstance().addnotif(id, description,type);
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

    public void setmessage(String message) {
        this.description = message;
    }

    public int gettype() {
        return type;
    }

    public int getiduser2() {
        return iduser2;
    }
}
