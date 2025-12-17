package org.example.controllers;

import org.example.match.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EffectControllerTest {

    private final EffectController effectController = EffectController.getInstance();

    @Test
    void givenNegativeAmount_whenDraw_thenDrawsZeroCards() {
        Player player = new Player("Test");

        effectController.draw(player, -1);

        assertEquals(0, player.getHand().size());
    }

    @Test
    void givenZeroAmount_whenDraw_thenDrawsNoCards() {
        Player player = new Player("Test");

        effectController.draw(player, 0);

        assertEquals(0, player.getHand().size());
    }

    @Test
    void givenPositiveAmount_whenDraw_thenDrawsExactAmount() {
        Player player = new Player("Test");

        effectController.draw(player, 2);

        assertEquals(2, player.getHand().size());
    }
}