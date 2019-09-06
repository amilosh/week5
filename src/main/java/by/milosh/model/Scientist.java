package by.milosh.model;

import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

public class Scientist {

    private String name;
    private EnumMap<Part, Integer> store;

    public Scientist(String name) {
        this.name = name;
        this.store = new EnumMap<>(Part.class);
        for (Part part : Part.values()) {
            store.put(part, 0);
        }
    }

    public class Helper implements Runnable {

        private Dump dump;

        public Helper(Dump dump) {
            this.dump = dump;
        }

        @Override
        public void run() {
            for (int i = 1; i < ValuesHandler.getNightAmount() + 1; i++) {
                synchronized (dump) {
                    try {
                        dump.wait();
                        System.out.println(" - " + Thread.currentThread().getName() + " starts work" + "    night number: " + i);
                        if (dump.isEmpty()) {
                            System.out.println("there are no parts in the dump - " + Thread.currentThread().getName() + " returns without anything");
                        } else {
                            int partsAmount = RandomGenerator.getRandomValue(4);
                            for (int j = 1; j < partsAmount + 1; j++) {
                                Part part = dump.getOnePart();
                                if (part != null) {
                                    addPartToStore(part);
                                    System.out.println(Thread.currentThread().getName() + " gets part: " + part);
                                }
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public String getName() {
        return name;
    }

    public void addPartToStore(Part part) {
        Integer count = store.get(part);
        store.put(part, count + 1);
    }

    public Integer createdRobotsAmount() {
        Set<Map.Entry<Part, Integer>> setParts = store.entrySet();
        Map.Entry min = setParts.stream().min(Map.Entry.comparingByValue()).get();
        return (Integer) min.getValue();
    }
}
