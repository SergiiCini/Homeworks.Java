package app;

import app.console.ConsoleMain;

public class Main {
    public static FamilyController familyController;

    public static void main(String[] args){
        familyController = new FamilyController();

        ConsoleMain console = new ConsoleMain(familyController);

    }
}
