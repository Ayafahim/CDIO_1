package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner PlayerName = new Scanner(System.in);
        Scanner play = new Scanner(System.in);
        String playername1, playername2;

        System.out.print("Player 1's name: ");
        playername1 = PlayerName.nextLine();
        System.out.print("Player 2's name: ");
        playername2 = PlayerName.nextLine();

        Players player1 = new Players(playername1,0);
        Players player2 = new Players(playername2,0);

        System.out.println("Hej " + playername1 + " du har " + player1.points + " point");
        System.out.println("Hej " + playername2 + " du har " + player2.points + " point");

        play.next();

        Die die1 = new Die(1);
        Die die2 = new Die(1);

        die1.rollDice();
        die2.rollDice();



        System.out.println(playername1 + " rolled " + die1 + " & " + die2 + ". Sum of points added: " );




















    }
}
