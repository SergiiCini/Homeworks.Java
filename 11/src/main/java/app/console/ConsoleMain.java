package app.console;

import app.FamilyController;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleMain {
    private static FamilyController familyController;
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, Runnable> commands = new HashMap<>();
    private static final Map<String, Runnable> additionalCommands = new HashMap<>();


    public ConsoleMain(FamilyController familyController) {
        this.familyController = familyController;
    }

    public static void main(String[] args) {
        ConsoleCommands.consoleCommand(familyController);
        ConsoleCommands.consoleAdditionalCommands(familyController);
        while (true){
            System.out.println(new ConsoleMenu().consoleMainMenu());
            String input = scanner.nextLine();
            ConsoleCommands.userConsoleInput("mainMenu", input);
        }
    }

}
