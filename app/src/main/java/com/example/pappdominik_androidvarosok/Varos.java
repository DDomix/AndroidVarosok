package com.example.pappdominik_androidvarosok;

public class Varos {
    private String nev;
    private String orszag;
    private String lakossag;

    public Varos(String nev, String orszag, String lakossag) {
        this.nev = nev;
        this.orszag = orszag;
        this.lakossag = lakossag;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getOrszag() {
        return orszag;
    }

    public void setOrszag(String orszag) {
        this.orszag = orszag;
    }

    public String getLakossag() {
        return lakossag;
    }

    public void setLakossag(String lakossag) {
        this.lakossag = lakossag;
    }
}
