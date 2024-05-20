package cat.insvidreres.inf.ex2;

public class Embarassada implements Runnable {

    private Monitor monitor;
    private int id;
    private int travelTime;

    public Embarassada(Monitor monitor, int id, int travelTime) {
        this.monitor = monitor;
        this.id = id;
        this.travelTime = travelTime;
    }

    @Override
    public void run() {
        try {
            //Arriving
            Thread.sleep(travelTime);

            System.out.println("Dona embarassada " + id + " anant a l'hospital... Temps d'arribada: " + travelTime + " segons.");

            monitor.openReading();
            System.out.println("Dona embarassada " + id + " agafant torn per entrar a urgències");

            //Inside urgències
            Thread.sleep(3000);

            monitor.closeReading();
            System.out.println("Dona embarassada " + id + " marxant amb el nadó...");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Error | " + e.getMessage());
        }
    }
}
