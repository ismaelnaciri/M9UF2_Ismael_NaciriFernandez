package cat.insvidreres.inf;

import cat.insvidreres.inf.Ex1.Ex1;
import cat.insvidreres.inf.ex2.Ex2;
import cat.insvidreres.inf.ex3.Ex3;

import java.io.IOException;
import java.util.Scanner;

public class Controlador {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcioEscollida;

        do {
            System.out.println("---------------MENU ISMAEL NACIRI FERNANDEZ--------------------");
            System.out.println("1.- Núm. Guàrdies Residents");
            System.out.println("2.- Urgències amb Monitor");
            System.out.println("3.- Urgències amb Semàfor");
            System.out.println("4.- Sortir de l'aplicació");
            System.out.print("Opció: ");
            opcioEscollida = sc.nextInt();

            switch (opcioEscollida) {
                case 1:
                    Ex1.main(null);
                    break;
                case 2:
                    Ex2.main(null);
                    break;
                case 3:
                    Ex3.main(null);
                    break;
                case 4:
                    System.out.println("Sortint de l'aplicació...");
                    System.exit(300);
                    break;
                default:
                    System.out.println("Opció no vàlida, si us plau escull una altra.");
            }

        } while (opcioEscollida != 4);

        sc.close();
    }
}