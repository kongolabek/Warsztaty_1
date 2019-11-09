package Zadania_Warsztaty;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {

        int [] randNumbers = getLottoRandNumbers();
        System.out.println(Arrays.toString(randNumbers));

        int [] userNumbers = getUserNumbers();


        int sum = 0;
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 6; j++){
                if(randNumbers[i] == userNumbers[j]){
                    sum++;
                }

            }

        }
        if(sum < 3){
            System.out.println("nic nie trafiles");
        }
        else if(sum == 3){
            System.out.println("Trafiles 3");
        }
        else if(sum == 4){
            System.out.println("Trafiles 4");
        }
        else if(sum == 5){
            System.out.println("Trafiles 5");
        }
        else{
            System.out.println("Trafiles 6");
        }


    }

    private static int[] getUserNumbers() {
        Scanner scanner = new Scanner(System.in);
        int[] userNumbers = new int[6];
        for(int i = 0; i < 6; i++){
            while(true){
                while(!scanner.hasNextInt()){
                    scanner.nextLine();
                }
                int number = scanner.nextInt();
                if(numberIsOk(userNumbers, number)){
                    userNumbers[i] = number;
                    break;
                }
            }
            System.out.println("Dodano do tablicy " + userNumbers[i]);
        }

        return userNumbers;
    }

    private static boolean numberIsOk(int[] userNumbers, int number) {
        if(number < 1 || number >49) return false;
        for(int i =0; i < userNumbers.length; i++){
            if(userNumbers[i] == number){
                return false;
            }
        }

        return true;
    }




    static int [] getLottoRandNumbers(){
        Random rand = new Random();
        int [] possibleNumbers = getPossibleRandNumbers();
        int [] randNumbers = new int [6];
        for(int i = 0; i <randNumbers.length; i++){
            int randMax = possibleNumbers.length-(i+1);
            int randIndex = rand.nextInt(randMax)+1;
            randNumbers[i] = possibleNumbers[randIndex];
            possibleNumbers[randIndex] = possibleNumbers[randMax];
        }
        return randNumbers;
    }


    private static int[] getPossibleRandNumbers() {
        int[] possibleNumbers = new int[49];
        for (int i = 0; i < possibleNumbers.length; i++){
            possibleNumbers[i] = i;
        }

        return possibleNumbers;
    }
}
