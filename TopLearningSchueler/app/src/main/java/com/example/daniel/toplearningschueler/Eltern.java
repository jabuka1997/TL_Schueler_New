package com.example.daniel.toplearningschueler;

/**
 * Created by Administrator on 20.12.2016.
 */

public class Eltern {

    private String VornameErz;
    private String NachnameErz;
    private String AnredeErz;

    public String getVornameErz() {
        return VornameErz;
    }

    public String getNachnameErz() {
        return NachnameErz;
    }

    public String getAnredeErz() {
        return AnredeErz;
    }

    public Eltern(String vornameErz, String nachnameErz, String anredeErz){

        VornameErz = vornameErz;
        NachnameErz = nachnameErz;
        AnredeErz = anredeErz;


    }
}
