package Zadania_Warsztaty;

import java.util.Random;
import java.util.Scanner;

public class main4 {

    public static void main(String[] args) {

        System.out.println(jakiRzut());

    }

    private static int jakiRzut() {
        Scanner skan = new Scanner(System.in);
        int wynik = 0;

        String rzut = skan.nextLine();
        while(!matches(rzut)){
            rzut = skan.nextLine();
        }
        String [] tab = rzut.split("[D\\-\\+]");

//        for(String a : tab){
//            System.out.println(a+" ");
//        }

        if(tab.length == 3){
            wynik = Integer.parseInt(tab[0])*typyKostek(tab[1])+Integer.parseInt(tab[2]);
        }
        else if(rzut.contains("+") || rzut.contains("-") && tab.length == 2){
            if(rzut.contains("+")){
                wynik = typyKostek(tab[0])+Integer.parseInt(tab[1]);
            }else{
                wynik = typyKostek(tab[0])-Integer.parseInt(tab[1]);
            }

        }else if(tab.length == 2){
            wynik = Integer.parseInt(tab[0])*typyKostek(tab[1]);

        }else{
            wynik = typyKostek(tab[0]);
        }

        return wynik;
    }

    static boolean matches(String qube){
        return qube.matches("\\d*D\\d+[+,\\-]?\\d*");
    }

    private static int typyKostek(String typ) {
        if(typ.equals("3")){
            Random r = new Random();
            int a = r.nextInt(2)+1;
            return a;
        }
        if(typ.equals("4")){
            Random r = new Random();
            int a = r.nextInt(3)+1;
            return a;
        }
        if(typ.equals("6")){
            Random r = new Random();
            int a = r.nextInt(5)+1;
            return a;
        }
        if(typ.equals("8")){
            Random r = new Random();
            int a = r.nextInt(7)+1;
            return a;
        }
        if(typ.equals("10")){
            Random r = new Random();
            int a = r.nextInt(9)+1;
            return a;
        }
        if(typ.equals("12")){
            Random r = new Random();
            int a = r.nextInt(11)+1;
            return a;
        }
        if(typ.equals("20")){
            Random r = new Random();
            int a = r.nextInt(19)+1;
            return a;
        }
        else{
            Random r = new Random();
            int a = r.nextInt(99)+1;
            return a;
        }
    }
    // D3, D4, D6, D8, D10, D12, D20, D100
//    xDy+z
//    gdzie:
//
//    y – rodzaj kostek, których należy użyć (np. D6, D10),
//    x – liczba rzutów kośćmi (jeśli rzucamy raz, ten parametr jest pomijalny),
//    z – (opcjonalnie) liczba, którą należy dodać (lub odjąć) do wyniku rzutów.
//
//    Przykłady:
//
//            2D10+10 – 2 rzuty D10, do wyniku dodaj 10,
//    D6 – zwykły rzut kostką sześcienną,
//    2D3 – rzut dwiema kostkami trójściennymi,
//    D12-1 – rzut kością D12, od wyniku odejmij 1.


}
