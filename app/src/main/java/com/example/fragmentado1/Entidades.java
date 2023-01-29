package com.example.fragmentado1;

public class Entidades {
    private String nom;
    private String info;

    public Entidades() {
    }

    public Entidades(String nom, String info) {
        this.nom = nom;
        this.info = info;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
