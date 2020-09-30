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
    public static int ekstraTur;


    // en metode der slår terningen, som bruger 'calculateDice' metoden til at gemme spillerens point
    public void roleDice() {

        if (turn == 0) {
            turn = 1;
            if (gui_Player1.getBalance() > 40) {
                endGame();
            } else {
                gui.showMessage(gui_Player1.getName() + "'s tur");
                calculateDice(gui_Player1, gui_Player1.getBalance());
            }

        } else if (turn == 1) {
            turn = 0;
            if (gui_Player2.getBalance() > 40) {
                endGame();
            } else {
                gui.showMessage(gui_Player2.getName() + "'s tur");
                calculateDice(gui_Player2, gui_Player2.getBalance());
            }

        }


    }

    // En metode der henter summen af terningerne
    private static int getSum(int dice1, int dice2) {
        return dice1 + dice2;
    }

    // En metode der slår terningerne og sætter spillerens point til summen af terningerne samt regler for kast
    private static void calculateDice(GUI_Player player, int playerBalance) {
//        diceValue1 = random.nextInt(MAX - MIN + 1) + MIN;
//        diceValue2 = random.nextInt(MAX - MIN + 1) + MIN;
        diceValue1 = 6;
        diceValue2 = 6;


        if (diceValue1 == 1 && diceValue2 == 1) {
            gui.setDice(diceValue1, diceValue2);
            player.setBalance(0);
        } else if (diceValue1 == 6 && diceValue2 == 6) {

            gui.setDice(diceValue1, diceValue2);
            playerBalance = playerBalance + getSum(diceValue1, diceValue2);
            player.setBalance(playerBalance);

            ekstraTur = ekstraTur + diceValue1 + diceValue2;

            if (turn == 1) {
                turn = 0;
            } else {
                turn = 1;
            }

            if (ekstraTur == 24) {
                if (turn == 0) {
                    gui.showMessage(gui_Player1.getName() + " har vundet!");
                } else {
                    gui.showMessage(gui_Player2.getName() + " har vundet!");
                }
                isPlaying = false;
            }

        } else if (diceValue1 == diceValue2 || diceValue1 == 6 && diceValue2 == 6) {
            gui.setDice(diceValue1, diceValue2);

            playerBalance = playerBalance + getSum(diceValue1, diceValue2);

            player.setBalance(playerBalance);

            if (turn == 1) {
                turn = 0;
            } else {
                turn = 1;
            }

        } else {
            gui.setDice(diceValue1, diceValue2);

            playerBalance = playerBalance + getSum(diceValue1, diceValue2);

            player.setBalance(playerBalance);

            ekstraTur = 0;
        }


    }

    public static void endGame() {
//        diceValue1 = random.nextInt(MAX - MIN + 1) + MIN;
//        diceValue2 = random.nextInt(MAX - MIN + 1) + MIN;
        diceValue1 = 6;
        diceValue2 = 6;

        gui.setDice(diceValue1, diceValue2);


        if (turn == 0) {
            turn = 1;
            gui.showMessage(gui_Player1.getName() + "'s tur");
            if (diceValue1 == diceValue2) {
                gui.showMessage(gui_Player1.getName() + " har vundet");
                isPlaying = false;
            }
        } else if (turn == 1) {
            turn = 0;
            gui.showMessage(gui_Player2.getName() + "'s tur");
            if (diceValue1 == diceValue2) {
                gui.showMessage(gui_Player2.getName() + " har vundet");
                isPlaying = false;
            }
        }

    }

}
