package eu.telecomnancy.Model;

import java.util.ArrayList;
import eu.telecomnancy.BDD_App.API;

public class Annonce_en_creation {
    
    public String titre;
    public String description;
    public Integer prix;
    public byte[] photo;
    public String categorie;
    public long date_debut_materiel;
    public long date_fin_materiel;

    public ArrayList<Long> date_debut_service_ponctuel = new ArrayList<Long>();
    public int nb_minute_service;
    

    public Annonce_en_creation(String titre, String description, Integer prix, byte[] photo, String categorie) {
        this.titre = titre;
        this.description = description;
        this.prix = prix;
        this.photo = photo.clone();
        this.categorie = categorie;
    }
    
    public void create_annonce() throws Exception {
        if (categorie.equals("Materiel")) {
            System.out.println("Non géré ici");
        } else if (categorie.equals("Service")) {
            API.getInstance().addOffre(this);
            System.out.println("Request sent to API to add annonce");
            API.getInstance().addPlaningService(this);
        }
    }

}
