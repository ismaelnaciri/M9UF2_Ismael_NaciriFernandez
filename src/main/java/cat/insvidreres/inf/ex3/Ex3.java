package cat.insvidreres.inf.ex3;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Ex3 {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Quantes dones embarassades hi han? ");
        int numDonesEmbarassades = scanner.nextInt();
        System.out.print("Quants jubilats hi han? ");
        int numJubilats = scanner.nextInt();

        Random random = new Random();

        for (int i = 1; i <= numDonesEmbarassades; i++) {
            int waitTime = random.nextInt(15) + 1;
            Embarassada donaEmbarassada = new Embarassada(semaphore, i, waitTime);
            Thread threadDonaEmbarassada = new Thread(donaEmbarassada);
            threadDonaEmbarassada.start();
        }

        for (int i = 1; i <= numJubilats; i++) {
            int waitTime = random.nextInt(15) + 1;
            Jubilat jubilat = new Jubilat(semaphore, i, waitTime);
            Thread threadJubilat = new Thread(jubilat);
            threadJubilat.start();
        }
    }
}
