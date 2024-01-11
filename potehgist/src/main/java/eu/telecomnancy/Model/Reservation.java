package eu.telecomnancy.Model;

import eu.telecomnancy.BDD_App.API;

public class Reservation {
    private Utilisateur user;
    private Annonce annonce;
    private int date_debut;
    private int date_fin;
    private int id;
    private static int id_max = API.getInstance().getMaxReservationID();

    public Reservation(Utilisateur user, Annonce annonce, int date_debut, int date_fin) {
        this.user = user;
        this.annonce = annonce;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.id = ++id_max;
    }

    public Reservation(int id) {
        this.id = id;
        int[] infos = API.getInstance().getReservationInfos(id);
        this.user = new Utilisateur(infos[0]);
        this.annonce = new Annonce(infos[1]);
        this.date_debut = infos[2];
        this.date_fin = infos[3];
    }

    public Reservation() {
    }

    public void saveAsNew() {
        try {
            API.getInstance().addReservation(user.getId(), annonce.getId(), date_debut, date_fin);
            this.id = API.getInstance().getMaxReservationID();
            id_max = id;
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

    public int getDate_debut() {
        return date_debut;
    }

    public int getDate_fin() {
        return date_fin;
    }

}
