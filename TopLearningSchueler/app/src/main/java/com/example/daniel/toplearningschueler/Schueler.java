package com.example.daniel.toplearningschueler;

/**
 * Created by Administrator on 20.12.2016.
 */

public class Schueler {
    private String GBDatum;
    private String Vorname;
    private String Nachname;
    private boolean Gender;
    private String Adresse;
    private int PLZ;
    private String Ort;
    private String Email;
    private int Telefon;
    private String Schultyp;
    private int Schulstufe;
    private String Passwort;



    public Schueler(String gbdatum,String vorname, String nachname, boolean gender, String adresse, int plz, String ort, String email, int telefon, String schultyp, int schulstufe, String passwort)
    {
        GBDatum = gbdatum;
        Vorname = vorname;
        Nachname = nachname;
        Gender = gender;
        Adresse = adresse;
        PLZ = plz;
        Ort = ort;
        Email = email;
        Telefon = telefon;
        Schultyp = schultyp;
        Schulstufe = schulstufe;
        Passwort = passwort;


    }

    public String getVorname() {
        return Vorname;
    }

    public void setVorname(String vorname) {
        Vorname = vorname;
    }

    public String getGBDatum() {
        return GBDatum;
    }

    public void setGBDatum(String GBDatum) {
        this.GBDatum = GBDatum;
    }

    public String getNachname() {
        return Nachname;
    }

    public void setNachname(String nachname) {
        Nachname = nachname;
    }

    public boolean isGender() {
        return Gender;
    }

    public void setGender(boolean gender) {
        Gender = gender;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public String getOrt() {
        return Ort;
    }

    public void setOrt(String ort) {
        Ort = ort;
    }

    public int getPLZ() {
        return PLZ;
    }

    public void setPLZ(int PLZ) {
        this.PLZ = PLZ;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getTelefon() {
        return Telefon;
    }

    public void setTelefon(int telefon) {
        Telefon = telefon;
    }

    public String getSchultyp() {
        return Schultyp;
    }

    public void setSchultyp(String schultyp) {
        Schultyp = schultyp;
    }

    public int getSchulstufe() {
        return Schulstufe;
    }

    public void setSchulstufe(int schulstufe) {
        Schulstufe = schulstufe;
    }

    public String getPasswort() {
        return Passwort;
    }

    public void setPasswort(String passwort) {
        Passwort = passwort;
    }
}
