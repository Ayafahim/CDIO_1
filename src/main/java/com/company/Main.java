package com.company;


import gui_fields.GUI_Player;
import gui_main.GUI;


public class Main {
    public static GUI gui = new GUI();

    public static int player1Points = 0;
    public static int player2Points = 0;

    public static boolean isPlaying = false;

    // Spørger brugerne om deres navne og gemmer dem i spiller1 og spiller2 variablerne
    public static String spiller1 = gui.getUserString("Indtast et navn");
    public static String spiller2 = gui.getUserString("Indtast et navn");

    // Opretter to brugere til GUI
    public static GUI_Player gui_Player1 = new GUI_Player(spiller1, player1Points);
    public static GUI_Player gui_Player2 = new GUI_Player(spiller2, player2Points);

    private static Die dice = new Die();

    public static void main(String[] args) {

        // Tilføjer brugerne til brættet
        gui.addPlayer(gui_Player1);
        gui.addPlayer(gui_Player2);

        gui.setDice(1, 1);

        //input fra spillerne

        do {

            String knapString = gui.getUserSelection("Kast terning", "Terning");

            if (knapString == "Terning" && gui_Player1.getBalance() < 40) {
                dice.roleDice();
            } else if (knapString == "Terning" && gui_Player2.getBalance() < 40) {
                dice.roleDice();
            } else {
                dice.endGame();
            }


        } while (isPlaying);


    }


}
