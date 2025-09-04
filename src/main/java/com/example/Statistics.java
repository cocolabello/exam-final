package com.example;

import java.util.List;
import java.time.instant

public class Statistics {
    List<Frais> getLateFees(List<Frais> frais, Instant t) {
        // retourne la liste des frais en retard a l'instant donné
        return frais.stream()
                .filter(f -> f.getStatut() == StatutFrais.LATE)
                .toList();
    }

    double getTotalMissingFees(List<Frais> frais, Instant t) {
        // retourne le montant total des frais en retard
        return frais.stream()
                .filter(f -> f.getStatut() == StatutFrais.LATE)
                .mapToDouble(Frais::getMontantAPayer)
                .sum();
    }

    double getTotalPaidByStudent(Etudiant etudiant, List<Frais> frais, Instant t) {
        // calcule et retourne le montant total payé par un etudiant a un instant t.
        return frais.stream()
                .filter(f -> f.getEtudiant().equals(etudiant) && f.getStatut() == StatutFrais.PAID)
                .mapToDouble(Frais::getMontantAPayer)
                .sum();
    }
