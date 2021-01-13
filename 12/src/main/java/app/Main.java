package app;

import app.console.ConsoleMain;

import java.text.ParseException;

public class Main {
    public static FamilyController familyController;

    public static void main(String[] args) throws ParseException {
        familyController = new FamilyController();
        new ConsoleMain(familyController);

    }
}
