package com.example;

import org.junit.jupiter.api.Test;
import java.time.Instant;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    void testPrixAInstant() {
        Plat plat = new Plat(1, "Pizza");
        plat.ajouterPrix(5000, Instant.parse("2024-01-01T00:00:00Z"), "Initial");
        plat.ajouterPrix(10000, Instant.parse("2025-01-01T00:00:00Z"), "Augmentation");

        assertEquals(5000, plat.getPrixAInstant(Instant.parse("2024-06-01T00:00:00Z")));
        assertEquals(10000, plat.getPrixAInstant(Instant.parse("2025-06-01T00:00:00Z")));
    }
}

