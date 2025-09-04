package com.example;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Plat {
    private int id;
    private String nom;
    private List<HistoriquePrix> historiquePrix = new ArrayList<>();

    public Plat(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public void ajouterPrix(double prix, Instant date, String raison) {
        historiquePrix.add(new HistoriquePrix(date, prix, raison));
    }

    public double getPrixAInstant(Instant instant) {
        return historiquePrix.stream()
                .filter(h -> !h.getDateChangement().isAfter(instant))
                .max(Comparator.comparing(HistoriquePrix::getDateChangement))
                .map(HistoriquePrix::getPrix)
                .orElseThrow(() -> new IllegalStateException("Aucun prix défini avant cette date"));
    }

    public String getNom() {
        return nom;
    }
}
