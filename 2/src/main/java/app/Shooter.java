package app;

import java.util.Arrays;
import java.util.Scanner;

public class Shooter {

    public static String[][] shooterArea = new String[6][6];
    public static int[] userShootData = new int[2];

    public static void main(String[] args) {
        System.out.println("All set. Get ready to rumble!");
        generateShoot();
        startGame();
        userInput();
    }

    public static void startGame() {
        for (int i = 0; i < shooterArea.length; i++) {
            for (int j = 0; j < shooterArea.length; j++) {
                if (i == 0 && j >= 0) {
                    System.out.print(j);
                    System.out.print(shooterArea[i][j] = "");
                } else if (i > 0 && j == 0) {
                    System.out.print(i);
                    System.out.print(shooterArea[i][j] = "");
                } else if (i != 0 && j > 0) {
                    shooterArea[i][j] = "-";
                }
                System.out.print(shooterArea[i][j] + "|");
            }
            System.out.println();
        }
    }

    public static void generateShoot() {
        double ver = Math.random() * 5;
        double hor = Math.random() * 5;
        userShootData[0] = (int) ver + 1;
        userShootData[1] = (int) hor + 1;
        System.out.println(Arrays.toString(userShootData));
    }

    public static void userInput() {
        isWin(enteredVerticalNumber(), enteredHorizontalNumber());
    }

    public static int enteredVerticalNumber() {
        Scanner verticalScan = new Scanner(System.in);
        System.out.print("Enter vertical shoot parameter: ");
        while (!verticalScan.hasNextInt()) {
            System.out.println("You have entered incorrect amount! Enter integer!");
            System.out.print("Enter vertical shoot parameter: ");
            verticalScan.next();
        }
        return verticalScan.nextInt();
    }

    public static int enteredHorizontalNumber() {
        Scanner horizontalScan = new Scanner(System.in);
        System.out.print("Enter horizontal shoot parameter: ");
        while (!horizontalScan.hasNextInt()) {
            System.out.println("You have entered incorrect amount! Enter integer!");
            System.out.print("Enter horizontal shoot parameter: ");
            horizontalScan.next();
        }
        return horizontalScan.nextInt();
    }

    public static boolean checkIfWin(int x, int y) {
        return (userShootData[0] == x && userShootData[1] == y);
    }

    public static void isWin(int x, int y) {
        if (!checkIfWin(x, y)) {
            shootMiss(x, y);
        } else shootWin(x, y);
    }

    public static void shootMiss(int x, int y) {
        shooterArea[x][y] = "*";
        showResults();
        System.out.println("You have missed! Try again!");
        userInput();
    }

    public static void shootWin(int x, int y) {
        shooterArea[x][y] = "x";
        showResults();
        System.out.println("You have won!");
    }

    public static void showResults() {
        for (int i = 0; i < shooterArea.length; i++) {
            for (int j = 0; j < shooterArea.length; j++) {
                if (i == 0 && j >= 0) {
                    System.out.print(j);
                    System.out.print(shooterArea[i][j] = "");
                } else if (i > 0 && j == 0) {
                    System.out.print(i);
                    System.out.print(shooterArea[i][j] = "");
                }
                System.out.print(shooterArea[i][j] + "|");
            }
            System.out.println();
        }
    }
}
