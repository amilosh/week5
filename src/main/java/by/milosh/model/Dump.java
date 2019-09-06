package by.milosh.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dump {

    private static final int FIRST_DAY_PARTS_NUMBER = 20;
    private List<Part> parts;

    public Dump() {
        parts = new ArrayList<>();
        for (int i = 0; i < FIRST_DAY_PARTS_NUMBER; i++) {
            parts.add(Part.getRandomPart());
        }
    }

    public Part addOneRandomPart() {
        Part part = Part.getRandomPart();
        parts.add(part);
        return part;
    }

    public Part getOnePart() {
        if (isEmpty()) {
            return null;
        } else {
            int index = new Random().nextInt(parts.size());
            return parts.remove(index);
        }
    }

    public boolean isEmpty() {
        return parts.isEmpty();
    }
}
