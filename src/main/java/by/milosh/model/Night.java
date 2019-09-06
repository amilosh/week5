package by.milosh.model;

public class Night implements Runnable {

    private Dump dump;

    public Night(Dump dump) {
        this.dump = dump;
    }

    @Override
    public void run() {
        for (int i = 1; i < ValuesHandler.getNightAmount() + 1; i++) {
            try {
                Thread.sleep(ValuesHandler.getTimeBetweenNights());
                synchronized (dump) {
                    dump.notifyAll();
                    System.out.println();
                    System.out.println("---- night number: " + i + " ----");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
