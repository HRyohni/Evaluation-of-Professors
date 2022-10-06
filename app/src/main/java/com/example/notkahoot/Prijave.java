package com.example.notkahoot;

public class Prijave {
    private String ime,lozinka;

    public Prijave(String ime, String lozinka) {
        this.ime = ime;
        this.lozinka = lozinka;
    }


    public String getIme() {
        return ime;
    }

    public String getLozinka() {
        return lozinka;
    }
}
