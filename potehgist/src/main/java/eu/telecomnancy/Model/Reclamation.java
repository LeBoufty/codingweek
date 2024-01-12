package eu.telecomnancy.Model;

public class Reclamation {
    private int id;
    private int id_utilisateur;
    private String message;
    private String date;

    public Reclamation(int id, int id_utilisateur, String message, int date) {
        this.id_utilisateur = id_utilisateur;
        this.message = message;
        Date_M date_M = new Date_M(date);
        this.date = date_M.getAlldateAAAAMMJJHHMM();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate(){
        return date;
    }

    public void setDate(int date){
        Date_M date_M = new Date_M(date);
        this.date = date_M.getAlldateAAAAMMJJHHMM();
    }

    // Additional methods, if needed
}
