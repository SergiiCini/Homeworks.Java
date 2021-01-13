package app.console;

import app.controller.FamilyController;
import app.domain.Family;
import app.domain.Man;
import app.domain.Woman;

import java.text.ParseException;
import java.util.Scanner;

public class ConsoleCreateFamily {
    private Family family;
    private static final Scanner scanner = new Scanner(System.in);

    public static Family createFamily(FamilyController familyController) throws ParseException {
        return familyController.createNewFamily(createMother(), createFather());
    }

    public static Woman createMother() throws ParseException {
        System.out.println("Enter mother's name:");
        String motherName = ConsoleCommands.getString();
        System.out.println("Enter mother's surname:");
        String motherSurname = ConsoleCommands.getString();
        System.out.println("Enter mother's year of birth:");
        int motherBirthdayYear;
        while (true) {
            System.out.println("The year of birth should be in range from 1900 to 2010!");
            motherBirthdayYear = ConsoleCommands.getNumber();
            if (motherBirthdayYear >= 1900 && motherBirthdayYear <= 2010) break;
        }
        String motherBirthdayYearString = String.valueOf(motherBirthdayYear);
        System.out.println("Enter mother's month of birth:");
        int motherBirthdayMonth;
        while (true) {
            System.out.println("The month of birth should be in range from 1 to 12!");
            motherBirthdayMonth = ConsoleCommands.getNumber();
            if (motherBirthdayMonth >= 1 && motherBirthdayMonth <= 12) break;
        }
        String motherBirthdayMonthString = String.valueOf(motherBirthdayMonth);
        System.out.println("Enter mother's day of birth:");
        int motherBirthdayDay;
        while (true) {
            System.out.println("The day of birth should be in range from 1 to 31!");
            motherBirthdayDay = ConsoleCommands.getNumber();
            if (motherBirthdayDay >= 1 && motherBirthdayDay <= 31) break;
        }
        String motherBirthdayDayString = String.valueOf(motherBirthdayDay);
        System.out.println("Enter mother's iq-level:");
        int matherIq;
        while (true) {
            System.out.println("The iq-level should be in range from 1 to 100");
            matherIq = ConsoleCommands.getNumber();
            if (matherIq > 0 && matherIq <= 100) break;
        }
        return new Woman(motherName, motherSurname, birthDaySticker(motherBirthdayDayString, motherBirthdayMonthString, motherBirthdayYearString), matherIq);
    }

    public static Man createFather() throws ParseException {
        System.out.println("Enter father's name:");
        String fatherName = scanner.nextLine();
        System.out.println("Enter father's surname:");
        String fatherSurname = scanner.nextLine();
        System.out.println("Enter father's year of birth:");
        int fatherBirthdayYear;
        while (true) {
            System.out.println("The year of birth should be in range from 1900 to 2010!");
            fatherBirthdayYear = ConsoleCommands.getNumber();
            if (fatherBirthdayYear >= 1900 && fatherBirthdayYear <= 2010) break;
        }
        String fatherBirthdayYearString = String.valueOf(fatherBirthdayYear);
        System.out.println("Enter father's month of birth:");
        int fatherBirthdayMonth;
        while (true) {
            System.out.println("The month of birth should be in range from 1 to 12!");
            fatherBirthdayMonth = ConsoleCommands.getNumber();
            if (fatherBirthdayMonth >= 1 && fatherBirthdayMonth <= 12) break;
        }
        String fatherBirthdayMonthString = String.valueOf(fatherBirthdayMonth);
        System.out.println("Enter father's day of birth:");
        int fatherBirthdayDay;
        while (true) {
            System.out.println("The day of birth should be in range from 1 to 31!");
            fatherBirthdayDay = ConsoleCommands.getNumber();
            if (fatherBirthdayDay >= 1 && fatherBirthdayDay <= 31) break;
        }
        String fatherBirthdayDayString = String.valueOf(fatherBirthdayDay);
        System.out.println("Enter father's iq-level:");
        int fatherIq;
        while (true) {
            System.out.println("The iq-level should be in range from 1 to 100");
            fatherIq = ConsoleCommands.getNumber();
            if (fatherIq > 0 && fatherIq <= 100) break;
        }
        return new Man(fatherName, fatherSurname, birthDaySticker(fatherBirthdayDayString, fatherBirthdayMonthString, fatherBirthdayYearString), fatherIq);
    }

    public static String birthDaySticker(String day, String month, String year) {
        return day + "/" + month + "/" + year;
    }

}
