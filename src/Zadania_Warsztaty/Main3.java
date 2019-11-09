package Zadania_Warsztaty;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {

        int liczba = getInt();

        zgaduj();

    }

    private static void zgaduj() {
        int max = 1000;
        int min = 1;
        while(true) {
            for (int i = 0; i <= 10; i++) {
                int guess = ((max - min) / 2) + min;
                System.out.println("Zgaduje " + guess);

                String powiedz = getPodpowiedz();

                if (powiedz.equals("za duzo")) {
                    max = guess;
                } else if (powiedz.equals("za malo")) {
                    min = guess;
                } else {
                    System.out.println("Wygralem");
                    break;
                }
                if(i == 10){
                    System.out.println("koniec prob");
                    break;
                }
                if(min == max || min < max){
                    System.out.println("Oszukiwales");
                    return;
                }

            }
        }


    }

    private static String getPodpowiedz() {
        Scanner skan = new Scanner(System.in);
        while (true) {
            while (!skan.hasNextLine()) {
                System.out.println("wpisz za duzo, za malo lub zgadles");
                skan.next();
            }
            String wyraz = skan.nextLine();
            if (wyraz.equals("za duzo") || wyraz.equals("za malo") || wyraz.equals("zgadles")) {
                return wyraz;
            } else {
                System.out.println("zle");
                System.out.println("Nie oszukuj");
            }
        }
    }

    private static int getInt() {
        Scanner skan = new Scanner(System.in);
        System.out.println("Podaj liczbe od 1 do 1000");
        while (true) {
            while (!skan.hasNextInt()) {
                System.out.println("to nie liczba");
                System.out.println("Podaj od 1 do 1000");
                skan.next();
            }
            int num = skan.nextInt();
            if (num > 0 && num < 1001) {
                return num;
            } else {
                System.out.println("zle");
                System.out.println("Podaj od 1 do 1000");
            }
        }

    }

}
