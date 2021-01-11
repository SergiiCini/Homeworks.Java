package app.console;

import app.Family;
import app.FamilyController;
import app.RandomFamilyCreator;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleCommands {
    private static FamilyController familyController;
    private static final Scanner scanner = new Scanner(System.in);

    public void consoleCommands() {
        ConsoleMain.consoleCommand(familyController);
    }

    static void consoleCommand(FamilyController familyController) {
        Map<String, Runnable> commands = new HashMap<>();

        commands.put("1", () -> {
            try {
                new RandomFamilyCreator(familyController).FamiliesCreator();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            System.out.println("Three random families was created and saved in database!");
        });

        commands.put("2", () -> {
            familyController.displayAllFamilies();
        });

        commands.put("3", () -> {
            ArrayList<Family> families = (ArrayList<Family>) familyController.getAllFamilies();
            if (families.size() == 0) {
                System.out.println("There are no saved families in out DB. You need to create families first!");
            } else {
                System.out.println("Enter a family members number:");
                int numberOfMembers = getNumber();
                familyController.getFamiliesBiggerThan(numberOfMembers);
            }
        });

        commands.put("4", () -> {
            ArrayList<Family> families = (ArrayList<Family>) familyController.getAllFamilies();
            if (families.size() == 0) {
                System.out.println("There are no saved families in out DB. You need to create families first!");
            } else {
                System.out.println("Enter a family members number:");
                int numberOfMembers = getNumber();
                familyController.getFamiliesLessThan(numberOfMembers);
            }
        });

        commands.put("5", () -> {
            ArrayList<Family> families = (ArrayList<Family>) familyController.getAllFamilies();
            if (families.size() == 0) {
                System.out.println("There are no saved families in out DB. You need to create families first!");
            } else {
                System.out.println("Enter a family members number:");
                int numberOfMembers = getNumber();
                familyController.countFamiliesWithMemberNumber(numberOfMembers);
            }
        });

        commands.put("6", () -> {
            try {
                new ConsoleCreateFamily();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });

        commands.put("7", () -> {
            ArrayList<Family> families = (ArrayList<Family>) familyController.getAllFamilies();
            if (families.size() == 0) {
                System.out.println("There are no saved families in out DB. You need to create families first!");
            } else {
                System.out.println("Enter the index of family you want to delete:");
                int familyIndex = getNumber();
                familyController.deleteFamilyByIndex(familyIndex);
            }
        });

        commands.put("8", () -> {
            ArrayList<Family> families = (ArrayList<Family>) familyController.getAllFamilies();
            if (families.size() == 0) {
                System.out.println("There are no saved families in out DB. You need to create families first!");
            } else {
                System.out.println("Enter the index of family you want to edit:");
                int familyIndex = getNumber();
                Family editedFamily = familyController.getFamilyById(familyIndex);
                try {
                    System.out.println("Enter boy's name if there will be a boy:");
                    String boysName = scanner.nextLine();
                    System.out.println("Enter girl's name if there will be a girl:");
                    String girlsName = scanner.nextLine();
                    familyController.bornChild(editedFamily, boysName, girlsName);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static int getNumber() {
        int number = 0;
        return number;
    }
}
