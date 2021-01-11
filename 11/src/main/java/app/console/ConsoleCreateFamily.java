package app.console;

import app.*;

import java.text.ParseException;
import java.util.Scanner;

public class ConsoleCreateFamily {
    Family family;
    private static final Scanner scanner = new Scanner(System.in);
    private static FamilyController familyController;

       public ConsoleCreateFamily() throws ParseException {
        this.family = familyController.createNewFamily(createMother(), createFather());
    }

    public static Woman createMother() throws ParseException {
        System.out.println("Enter mother's name:");
        String motherName = scanner.nextLine();
        System.out.println("Enter mother's surname:");
        String motherSurname = scanner.nextLine();
        System.out.println("Enter mother's year of birth:");
        String motherBirthdayYear = scanner.nextLine();
        System.out.println("Enter mother's month of birth:");
        String motherBirthdayMonth = scanner.nextLine();
        System.out.println("Enter mother's day of birth:");
        String motherBirthdayDay = scanner.nextLine();
        System.out.println("Enter mother's iq-level:");
        int matherIq = Integer.parseInt(scanner.nextLine());

        return new Woman(motherName, motherSurname, birthDaySticker(motherBirthdayDay, motherBirthdayMonth, motherBirthdayYear), matherIq);
    }

    public static Man createFather() throws ParseException {
        System.out.println("Enter father's name:");
        String fatherName = scanner.nextLine();
        System.out.println("Enter father's surname:");
        String fatherSurname = scanner.nextLine();
        System.out.println("Enter father's year of birth:");
        String fatherBirthdayYear = scanner.nextLine();
        System.out.println("Enter father's month of birth:");
        String fatherBirthdayMonth = scanner.nextLine();
        System.out.println("Enter father's day of birth:");
        String fatherBirthdayDay = scanner.nextLine();
        System.out.println("Enter father's iq-level:");
        int fatherIq = Integer.parseInt(scanner.nextLine());

        return new Man(fatherName, fatherSurname, birthDaySticker(fatherBirthdayDay, fatherBirthdayMonth, fatherBirthdayYear), fatherIq);
    }

    public static String birthDaySticker(String day, String month, String year) {
        return day + "/" + month + "/" + year;
    }

}
