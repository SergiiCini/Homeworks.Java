package app.console;

public class ConsoleMenu {

    public String consoleMenu(){
        return "\n\t\t\t\t\tMAIN MENU\n" +
                "1. Create random families and save them to database.\n"+
                "2. Show the list of all families.\n"+
                "3. Show the list of families where the number of members are bigger then have entered.\n" +
                "4. Show the list of families where the number of members are less then have entered.\n" +
                "5. Count families with the same number of members.\n" +
                "6. Create a new family.\n" +
                "7. Delete the family by index list number.\n" +
                "8. Edit the family by index list number.\n" +
                "9. Delete children by older years parameter.\n" +
                "exit";
    }
}
