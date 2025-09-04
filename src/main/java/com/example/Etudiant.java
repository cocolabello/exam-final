package com.example;

public class Etudiant {
    private int id;
    private String nom;
    private String prenom;
    private Instant dateEntree;
    private Groupe groupe; // etudiant peut changer de groupe a tout moment

    public Etudiant(int id, String nom, String prenom, Instant dateEntree, Groupe groupe) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateEntree = dateEntree;
        this.groupe = groupe;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }
}
