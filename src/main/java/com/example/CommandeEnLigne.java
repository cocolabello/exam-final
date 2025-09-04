package com.example;

public class CommandeEnLigne extends Commande {

    public enum MoyenPaiement { CARTE, MOBILE_MONEY }

    private MoyenPaiement moyenPaiement;
    private String adresseDeLivraison;

    public CommandeEnLigne(int id, Instant dateDeCreation, MoyenPaiement moyenPaiement, String adresseDeLivraison) {
        super(id, dateDeCreation);
        this.moyenPaiement = moyenPaiement;
        this.adresseDeLivraison = adresseDeLivraison;
    }
}
