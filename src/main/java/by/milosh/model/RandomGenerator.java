package by.milosh.model;

import java.util.Random;

public class RandomGenerator {

    public static int getRandomValue(int maxValue) {
        return new Random().nextInt(maxValue) + 1;
    }
}
