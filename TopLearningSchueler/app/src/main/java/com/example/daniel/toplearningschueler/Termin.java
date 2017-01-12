package com.example.daniel.toplearningschueler;

/**
 * Created by Administrator on 22.11.2016.
 */

public class Termin {
    private String Datum;
    private String Uhrzeit;
    private String Fach;
    private Lehrer MeinLehrer;




    public Termin(String datum, String uhrzeit, String fach, Lehrer mylehrer)
    {
        Datum = datum;
        Uhrzeit = uhrzeit;
        Fach = fach;
        MeinLehrer = mylehrer;
    }
    public String getDatum() {
        return Datum;
    }

    public String getFach() {
        return Fach;
    }

    public String getMeinLehrer() { return MeinLehrer.Vorname + " " + MeinLehrer.Nachname; }

    public String getUhrzeit() {
        return Uhrzeit;
    }
}
