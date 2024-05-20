package cat.insvidreres.inf.ex2;

import java.util.Random;
import java.util.Scanner;

public class Ex2 {

    public static void main(String[] args) {
        //Pregnant
        //Flow is Going to hospital -> Waiting for turn -> Exiting

        //Jubilee
        //Flow is Going to hospital -> Waiting for turn -> Exiting -> Going in again -> Exiting

        Monitor monitor = new Monitor();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Quantes dones embarassades hi han? ");
        int numDonesEmbarassades = scanner.nextInt();
        System.out.print("Quants jubilats hi han? ");
        int numJubilats = scanner.nextInt();

        Random random = new Random();

        for (int i = 1; i <= numDonesEmbarassades; i++) {
            int waitTime = random.nextInt(15) + 1;
            Embarassada donaEmbarassada = new Embarassada(monitor, i, waitTime);
            Thread threadDonaEmbarassada = new Thread(donaEmbarassada);
            threadDonaEmbarassada.start();
        }

        for (int i = 1; i <= numJubilats; i++) {
            int waitTime = random.nextInt(15) + 1;
            Jubilat jubilat = new Jubilat(monitor, i, waitTime);
            Thread threadJubilat = new Thread(jubilat);
            threadJubilat.start();
        }
    }

}
