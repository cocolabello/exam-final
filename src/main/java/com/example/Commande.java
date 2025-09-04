package com.example;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Commande {
    protected int id;
    protected Instant dateDeCreation;
    protected List<Plat> plats = new ArrayList<>();

    public Commande(int id, Instant dateDeCreation) {
        this.id = id;
        this.dateDeCreation = dateDeCreation;
    }

    public void ajouterPlat(Plat plat) {
        plats.add(plat);
    }

    public double getPrixTotal() {
        return plats.stream()
                .mapToDouble(p -> p.getPrixAInstant(dateDeCreation))
                .sum();
    }

    public Instant getDateDeCreation() {
        return dateDeCreation;
    }

    public int getId() {
        return id;
    }
}
