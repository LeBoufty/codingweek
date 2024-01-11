package eu.telecomnancy.Model;

public class Annonce_en_creation {
    
    public String titre;
    public String description;
    public Integer prix;
    public byte[] photo;
    public String categorie;
    public long date_debut_materiel;
    public long date_fin_materiel;
    

    public Annonce_en_creation(String titre, String description, Integer prix, byte[] photo, String categorie) {
        this.titre = titre;
        this.description = description;
        this.prix = prix;
        this.photo = photo.clone();
        this.categorie = categorie;
    }
    

}
