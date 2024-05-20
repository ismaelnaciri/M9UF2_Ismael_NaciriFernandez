package cat.insvidreres.inf.ex3;

import java.util.concurrent.Semaphore;

public class Jubilat implements Runnable {

    private Semaphore semaphore;
    private int id;
    private int travelTime;

    public Jubilat(Semaphore semaphore, int id, int travelTime) {
        this.semaphore = semaphore;
        this.id = id;
        this.travelTime = travelTime;
    }

    @Override
    public void run() {
        try {
            //Arriving
            Thread.sleep(travelTime);
            System.out.println("Jubilat " + id + " anant a l'hospital... Temps d'arribada: " + travelTime + " segons.");

            if (semaphore.tryAcquire()) {
                System.out.println("Jubilat " + id + " agafant torn per entrar a urgències");

                //Inside urgències
                Thread.sleep(3000);

                semaphore.release();
                System.out.println("Jubilat " + id + " marxant per la porta de l'hospital...");

                //Goes again to hospital
                if (semaphore.tryAcquire()) {
                    System.out.println("Jubilat " + id + " agafant torn per entrar a urgències");

                    //Inside urgències
                    Thread.sleep(3000);

                    semaphore.release();
                    System.out.println("Jubilat " + id + " marxant per la porta de l'hospital...");
                }
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Error | " + e.getMessage());
        }
    }
}
