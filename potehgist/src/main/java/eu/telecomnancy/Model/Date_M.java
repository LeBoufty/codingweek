package eu.telecomnancy.Model;

import java.time.LocalDate;

public class Date_M {
    
    public long date; // seconds since 1970-01-01 00:00:00 UTC

    public Date_M(long date) {
        this.date = date;
    }

    public long getDate() {
        return date;
    }

    public Date_M(int annee, int mois, int jour) {
        this.date = (java.time.LocalDate.of(annee, mois, jour).toEpochDay() * 24 * 60 * 60);
    }

    public Date_M(int annee, int mois, int jour, int heure, int minute) {
        this.date = (java.time.LocalDateTime.of(annee, mois, jour, heure, minute).toEpochSecond(java.time.ZoneOffset.UTC));
    }

    public Date_M(LocalDate date_FXML) {
        this.date = (java.time.LocalDate.of(date_FXML.getYear(), date_FXML.getMonthValue(), date_FXML.getDayOfMonth()).toEpochDay() * 24 * 60 * 60);
    }

    public Date_M(LocalDate date_FXML, int heure, int minute) {
        this.date = (java.time.LocalDateTime.of(date_FXML.getYear(), date_FXML.getMonthValue(), date_FXML.getDayOfMonth(), heure, minute).toEpochSecond(java.time.ZoneOffset.UTC));
    }

    public static Date_M now() {
        return new Date_M(java.time.Instant.now().getEpochSecond());
    }

    public static Date_M today() {
        return new Date_M(java.time.LocalDate.now().toEpochDay() * 24 * 60 * 60);
    }

    public static long getDate_FXML(LocalDate date_FXML) {
        return (java.time.LocalDate.of(date_FXML.getYear(), date_FXML.getMonthValue(), date_FXML.getDayOfMonth()).toEpochDay() * 24 * 60 * 60);
    }

    // Getters
    public int getAnnee() {
        return java.time.LocalDateTime.ofEpochSecond(date, 0, java.time.ZoneOffset.UTC).getYear();
    }

    public int getMois() {
        return java.time.LocalDateTime.ofEpochSecond(date, 0, java.time.ZoneOffset.UTC).getMonthValue();
    }

    public int getJour() {
        return java.time.LocalDateTime.ofEpochSecond(date, 0, java.time.ZoneOffset.UTC).getDayOfMonth();
    }

    public int getHeure() {
        return java.time.LocalDateTime.ofEpochSecond(date, 0, java.time.ZoneOffset.UTC).getHour();
    }

    public int getMinute() {
        return java.time.LocalDateTime.ofEpochSecond(date, 0, java.time.ZoneOffset.UTC).getMinute();
    }

    public int getSeconde() {
        return java.time.LocalDateTime.ofEpochSecond(date, 0, java.time.ZoneOffset.UTC).getSecond();
    }

    public String getAlldateAAAAMMJJ(){
        String res = "";
        res += getAnnee() + "-";
        res += getMois() + "-";
        res += getJour() + " ";
        return res;
    }

    public String getAlldateJJMMAAAA(){
        String res = "";
        res += getJour() + "-";     
        res += getMois() + "-";
        res += getAnnee() + " ";
        return res;
    }

    public String getAlldateAAAAMMJJHHMM(){
        String res = "";
        res += getAnnee() + "-";
        res += getMois() + "-";
        res += getJour() + " ";
        res += getHeure() + "h";
        res += getMinute();
        return res;
    }

    public String getAlldateHHMM(){
        String res = "";
        res += getHeure() + "h";
        res += getMinute();
        return res;
    }

    public static int getNbHours(Date_M date_debut, Date_M date_fin){
        // I made this function to pay the hours of a reservation even if it's not a full hour
        return (int)(Math.floor(((date_fin.date-1) - date_debut.date)/3600)+1);
    }

    public static int getNbHours(int date_debut, int date_fin){
        // I made this function to pay the hours of a reservation even if it's not a full hour
        return (int)(Math.floor(((date_fin-1) - date_debut)/3600)+1);
    }
}
