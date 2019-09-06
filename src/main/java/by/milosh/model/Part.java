package by.milosh.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Part {

    HEAD,
    BODY,
    LEFT_HAND,
    RIGHT_HAND,
    LEFT_LEG,
    RIGHT_LEG,
    CPU,
    RAM,
    HDD;

    private static final List<Part> PARTS = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = PARTS.size();
    private static final Random RANDOM = new Random();

    public static Part getRandomPart() {
        return PARTS.get(RANDOM.nextInt(SIZE));
    }
}
