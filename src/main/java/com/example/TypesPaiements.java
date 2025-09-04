package com.example;

public class TypesPaiements {
    public enum MoyenPaiement {
        ESPECE,
        CARTE,
        CHEQUE
    }
    private int id;
    private MoyenPaiement moyenPaiement;
    private Instant dateHeure;
}
