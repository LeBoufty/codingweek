package eu.telecomnancy.Model;

import java.sql.Date;

public class Sommeils {
    
    private int id;
    private String datedebut;
    private String datefin;

    public Sommeils(int id, String datedebut, String datefin) {
        this.id = id;
        this.datedebut = datedebut;
        this.datefin = datefin;
    }

    public Sommeils(int id, Date dated, Date datef){
        
    }

    public int getId() {
        return id;
    }

    public String getDatedebut() {
        return datedebut;
    }

    public String getDatefin() {
        return datefin;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDatedebut(String datedebut) {
        this.datedebut = datedebut;
    }

    public void setDatefin(String datefin) {
        this.datefin = datefin;
    }
}
