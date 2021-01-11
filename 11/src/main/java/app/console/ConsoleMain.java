package app.console;

import app.FamilyController;
import app.RandomFamilyCreator;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleMain {
    private static FamilyController familyController;

    public ConsoleMain(FamilyController familyController) {
        ConsoleMain.familyController = familyController;
    }

    public static void main(String[] args) {
        ConsoleCommands.consoleCommand(familyController);
        while (true) {
            System.out.println(new ConsoleMenu().consoleMenu());
        }


    }




    public static void consoleCommand(FamilyController familyController) {
    }
}
