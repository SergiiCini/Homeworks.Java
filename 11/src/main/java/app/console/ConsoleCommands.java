package app.console;

import app.*;

import java.text.ParseException;
import java.util.*;

public class ConsoleCommands {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, Runnable> commands = new HashMap<>();
    private static final Map<String, Runnable> additionalCommands = new HashMap<>();

    public static void consoleCommand(FamilyController familyController) {
        System.out.println(familyController);
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
                ConsoleCreateFamily.createFamily(familyController);
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
                familyController.deleteFamilyByIndex(familyIndex - 1);
            }
        });

        commands.put("8", () -> {
            System.out.println(new ConsoleMenu().consoleAdditionalMenu());
            String userInput = scanner.nextLine();
            userConsoleInput("additionalMenu", userInput);
        });

        commands.put("9", () -> {
            System.out.println("Enter the age older then you want to delete children:");
            int childAgeToDelete = getNumber();
            familyController.deleteAllChildrenOlderThen(childAgeToDelete);
        });

        commands.put("exit", () -> {
            System.out.println("Are you sure you want to exit (Yes/No)?");
            String exitConfirmation = scanner.nextLine().trim().toLowerCase(Locale.ROOT);
            switch (exitConfirmation) {
                case "yes": {
                    System.exit(0);
                }
                case "no": {
                    System.out.println(new ConsoleMenu().consoleAdditionalMenu());
                }
            }
        });
    }

    public static void consoleAdditionalCommands(FamilyController familyController) {
        additionalCommands.put("1", () -> {
            ArrayList<Family> families = (ArrayList<Family>) familyController.getAllFamilies();
            if (families.size() == 0) {
                System.out.println("There are no saved families in out DB. You need to create families first!");
            } else {
                System.out.println("Enter the index of family you want to edit:");

                int familyIndex = getNumber();
                Family editedFamily = familyController.getFamilyById(familyIndex);
                try {
                    System.out.println("Enter boy's name if you will have a boy:");
                    String boysName = scanner.nextLine();
                    System.out.println("Enter girl's name if you will have a girl:");
                    String girlsName = scanner.nextLine();
                    familyController.bornChild(editedFamily, boysName, girlsName);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });

        additionalCommands.put("2", () -> {
            System.out.println("I'm here!");
            String gender;
            ArrayList<Family> families = (ArrayList<Family>) familyController.getAllFamilies();
            if (families.size() == 0) {
                System.out.println("There are no saved families in out DB. You need to create families first!");
            } else {
                System.out.println("Enter the index of family you want to edit:");

                int familyIndex = getNumber();
                Family editedFamily = familyController.getFamilyById(familyIndex);
                try {
                    while (true) {
                        System.out.println("Enter child gender (boy or girl):");
                        gender = scanner.nextLine();
                        if (gender.equals("boy") || gender.equals("girl")) {
                            break;
                        }
                    }
                    Human adoptChild = createAdoptChild(gender);
                    familyController.adoptChild(editedFamily, adoptChild);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });

        additionalCommands.put("3", () -> {
            System.out.println("Going back to main menu...");
        });
    }

    public static void userConsoleInput(String menuType, String userInput) {
        switch (menuType) {
            case "mainMenu": {
                Runnable getMenuValue = commands.get(userInput);
                getMenuValue.run();
            }
            case "additionalMenu": {
                Runnable getAdditionalMenuValue = additionalCommands.get(userInput);
                getAdditionalMenuValue.run();
            }
        }
    }

    public static int getNumber() {
        return Integer.parseInt(scanner.nextLine());
    }

    public static String getString() {
        return scanner.nextLine();
    }

    public static Human createAdoptChild(String gender) throws ParseException {
        switch (gender) {
            case "boy": {
                System.out.println("Enter son's name:");
                String sonName = scanner.nextLine();
                System.out.println("Enter son's surname");
                String sonSurname = scanner.nextLine();
                System.out.println("Enter son's year of birth:");
                String sonBirthdayYear = scanner.nextLine();
                System.out.println("Enter son's month of birth:");
                String sonBirthdayMonth = scanner.nextLine();
                System.out.println("Enter son's day of birth:");
                String sonBirthdayDay = scanner.nextLine();
                System.out.println("Enter son's iq-level:");
                int sonIq = Integer.parseInt(scanner.nextLine());
                String sonBirthDay = ConsoleCreateFamily.birthDaySticker(sonBirthdayDay, sonBirthdayMonth, sonBirthdayYear);
                return new Man(sonName, sonSurname, sonBirthdayDay, sonIq);
            }
            case "girl": {
                System.out.println("Enter daughter's name:");
                String daughterName = scanner.nextLine();
                System.out.println("Enter daughter's surname");
                String daughterSurname = scanner.nextLine();
                System.out.println("Enter daughter's year of birth:");
                String daughterBirthdayYear = scanner.nextLine();
                System.out.println("Enter daughter's month of birth:");
                String daughterBirthdayMonth = scanner.nextLine();
                System.out.println("Enter daughter's day of birth:");
                String daughterBirthdayDay = scanner.nextLine();
                System.out.println("Enter daughter's iq-level:");
                int daughterIq = Integer.parseInt(scanner.nextLine());
                String daughterBirthDay = ConsoleCreateFamily.birthDaySticker(daughterBirthdayDay, daughterBirthdayMonth, daughterBirthdayYear);
                return new Woman(daughterName, daughterSurname, daughterBirthdayDay, daughterIq);
            }
            default:
                return null;
        }
    }


}
