package cat.insvidreres.inf.Ex1;

import java.util.Random;

public class Ex1 implements Runnable {

    private int numResident;
    private Random random;
    private int result;
    private static int[] results = new int[3];

    public Ex1(int numResident) {
        this.numResident = numResident;
        this.random = new Random();
    }

    @Override
    public void run() {
        result = random.nextInt(6) + 1;
        results[numResident] = result;
    }

    public static void main(String[] args) {

        try {
            Ex1[] residents = new Ex1[3];
            Thread[] threads = new Thread[residents.length];

            for (int i = 0; i < 3; i++) {
                residents[i] = new Ex1(i);
                threads[i] = new Thread(residents[i]);
                threads[i].start();
            }

            for (int i = 0; i < 3; i++) {
                threads[i].join();
                System.out.println("Resident " + (i + 1) + ": Llançament = " + results[i]);
            }

            double average = 0.0;
            for (int i = 0; i < results.length; i++) {
                average += results[i];
            }
            average = average / results.length;

            int numGuardies = (int) Math.round(average);

            System.out.printf("Mitjana de les tirades: %.2f", average);
            System.out.println("\nNúmero de guàrdies: " + numGuardies);


        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Error | " + e.getMessage());
        }
    }
}
