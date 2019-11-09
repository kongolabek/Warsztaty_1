package Zadania_Warsztaty;

import java.util.Random;
import java.util.Scanner;

public class Main1 {



    public static void main(String[] args) {

        Random r = new Random();
        int a = r.nextInt(100);

        int zgadnij = getInt();
        Scanner skan = new Scanner(System.in);

    while(true) {
        if (a > zgadnij) {
            System.out.println("Za malo!");
            zgadnij = getInt();
        }
        else if (a < zgadnij) {
            System.out.println("Za duzo!");
            zgadnij = getInt();
        }

        else{
            System.out.println("Zgadles!!");
            break;
        }
    }



    }

    private static int getInt() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Zgadnij liczbe");

        while (!scanner.hasNextInt()) {
            String tmp = scanner.nextLine();
            System.out.println("To nie jest poprawna liczba: " + tmp);
        }

        return scanner.nextInt();
    }

}
