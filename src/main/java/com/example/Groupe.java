package com.example;

public class Groupe {
    private int id;
    private String nom; // list etudiants ? pas necessaire ici
    private List<Etudiant> etudiants;

    public Groupe(int id, String nom) {
        this.id = id;
        this.nom = nom;
        this.etudiants = new ArrayList<>();
    }
    public int getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "Groupe{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }


}
