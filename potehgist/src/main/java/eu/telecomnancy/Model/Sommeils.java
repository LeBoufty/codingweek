package eu.telecomnancy.Model;

public class Sommeils {
    
    private int id;
    private int datedebut;
    private int datefin;

    public Sommeils(int id, int datedebut, int datefin) {
        this.id = id;
        this.datedebut = datedebut;
        this.datefin = datefin;
    }

    public int getId() {
        return id;
    }

    public int getDatedebut() {
        return datedebut;
    }

    public int getDatefin() {
        return datefin;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDatedebut(int datedebut) {
        this.datedebut = datedebut;
    }

    public void setDatefin(int datefin) {
        this.datefin = datefin;
    }

    public String getDateString(int date) {
        Date_M date_m = new Date_M(date);
        return date_m.getAlldateAAAAMMJJ();
    }

    public String getDateDebutString() {
        return getDateString(datedebut);
    }

    public String getDateFinString() {
        return getDateString(datefin);
    }
}
