package com.example;

public class Imc {
    private double taille;
    private double poids;

    public Imc(double taille, double poids) {
        this.taille = taille;
        this.poids = poids;
    }

    public double calcul() {
        return poids / (taille * taille);
    }
}