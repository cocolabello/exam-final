package com.example;

public class Paiement {
    private int id;
    private double montantPaye;
    private Instant dateHeure;

    public Paiement(int id, double montantPaye, Instant dateHeure) {
        this.id = id;
        this.montantPaye = montantPaye;
        this.dateHeure = dateHeure;
    }

    // Getters et setters
    public int getId() {
        return id;
    }

    public double getMontantPaye() {
        return montantPaye;
    }

    public Instant getDateHeure() {
        return dateHeure;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMontantPaye(double montantPaye) {
        this.montantPaye = montantPaye;
    }

    public void setDateHeure(Instant dateHeure) {
        this.dateHeure = dateHeure;
    }
}
