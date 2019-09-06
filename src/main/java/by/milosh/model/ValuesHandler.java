package by.milosh.model;

public class ValuesHandler {

    private static int nightAmount;
    private static int timeBetweenNights;

    public static int getNightAmount() {
        return nightAmount;
    }

    public static void setNightAmount(int nightAmount) {
        ValuesHandler.nightAmount = nightAmount;
    }

    public static int getTimeBetweenNights() {
        return timeBetweenNights;
    }

    public static void setTimeBetweenNights(int timeBetweenNights) {
        ValuesHandler.timeBetweenNights = timeBetweenNights;
    }
}
