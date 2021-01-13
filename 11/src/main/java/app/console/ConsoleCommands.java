package app.console;

import app.*;

import java.text.ParseException;
import java.util.*;

public class ConsoleCommands {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, Runnable> commands = new HashMap<>();
    private static final Map<String, Runnable> additionalCommands = new HashMap<>();

    public static void consoleCommand(FamilyController familyController) {
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
                int familyIndex;
                System.out.println("Enter the index of family you want to delete:");
                while (true) {
                    System.out.printf("Input family number should be by range from 1 to %d! ", families.size());
                    familyIndex = getNumber();
                    if (familyIndex > 0 && familyIndex <= families.size()) break;
                }
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
                    break;
                }
                default:
                    break;
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
                int familyIndex;
                while (true) {
                    System.out.printf("There are %d families in our DB.", families.size());
                    familyIndex = getNumber();
                    if (familyIndex >= 1 && familyIndex <= families.size()) {
                        break;
                    }
                }
                Family editedFamily = familyController.getFamilyById(familyIndex - 1);
                System.out.println("Enter boy's name if you will have a boy:");
                String boysName = scanner.next();

                System.out.println("Enter girl's name if you will have a girl:");
                String girlsName = scanner.next();

                try {
                    familyController.bornChild(editedFamily, boysName, girlsName);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });

        additionalCommands.put("2", () -> {
            String gender;
            ArrayList<Family> families = (ArrayList<Family>) familyController.getAllFamilies();
            if (families.size() == 0) {
                System.out.println("There are no saved families in out DB. You need to create families first!");
            } else {
                System.out.println("Enter the index of family you wont to edit:");
                int familyIndex;
                while (true) {
                    System.out.printf("There are %d families in our DB.", families.size());
                    familyIndex = getNumber();
                    if (familyIndex >= 1 && familyIndex <= families.size()) {
                        break;
                    }
                }
                Family editedFamily = familyController.getFamilyById(familyIndex - 1);
                try {
                    while (true) {
                        gender = scanner.nextLine().trim().toLowerCase();
                        System.out.println("Enter child gender (boy or girl):");
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
                List<String> mainMenuItems = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "exit");
                if (mainMenuItems.contains(userInput)) {
                    Runnable getMenuValue = commands.get(userInput);
                    getMenuValue.run();
                } else {
                    System.out.println("You have entered incorrect menu input data. Please, try again!");
                }
                break;
            }
            case "additionalMenu": {
                List<String> additionalMenuItems = Arrays.asList("1", "2", "3");
                if (additionalMenuItems.contains(userInput)) {
                    Runnable getAdditionalMenuValue = additionalCommands.get(userInput);
                    getAdditionalMenuValue.run();
                } else {
                    System.out.println("You have entered incorrect menu input data. Please, try again!");
                }
                break;
            }
            default:
                break;
        }
    }

    public static int getNumber() {
        while (!scanner.hasNextInt()) {
            System.out.println("Incorrect input format! Input data should be a number.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static String getString() {
        return scanner.nextLine();
    }

    public static Human createAdoptChild(String gender) throws ParseException {
        switch (gender) {
            case "boy": {
                System.out.println("Enter son's name:");
                String sonName = getString();
                System.out.println("Enter son's surname");
                String sonSurname = getString();
                System.out.println("Enter son's year of birth:");
                int sonBirthdayYear;
                while (true) {
                    System.out.println("The year of birth should be in range from 1920 to 2010!");
                    sonBirthdayYear = getNumber();
                    if (sonBirthdayYear >= 1920 && sonBirthdayYear <= 2010) break;
                }
                String sonBirthdayYearString = String.valueOf(sonBirthdayYear);
                System.out.println("Enter son's month of birth:");
                int sonBirthdayMonth;
                while (true) {
                    System.out.println("The month of birth should be in range from 1 to 12!");
                    sonBirthdayMonth = getNumber();
                    if (sonBirthdayMonth >= 1 && sonBirthdayMonth <= 12) break;
                }
                String sonBirthdayMonthString = String.valueOf(sonBirthdayMonth);
                System.out.println("Enter son's day of birth:");
                int sonBirthdayDay;
                while (true) {
                    System.out.println("The day of birth should be in range from 1 to 31!");
                    sonBirthdayDay = getNumber();
                    if (sonBirthdayDay >= 1 && sonBirthdayDay <= 31) break;
                }
                String sonBirthdayDayString = String.valueOf(sonBirthdayDay);
                System.out.println("Enter son's iq-level:");
                int sonIq = 0;
                while (true) {
                    System.out.println("The iq-level should be in range from 1 to 100");
                    sonIq = getNumber();
                    if (sonIq > 0 && sonIq <= 100) break;
                }
                String sonBirthDay = ConsoleCreateFamily.birthDaySticker(sonBirthdayDayString, sonBirthdayMonthString, sonBirthdayYearString);
                return new Man(sonName, sonSurname, sonBirthDay, sonIq);
            }
            case "girl": {
                System.out.println("Enter daughter's name:");
                String daughterName = getString();
                System.out.println("Enter daughter's surname");
                String daughterSurname = getString();
                System.out.println("Enter daughter's year of birth:");
                int daughterBirthdayYear;
                while (true) {
                    System.out.println("The year of birth should be in range from 1920 to 2010!");
                    daughterBirthdayYear = getNumber();
                    if (daughterBirthdayYear >= 1920 && daughterBirthdayYear <= 2010) break;
                }
                String daughterBirthdayYearString = String.valueOf(daughterBirthdayYear);
                System.out.println("Enter daughter's month of birth:");
                int daughterBirthdayMonth;
                while (true) {
                    System.out.println("The month of birth should be in range from 1 to 12!");
                    daughterBirthdayMonth = getNumber();
                    if (daughterBirthdayMonth >= 1 && daughterBirthdayMonth <= 12) break;
                }
                String daughterBirthdayMonthString = String.valueOf(daughterBirthdayMonth);
                System.out.println("Enter daughter's day of birth:");
                int daughterBirthdayDay;
                while (true) {
                    System.out.println("The day of birth should be in range from 1 to 31!");
                    daughterBirthdayDay = getNumber();
                    if (daughterBirthdayDay >= 1 && daughterBirthdayDay <= 31) break;
                }
                String daughterBirthdayDayString = String.valueOf(daughterBirthdayDay);
                System.out.println("Enter daughter's iq-level:");
                int daughterIq = 0;
                while (true) {
                    System.out.println("The iq-level should be in range from 1 to 100");
                    daughterIq = getNumber();
                    if (daughterIq > 0 && daughterIq <= 100) break;
                }
                String daughterBirthDay = ConsoleCreateFamily.birthDaySticker(daughterBirthdayDayString, daughterBirthdayMonthString, daughterBirthdayYearString);
                return new Woman(daughterName, daughterSurname, daughterBirthDay, daughterIq);
            }
            default:
                return null;
        }
    }
}
