package com.company;

import gui_fields.GUI_Player;

import java.util.Random;

import static com.company.Main.*;

public class Die {

    // Laver 2 konstanter 'MIN' og 'MAX' samt en 'turn' variabel, så man kan holde øje med hvis tur det er
    private static final int MIN = 1;
    private static final int MAX = 6;
    private static int turn = 0;

    private static Random random = new Random();

    // Variabeler til at gemme terningernes værdi
    public static int diceValue1;
    public static int diceValue2;


    // en metode der slår terningen, som bruger 'calculateDice' metoden til at gemme spillerens point
    public void roleDice() {

        if (turn == 0) {
            calculateDice(gui_Player1, player1Points);
        } else if (turn == 1) {
            calculateDice(gui_Player2, player2Points);
        }


    }

    // En metode der henter summen af terningerne
    private static int getSum(int dice1, int dice2) {
        return dice1 + dice2;
    }

    // En metode der slår terningerne og sætter spillerens point til summen af terningerne
    private static void calculateDice(GUI_Player player, int playerPoints) {
        diceValue1 = random.nextInt(MAX - MIN + 1) + MIN;
        diceValue2 = random.nextInt(MAX - MIN + 1) + MIN;

        gui.setDice(diceValue1, diceValue2);

        playerPoints = playerPoints + getSum(diceValue1, diceValue2);

        player.setBalance(playerPoints);
    }

}
