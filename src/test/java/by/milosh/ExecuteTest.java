package by.milosh;

import by.milosh.model.Dump;
import by.milosh.model.Factory;
import by.milosh.model.Night;
import by.milosh.model.Scientist;
import by.milosh.model.ValuesHandler;
import org.junit.Test;

public class ExecuteTest {

    private final static int NIGHT_AMOUNT = 100;
    private final static int TIME_BETWEEN_NIGHTS = 100;

    @Test
    public void execute() {

        ValuesHandler.setNightAmount(NIGHT_AMOUNT);
        ValuesHandler.setTimeBetweenNights(TIME_BETWEEN_NIGHTS);

        Dump dump = new Dump();

        Scientist scientist1 = new Scientist("Scientist 1");
        Scientist scientist2 = new Scientist("Scientist 2");

        Scientist.Helper helper1 = scientist1.new Helper(dump);
        Scientist.Helper helper2 = scientist2.new Helper(dump);
        Thread thread1 = new Thread(helper1, "Helper 1");
        Thread thread2 = new Thread(helper2, "Helper 2");

        Factory factory = new Factory(dump);
        Thread thread3 = new Thread(factory, "Factory");

        Night night = new Night(dump);
        Thread threadNight = new Thread(night, "Night");

        thread1.start();
        thread2.start();
        thread3.start();
        threadNight.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            threadNight.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Integer robotAmountOfScientist1 = scientist1.createdRobotsAmount();
        Integer robotAmountOfScientist2 = scientist2.createdRobotsAmount();

        System.out.println();
        System.out.println(scientist1.getName() + " can makes: " + robotAmountOfScientist1 + " robots");
        System.out.println(scientist1.getName() + " can makes: " + robotAmountOfScientist2 + " robots");
    }
}
