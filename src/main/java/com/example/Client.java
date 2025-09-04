package com.example;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Client {
    private int id;
    private String nom;
    private String prenom;
    private String telephone;
    private String email;
    private List<Commande> commandes = new ArrayList<>();

    public Client(int id, String nom, String prenom, String telephone, String email) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.email = email;
    }

    public void ajouterCommande(Commande commande) {
        commandes.add(commande);
    }

    public List<Commande> getCommandesEntre(Instant debut, Instant fin) {
        Instant now = Instant.now();
        Instant borneInferieure = (debut != null) ? debut : Instant.EPOCH;
        Instant borneSuperieure = (fin != null) ? fin : now;

        return commandes.stream()
                .filter(c -> !c.getDateDeCreation().isBefore(borneInferieure)
                        && !c.getDateDeCreation().isAfter(borneSuperieure))
                .collect(Collectors.toList());
    }
}
 
}
