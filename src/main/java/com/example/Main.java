package com.example;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        Plat pizza = new Plat(1, "Pizza Margherita");
        pizza.ajouterPrix(5000, Instant.parse("2024-01-01T00:00:00Z"), "Prix initial");
        pizza.ajouterPrix(8000, Instant.parse("2024-06-01T00:00:00Z"), "Hausse inflation");

        Plat burger = new Plat(2, "Burger");
        burger.ajouterPrix(7000, Instant.parse("2024-01-01T00:00:00Z"), "Prix initial");
        burger.ajouterPrix(10000, Instant.parse("2025-01-01T00:00:00Z"), "Nouveaux ingrédients");

        Commande commande1 = new Commande(1, Instant.parse("2024-03-01T00:00:00Z"));
        commande1.ajouterPlat(pizza);
        commande1.ajouterPlat(burger);

        CommandeEnLigne commande2 = new CommandeEnLigne(2,
                Instant.parse("2025-02-01T00:00:00Z"),
                CommandeEnLigne.MoyenPaiement.CARTE,
                "Lot II Antananarivo");
        commande2.ajouterPlat(pizza);

        Client client = new Client(1, "Rakoto", "Jean", "0341234567", "rakoto@example.com");
        client.ajouterCommande(commande1);
        client.ajouterCommande(commande2);

        System.out.println("Prix commande1 = " + commande1.getPrixTotal()); // 5000 + 7000
        System.out.println("Prix commande2 = " + commande2.getPrixTotal()); // 8000

        System.out.println("Commandes en 2024 : " +
                client.getCommandesEntre(Instant.parse("2024-01-01T00:00:00Z"),
                        Instant.parse("2024-12-31T23:59:59Z")).size());
    }
}

