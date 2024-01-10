package eu.telecomnancy.Model;

import java.sql.Date;

public class Reservation {
    private int id;
    private int id_utilisateur;
    private int id_offre;
    private Date date_debut;
    private Date date_fin;

    public Reservation(int id, int id_utilisateur, int id_offre, Date date_debut, Date date_fin) {
        this.id = id;
        this.id_utilisateur = id_utilisateur;
        this.id_offre = id_offre;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

    public int getId() {
        return id;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public int getId_offre() {
        return id_offre;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

}
