package com.example;

import java.time.Instant;


public class Frais {
    private int id;
    private String label;
    private double montantAPayer;
    private Instant deadline;
    private StatutFrais statut;
    private Etudiant etudiant; // Association avec Etudiant

    public Frais(int id, String label, double montantAPayer, Instant deadline, StatutFrais statut, Etudiant etudiant) {
        this.id = id;
        this.label = label;
        this.montantAPayer = montantAPayer;
        this.deadline = deadline;
        this.statut = statut;
    }

    // Getters et setters
    public int getId() {
        return id;
    }
    public String getLabel() {
        return label;
    }
    public double getMontantAPayer() {
        return montantAPayer;
    }
    public Instant getDeadline() {
        return deadline;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public void setMontantAPayer(double montantAPayer) {
        this.montantAPayer = montantAPayer;
    }
    public void setDeadline(Instant deadline) {
        this.deadline = deadline;
    }

    public void setStatut(StatutFrais statut) {
        this.statut = statut;
    }
    public StatutFrais getStatut() {
        return statut;
    }
    public Etudiant getEtudiant() {
        return etudiant;
    }
    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public void retournerStatut() {
        if (Instant.now().isAfter(deadline) && statut == StatutFrais.IN_PROGRESS) {
            statut = StatutFrais.LATE;
        }
        if (montantAPayer <= 0) {
            statut = StatutFrais.PAID;
        }
        if (montantAPayer < 0) {
            statut = StatutFrais.OVERPAID;
        }
        if (montantAPayer > 0 && Instant.now().isBefore(deadline)) {
            statut = StatutFrais.IN_PROGRESS;
        }
    }

    



}
