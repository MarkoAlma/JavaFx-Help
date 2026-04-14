package com.example.kigyokfx;

public class Kigyo {
    private String fajta;
    private Integer hossz;
    private String elofordulas;
    private String merges;

    public Kigyo(String[] tomb) {
        this.fajta = tomb[0];
        this.hossz = Integer.valueOf(tomb[1]);;
        this.elofordulas = tomb[2];
        this.merges = tomb[3];
    }

    public String getFajta() {
        return fajta;
    }

    public void setFajta(String fajta) {
        this.fajta = fajta;
    }

    public Integer getHossz() {
        return hossz;
    }

    public void setHossz(Integer hossz) {
        this.hossz = hossz;
    }

    public String getElofordulas() {
        return elofordulas;
    }

    public void setElofordulas(String elofordulas) {
        this.elofordulas = elofordulas;
    }

    public String getMerges() {
        return merges;
    }

    public void setMerges(String merges) {
        this.merges = merges;
    }
}
