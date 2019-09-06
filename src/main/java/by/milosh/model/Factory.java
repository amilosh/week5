package by.milosh.model;

public class Factory implements Runnable {

    private static final int MAX_VALUE_PERTS = 4;

    private Dump dump;

    public Factory(Dump dump) {
        this.dump = dump;
    }

    @Override
    public void run() {
        for (int i = 1; i < ValuesHandler.getNightAmount() + 1; i++) {
            synchronized (dump) {
                try {
                    dump.wait();
                    System.out.println(" - " + Thread.currentThread().getName() + " starts work" + "    night number: " + i);
                    int partsAmount = RandomGenerator.getRandomValue(MAX_VALUE_PERTS);
                    for (int j = 1; j < partsAmount + 1; j++) {
                        Part part = dump.addOneRandomPart();
                        System.out.println(Thread.currentThread().getName() + " create part: " + part);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
