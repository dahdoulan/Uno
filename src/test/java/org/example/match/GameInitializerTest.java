package org.example.match;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameInitializerTest {

    private final GameInitializer initializer = new GameInitializer();

    @Test
    void givenNumberBelowMinimum_whenIsValidNumOfPlayers_thenReturnsFalse() {
        assertFalse(initializer.isValidNumOfPlayers(0));
        assertFalse(initializer.isValidNumOfPlayers(1));
        assertFalse(initializer.isValidNumOfPlayers(-1));
    }

    @Test
    void givenNumberAtMinimumBoundary_whenIsValidNumOfPlayers_thenReturnsTrue() {
        assertTrue(initializer.isValidNumOfPlayers(2));
    }

    @Test
    void givenNumberWithinValidRange_whenIsValidNumOfPlayers_thenReturnsTrue() {
        assertTrue(initializer.isValidNumOfPlayers(3));
        assertTrue(initializer.isValidNumOfPlayers(5));
        assertTrue(initializer.isValidNumOfPlayers(7));
    }

    @Test
    void givenNumberAtMaximumBoundary_whenIsValidNumOfPlayers_thenReturnsTrue() {
        assertTrue(initializer.isValidNumOfPlayers(8));
    }

    @Test
    void givenNumberAboveMaximum_whenIsValidNumOfPlayers_thenReturnsFalse() {
        assertFalse(initializer.isValidNumOfPlayers(9));
        assertFalse(initializer.isValidNumOfPlayers(10));
        assertFalse(initializer.isValidNumOfPlayers(100));
    }
}