package eu.telecomnancy.Model;

import java.sql.Date;

import eu.telecomnancy.BDD_App.API;

public class Reservation {
    private Utilisateur user;
    private Annonce annonce;
    private Date date_debut;
    private Date date_fin;
    private int id;
    private static int id_max = API.getInstance().getMaxReservationID();

    public Reservation(Utilisateur user, Annonce annonce, Date date_debut, Date date_fin) {
        this.user = user;
        this.annonce = annonce;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.id = ++id_max;
    }

    public Reservation(int id) {
        this.id = id;
        String[] infos = API.getInstance().getReservationInfos(id);
        this.user = new Utilisateur(Integer.parseInt(infos[0]));
        this.annonce = new Annonce(Integer.parseInt(infos[1]));
        this.date_debut = Date.valueOf(infos[2]);
        this.date_fin = Date.valueOf(infos[3]);
    }

    public void saveAsNew() {
        try {
            API.getInstance().addReservation(user.getId(), annonce.getId(), date_debut.toString(), date_fin.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public int getId_utilisateur() {
        return user.getId();
    }

    public int getId_offre() {
        return annonce.getId();
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

}
