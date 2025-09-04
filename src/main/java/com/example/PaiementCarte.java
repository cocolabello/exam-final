package com.example;

public class PaiementCarte extends Paiement {
    public PaiementCarte(int id, double montantPaye, Instant dateHeure, String numeroCarte, String typeCarte) {
        super(id, montantPaye, dateHeure);
        this.numeroCarte = numeroCarte;
        this.typeCarte = typeCarte;
    }

    private String numeroCarte;
    private String typeCarte;
    
}
