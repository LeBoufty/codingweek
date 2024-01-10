package eu.telecomnancy.Model;

import java.time.LocalDateTime;

public class Reclamation {
    private int id;
    private int id_utilisateur;
    private String message;
    private LocalDateTime date;

    public Reclamation(int id, int id_utilisateur, String message, LocalDateTime date) {
        this.id = id;
        this.id_utilisateur = id_utilisateur;
        this.message = message;
        this.date = date;
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    // Additional methods, if needed
}
