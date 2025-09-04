package com.example;

import java.time.Instant;

public class HistoriquePrix {
    private final Instant dateChangement;
    private final double prix;
    private final String raison;

    public HistoriquePrix(Instant dateChangement, double prix, String raison) {
        this.dateChangement = dateChangement;
        this.prix = prix;
        this.raison = raison;
    }

    public Instant getDateChangement() {
        return dateChangement;
    }

    public double getPrix() {
        return prix;
    }

    public String getRaison() {
        return raison;
    }
}
