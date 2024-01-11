package eu.telecomnancy.Model;

import java.time.LocalDate;

public class Date {
    
    public long date; // seconds since 1970-01-01 00:00:00 UTC

    public Date(long date) {
        this.date = date;
    }

    public long getDate() {
        return date;
    }

    public Date(int annee, int mois, int jour) {
        this.date = (java.time.LocalDate.of(annee, mois, jour).toEpochDay() * 24 * 60 * 60);
    }

    public Date(int annee, int mois, int jour, int heure, int minute) {
        this.date = (java.time.LocalDateTime.of(annee, mois, jour, heure, minute).toEpochSecond(java.time.ZoneOffset.UTC));
    }

    public Date(LocalDate date_FXML) {
        this.date = (java.time.LocalDate.of(date_FXML.getYear(), date_FXML.getMonthValue(), date_FXML.getDayOfMonth()).toEpochDay() * 24 * 60 * 60);
    }

    public static Date now() {
        return new Date(java.time.Instant.now().getEpochSecond());
    }

    public static Date today() {
        return new Date(java.time.LocalDate.now().toEpochDay() * 24 * 60 * 60);
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


}
