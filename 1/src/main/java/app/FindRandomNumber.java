package app;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class FindRandomNumber {

    public static int[] numbersArray = new int[100];
    public static int counter = 0;


    static int getRandomNumber() {
        Random randNumber = new Random();
        return randNumber.nextInt(101);
    }

    static String getUserName() {
        Scanner getName = new Scanner(System.in);
        System.out.print("Enter your name, please:");
        return getName.nextLine();
    }

    static void inputtedNumbers(int userNumber) {
        numbersArray[counter] = userNumber;
    }

    static int[] filterArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int minId = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    minId = j;
                }
            }
            int temp = array[i];
            array[i] = min;
            array[minId] = temp;
        }
        array = Arrays.stream(array).filter(el -> el != 0).toArray();
        return array;
    }

    static boolean userInputNumber(int genNumber, String name) {
        Scanner getUserInputNumber = new Scanner(System.in);
        System.out.print("Enter your number:");
        while (!getUserInputNumber.hasNextInt()) {
            System.out.println("That's not a number!");
            System.out.print("Enter your number:");
            getUserInputNumber.next();
        }
        int userNumber = getUserInputNumber.nextInt();
        counter = counter + 1;

        inputtedNumbers(userNumber);

        if (userNumber < genNumber) {
            System.out.println("Your number is too small. Please, try again");
        } else if (userNumber > genNumber) {
            System.out.println("Your number is too big. Please, try again.");
        } else if (userNumber == genNumber) {
            System.out.println("Congratulations, " + name);
        }
        return userNumber == genNumber;
    }

    public static void main(String[] args) {
        String name = getUserName();
        System.out.println(name + ", let the game begin!");
        int genNumber = getRandomNumber();
        while (!userInputNumber(genNumber, name)) {
            userInputNumber(genNumber, name);
        }
        System.out.println("Your numbers: " + Arrays.toString(filterArray(numbersArray)));
    }
}
