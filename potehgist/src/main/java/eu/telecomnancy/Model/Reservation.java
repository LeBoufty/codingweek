package eu.telecomnancy.Model;

import eu.telecomnancy.BDD_App.API;

public class Reservation {
    private Utilisateur user;
    private Annonce annonce;
    private String date_debut;
    private String date_fin;
    private int id;
    private static int id_max = API.getInstance().getMaxReservationID();

    public Reservation(Utilisateur user, Annonce annonce, String date_debut, String date_fin) {
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
        this.date_debut = infos[2];
        this.date_fin = infos[3];
    }

    public void saveAsNew() {
        try {
            API.getInstance().addReservation(user.getId(), annonce.getId(), date_debut, date_fin);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
