package eu.telecomnancy.Model;

import eu.telecomnancy.BDD_App.API;

public class Message {
    private String message;
    private int id_utilisateur_envoie;
    private int id_utilisateur_recoit;
    private int id;
    private int date;
    private static int maxid = API.getInstance().getMaxNotificationID();
    


    public Message(int id, int id_utilisateur_envoie,int id_utilisateur_recoit, String message, int date) {
        this.message = message;
        this.id_utilisateur_envoie = id_utilisateur_envoie;
        this.id_utilisateur_recoit = id_utilisateur_recoit;
        this.date = date;
        this.id = ++maxid;
    }

    public Message(){

    }

    public Message(int id) {
        String[] infos = API.getInstance().getMessagesInfos(id);
        this.id = id;
        this.id_utilisateur_envoie = Integer.parseInt(infos[0]);
        this.id_utilisateur_recoit = Integer.parseInt(infos[1]);
        this.message = infos[2];
        this.date = Integer.parseInt(infos[3]);
    }

    public void save() {
        try {
            API.getInstance().updateMessage(id, id_utilisateur_envoie,id_utilisateur_recoit, message, date);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveAsNew() {
        try {
            API.getInstance().addmessage(id_utilisateur_envoie,id_utilisateur_recoit, message);
            this.id = API.getInstance().getMaxMessageID();
            maxid = id;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getmessage() {
        return message;
    }

    public String getAuthor() throws Exception {
        return API.getInstance().getUsername(id_utilisateur_envoie);
    }

    public int getdate() {
        return date;
    }

    public int getAuthorID() {
        return id_utilisateur_envoie;
    }

}
