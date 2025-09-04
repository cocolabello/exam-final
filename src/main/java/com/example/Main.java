package com.example;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List

public class Main {
    public static void main(String[] args) {
        Etudiant etudiant1 = new Etudiant(1, "Harenah", "Sarobidy", "2024-09-01T00:00:00Z", K3, new HistoriqueGroupe());
        Etudiant etudiant2 = new Etudiant(2, "Allan", "Tafita", "2025-01-15T00:00:00Z", K4, new HistoriqueGroupe());

        Frais frais1 = new Frais(1, "Frais d'inscription", 80000, Instant.now().plus(30, ChronoUnit.DAYS), StatutFrais.IN_PROGRESS, etudiant1);
        Frais frais2 = new Frais(2, "Ecolage", 288000, Instant.now().minus(10, ChronoUnit.DAYS), StatutFrais.LATE, etudiant1);
        Frais frais3 = new Frais(3, "Ecolage", 310000, Instant.now().plus(60, ChronoUnit.DAYS), StatutFrais.IN_PROGRESS, etudiant2);

        Statistics stats = new Statistics();

        List<Frais> listeFrais = List.of(frais1, frais2, frais3); 

        for (Frais frais : listeFrais) {
            System.out.println(frais);
        }

        System.out.println("Total des frais : " + stats.getTotalFees(listeFrais));
        System.out.println("Total des frais en retard : " + stats.getTotalLateFees(listeFrais, Instant.now()));
        System.out.println("Total des frais payés par l'étudiant 1 : " + stats.getTotalPaidByStudent(etudiant1, listeFrais, Instant.now()));
        System.out.println("Total des frais payés par l'étudiant 2 : " + stats.getTotalPaidByStudent(etudiant2, listeFrais, Instant.now()));
    }


}

