package eu.telecomnancy.Model;

import eu.telecomnancy.BDD_App.API;

public class Annonce {
    private String titre;
    private String description;
    private Integer prix;
    private byte[] photo;
    private int id;
    private Utilisateur vendeur;
    private String categorie;
    private String date_depot;
    private String code_postal;
    private static int maxid = API.getInstance().getMaxOffreID();


    public Annonce(String titre, String description, Integer prix, byte[] photo, Utilisateur vendeur, String categorie, String date_depot, String code_postal) {
        this.titre = titre;
        this.description = description;
        this.prix = prix;
        this.photo = photo.clone();
        this.id = ++maxid;
        this.vendeur = vendeur;
        this.categorie = categorie;
        this.date_depot = date_depot;
        this.code_postal = code_postal;
    }

    public Annonce(){

    }

    public Annonce(int id) {
        String[] infos = API.getInstance().getOffreInfos(id);
        this.id = id;
        this.titre = infos[0];
        this.vendeur = new Utilisateur(Integer.parseInt(infos[1]));
        this.prix = Integer.parseInt(infos[2]);
        this.categorie = infos[3];
        this.description = infos[4];
        this.date_depot = infos[5];
        this.code_postal = vendeur.getCode_postal();
    }

    public void save() {
        try {
            API.getInstance().updateOffre(id, titre, description, prix, categorie);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveAsNew() {
        try {
            API.getInstance().addOffre(titre, description, prix, vendeur.getId(), categorie, photo);
            this.id = API.getInstance().getMaxOffreID();
            maxid = id;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo.clone();
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre.trim();
    }

    public String getDescription() {
        return description;
    }

    public byte[] getPhotoBytes() {
        return photo;
    }

    public void setDescription(String description) {
        this.description = description.trim();
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie.trim();
    }

    public String getDate_depot() {
        return date_depot;
    }

    public void setDate_depot(String date_depot) {
        this.date_depot = date_depot.trim();
    }

    public Utilisateur getVendeur() {
        return vendeur;
    }

    public void setVendeur(Utilisateur vendeur) {
        this.vendeur = vendeur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        maxid = Math.max(maxid, id);
    }

    public String getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(String code_postal) {
        code_postal = code_postal.trim();
        this.code_postal = code_postal;
    }
}
