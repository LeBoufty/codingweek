package eu.telecomnancy.Model;

public class Annonce_Recherche {
    
    public String recherche_text;
    public String recherche_code_postal;
    public String recherche_date_apres;
    public String recherche_date_avant;
    public boolean recherche_materiel;
    public boolean recherche_service;
    public int recherche_florin_min;
    public int recherche_florin_max;
    public int recherche_note_min;

    public Annonce_Recherche() {
        this.recherche_text = "";
        this.recherche_code_postal = "";
        this.recherche_date_apres = "";
        this.recherche_date_avant = "";
        this.recherche_materiel = true;
        this.recherche_service = true;
        this.recherche_florin_min = -1;
        this.recherche_florin_max = -1;
    }

    public void setDefault() {
        this.recherche_text = "";
        this.recherche_code_postal = "";
        this.recherche_date_apres = "";
        this.recherche_date_avant = "";
        this.recherche_materiel = true;
        this.recherche_service = true;
        this.recherche_florin_min = -1;
        this.recherche_florin_max = -1;
    }

}
