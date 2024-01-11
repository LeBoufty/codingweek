package eu.telecomnancy.Model;

public class Annonce_Recherche {
    
    public String recherche_text;
    public String recherche_code_postal;
    public int recherche_date_apres;
    public int recherche_date_avant;
    public boolean recherche_materiel;
    public boolean recherche_service;
    public int recherche_florin_min;
    public int recherche_florin_max;
    public int recherche_note_min;

    public Annonce_Recherche() {
        setDefault();
    }

    public void setDefault() {
        this.recherche_text = "";
        this.recherche_code_postal = "";
        this.recherche_date_apres = 0;
        this.recherche_date_avant = 0;
        this.recherche_materiel = true;
        this.recherche_service = true;
        this.recherche_florin_min = -1;
        this.recherche_florin_max = -1;
        this.recherche_note_min = -1;
    }

}
