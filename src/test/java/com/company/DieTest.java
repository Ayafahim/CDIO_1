package com.company;

import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

class DieTest {

    private static final int MIN = 1;
    private static final int MAX = 6;

    public static int diceValue1;
    public static int diceValue2;

    private static Random random = new Random();

    @RepeatedTest(1000)
    public void testMyCode() {
        diceValue1 = random.nextInt(MAX - MIN + 1) + MIN;
        diceValue2 = random.nextInt(MAX - MIN + 1) + MIN;

        System.out.printf("Dice1: %d and dice2: %d%n", diceValue1, diceValue2);
    }

}