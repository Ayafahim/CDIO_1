package com.company;


import gui_fields.GUI_Player;
import gui_main.GUI;

public class Main {

    public static void main(String[] args) {
        GUI gui = new GUI();

        // Spørger brugerne om deres navne og gemmer dem i spiller1 og spiller2 variablerne
        String spiller1 = gui.getUserString("Indtast et navn");
        String spiller2 = gui.getUserString("Indtast et navn");

        // Opretter to brugere til GUI
        GUI_Player gui_Player1 = new GUI_Player(spiller1);
        GUI_Player gui_Player2 = new GUI_Player(spiller2);

        // Tilføjer brugerne til brættet
        gui.addPlayer(gui_Player1);
        gui.addPlayer(gui_Player2);

        // Sætter brugernes deres point til 0
        gui_Player1.setBalance(0);
        gui_Player2.setBalance(0);

        gui.setDice(1,1);





    }
}
