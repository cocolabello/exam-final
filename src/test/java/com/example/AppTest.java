package com.example;

import org.junit.jupiter.api.Test;
import java.time.Instant;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    void testExample() {
        Etudiant etudiant1 = new Etudiant(1, "Harenah", "Sarobidy", "2024-09-01T00:00:00Z", new HistoriqueGroupe());
        Etudiant etudiant2 = new Etudiant(2, "Allan", "Tafita", "2025-01-15T00:00:00Z", new HistoriqueGroupe());
        assertEquals("Harenah", etudiant1.getNom());
        assertEquals("Allan", etudiant2.getNom());

        Frais frais1 = new Frais(1, "Frais d'inscription", 80000, Instant.now().plusSeconds(2592000), StatutFrais.IN_PROGRESS, etudiant1);
        Frais frais2 = new Frais(2, "Ecolage", 288000, Instant.now().minusSeconds(864000), StatutFrais.LATE, etudiant1);
        Frais frais3 = new Frais(3, "Ecolage", 310000, Instant.now().plusSeconds(5184000), StatutFrais.IN_PROGRESS, etudiant2);

        Statistics stats = new Statistics();

        java.util.List<Frais> listeFrais = java.util.List.of(frais1, frais2, frais3);

        for (Frais frais : listeFrais) {
            System.out.println(frais);
            stats.ajouterFrais(frais);
        }
        assertEquals(3, listeFrais.size());
        assertEquals(288000, stats.getTotalMissingFees(listeFrais, Instant.now()));
        assertEquals(0, stats.getTotalPaidByStudent(etudiant1, listeFrais, Instant.now()));
        assertEquals(0, stats.getTotalPaidByStudent(etudiant2, listeFrais, Instant.now()));
        // vérifier les frais en retard
        assertEquals(288000, stats.getTotalLateFees(listeFrais, Instant.now()));
        assertEquals(1, stats.getLateFees(listeFrais, Instant.now()).size());
        assertTrue(stats.getLateFees(listeFrais, Instant.now()).contains(frais2));
    }

}



