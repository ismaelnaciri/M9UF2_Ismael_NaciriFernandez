package cat.insvidreres.inf.ex3;

import java.util.concurrent.Semaphore;

public class Embarassada implements Runnable {

    private Semaphore semaphore;
    private int id;
    private int travelTime;

    public Embarassada(Semaphore semaphore, int id, int travelTime) {
        this.semaphore = semaphore;
        this.id = id;
        this.travelTime = travelTime;
    }

    @Override
    public void run() {
        try {
            //Arriving
            Thread.sleep(travelTime);
            System.out.println("Dona embarassada " + id + " anant al hospital... Temps d'arribada: " + travelTime + " segons");

            if (travelTime >= 8) {
                //Too much travel time
                System.out.println("Dona embarassada " + id + " ha donat a llum abans d'entrar a la sala d'urgències");
            } else {
                if (semaphore.tryAcquire()) {
                    System.out.println("Dona embarassada " + id + " agafant torn per entrar a urgències");

                    semaphore.release();
                    System.out.println("Dona embarassada " + id + " marxant amb el nadó...");
                } else {
                    //Temps d'espera?
                    Thread.sleep(1000);
                }
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Error | " + e.getMessage());
        }
    }
}
