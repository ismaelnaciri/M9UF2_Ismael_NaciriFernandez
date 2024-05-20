package cat.insvidreres.inf.ex2;

public class Jubilat implements Runnable {

    private Monitor monitor;
    private int id;
    private int travelTime;

    public Jubilat(Monitor monitor, int id, int travelTime) {
        this.monitor = monitor;
        this.id = id;
        this.travelTime = travelTime;
    }

    @Override
    public void run() {
        try {
            //Arriving
            Thread.sleep(travelTime);

            System.out.println("Jubilat " + id + " anant a l'hospital... Temps d'arribada: " + travelTime + " segons.");

            monitor.openWriting();
            System.out.println("Jubilat " + id + " agafant torn per entrar a urgències");

            //Inside urgències
            Thread.sleep(3000);

            monitor.closeWriting();
            System.out.println("Jubilat " + id + " surtint d'urgències.");

            monitor.openWriting();
            System.out.println("Jubilat " + id + " agafant torn per entrar a urgències");

            //Inside urgències
            Thread.sleep(3000);

            System.out.println("Jubilat " + id + " surtint d'urgències.");
            monitor.closeWriting();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Error | " + e.getMessage());
        }
    }
}
