package eu.telecomnancy.Model;

import eu.telecomnancy.BDD_App.API;

public class Annonce {
    private String titre;
    private String description;
    private Integer prix;
    private String ImgSrc;
    private int id;
    private Utilisateur vendeur;
    private String categorie;
    private String date_depot;
    private String code_postal;
    private static int maxid = API.getInstance().getMaxOffreID();


    public Annonce(String titre, String description, Integer prix, String ImgSrc, Utilisateur vendeur, String categorie, String date_depot, String code_postal) {
        this.titre = titre;
        this.description = description;
        this.prix = prix;
        this.ImgSrc = ImgSrc;
        this.id = ++maxid;
        this.vendeur = vendeur;
        this.categorie = categorie;
        this.date_depot = date_depot;
    }

    public Annonce(){

    }

    public Annonce(int id) {
        String[] infos = API.getInstance().getOffreInfos(id);
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
            API.getInstance().addOffre(titre, description, prix, vendeur.getId(), categorie);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String getImgSrc() {
        return ImgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.ImgSrc = imgSrc;
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

    public void setDescription(String description) {
        this.description = description.trim();
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }
}
