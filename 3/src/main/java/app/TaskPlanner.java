package app;

import java.util.Scanner;

public class TaskPlanner {
    public static String[][] schedule = new String[7][2];

    public static String[][] weekSchedule() {
        schedule[0][0] = "Sunday";
        schedule[0][1] = "do home work";
        schedule[1][0] = "Monday";
        schedule[1][1] = "go to courses; watch a film";
        schedule[2][0] = "Tuesday";
        schedule[2][1] = "go to gym";
        schedule[3][0] = "Wednesday";
        schedule[3][1] = "meet with Alex";
        schedule[4][0] = "Thursday";
        schedule[4][1] = "go to gym; finish with budget calculations";
        schedule[5][0] = "Friday";
        schedule[5][1] = "go to courses; have some beer with old gang :)";
        schedule[6][0] = "Saturday";
        schedule[6][1] = "do shopping, watch movie";
        return schedule;
    }

    public static void inputScanner() {
        Scanner daysScanner = new Scanner(System.in);
        System.out.print("\nPlease, input the day of the week:  ");
        String inputtedData = daysScanner.nextLine();
        if (inputtedData.equalsIgnoreCase("exit")) {
            quit();
        } else if (inputtedData.toLowerCase().contains("change")) {
            changeSchedule(inputtedData.toLowerCase());
        } else plansReminder(inputtedData);
    }

    public static void plansReminder(String day) {
        switch (day.toLowerCase().trim()) {
            case "sunday": {
                System.out.print("\n" + "Your tasks for " + schedule[0][0] + ": " + schedule[0][1] + "\n");
                break;
            }
            case "monday": {
                System.out.print("\n" + "Your tasks for " + schedule[1][0] + ": " + schedule[1][1] + "\n");
                break;
            }
            case "tuesday": {
                System.out.print("\n" + "Your tasks for " + schedule[2][0] + ": " + schedule[2][1] + "\n");
                break;
            }
            case "wednesday": {
                System.out.print("\n" + "Your tasks for " + schedule[3][0] + ": " + schedule[3][1] + "\n");
                break;
            }
            case "thursday": {
                System.out.print("\n" + "Your tasks for " + schedule[4][0] + ": " + schedule[4][1] + "\n");
                break;
            }
            case "friday": {
                System.out.print("\n" + "Your tasks for " + schedule[5][0] + ": " + schedule[5][1] + "\n");
                break;
            }
            case "saturday": {
                System.out.print("\n" + "Your tasks for " + schedule[6][0] + ": " + schedule[6][1] + "\n");
                break;
            }
            default:
                System.out.println("\nSorry, I don't understand you, please try again.");
                break;
        }
        inputScanner();
    }

    public static void quit() {
        System.out.println("\nHave a good day!");
    }

    public static void changeSchedule(String changeData) {
        if (changeData.toLowerCase().trim().contains("sunday")) {
            System.out.print("\n" + "Please, input new tasks for " + schedule[0][0] + ": ");
            schedule[0][1] = changeScheduleInput();
        } else if (changeData.toLowerCase().trim().contains("monday")) {
            System.out.print("\n" + "Please, input new tasks for " + schedule[1][0] + ": ");
            schedule[1][1] = changeScheduleInput();
        } else if (changeData.toLowerCase().trim().contains("tuesday")) {
            System.out.print("\n" + "Please, input new tasks for " + schedule[2][0] + ": ");
            schedule[2][1] = changeScheduleInput();
        } else if (changeData.toLowerCase().trim().contains("wednesday")) {
            System.out.print("\n" + "Please, input new tasks for " + schedule[3][0] + ": ");
            schedule[3][1] = changeScheduleInput();
        } else if (changeData.toLowerCase().trim().contains("thursday")) {
            System.out.print("\n" + "Please, input new tasks for " + schedule[4][0] + ": ");
            schedule[4][1] = changeScheduleInput();
        } else if (changeData.toLowerCase().trim().contains("friday")) {
            System.out.print("\n" + "Please, input new tasks for " + schedule[5][0] + ": ");
            schedule[5][1] = changeScheduleInput();
        } else if (changeData.toLowerCase().trim().contains("saturday")) {
            System.out.print("\n" + "Please, input new tasks for " + schedule[6][0] + ": ");
            schedule[6][1] = changeScheduleInput();
        } else System.out.println("You have entered the incorrect day of the week...");
        inputScanner();
    }

    public static String changeScheduleInput(){
        Scanner userInput = new Scanner(System.in);
        String newData = userInput.nextLine();
        System.out.println("\n" + "New tasks were successfully saved!");
        return newData;
    }

    public static void main(String[] args) {
        weekSchedule();
        inputScanner();
    }

}
