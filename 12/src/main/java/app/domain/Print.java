package app.domain;

import java.text.ParseException;
import java.util.*;

public class Print {

    public static void TestFamily() throws ParseException {
        HashMap<WeekData, String> schedule1 = new HashMap<>();
        schedule1.put(WeekData.SUNDAY, "Task for " + WeekData.SUNDAY.name());
        schedule1.put(WeekData.MONDAY, "Task for " + WeekData.MONDAY.name());

        HashMap<WeekData, String> schedule2 = new HashMap<>();
        schedule2.put(WeekData.WEDNESDAY, "Task for " + WeekData.WEDNESDAY.name());
        schedule2.put(WeekData.MONDAY, "Task for " + WeekData.MONDAY.name());

        HashMap<WeekData, String> schedule3 = new HashMap<>();
        schedule3.put(WeekData.WEDNESDAY, "Task for " + WeekData.WEDNESDAY.name());
        schedule3.put(WeekData.SATURDAY, "Task for " + WeekData.SATURDAY.name());

        HashMap<WeekData, String> schedule4 = new HashMap<>();
        schedule4.put(WeekData.THURSDAY, "Task for " + WeekData.THURSDAY.name());
        schedule4.put(WeekData.WEDNESDAY, "Task for " + WeekData.WEDNESDAY.name());

        Woman mother1 = new Woman("Kate", "Middletone", "16/01/1954", 80, schedule1);
        Man father1 = new Man("Michael", "Kors", "12/01/1956", 60, schedule2);
        Man child1 = new Man("Sergio", "Kors", "24/05/1994", 90, schedule4);
        Man child2 = new Man("Alex", "Kors", "12/12/2001", 90, schedule3);
        Woman child3 = new Woman("Jane", "Kors", "31/01/2001", 80, schedule1);

        Family newFamily = new Family(mother1, father1);
        newFamily.addChild(child1);
        newFamily.addChild(child2);
        newFamily.addChild(child3);

        Fish pet1 = new Fish("Flaunder", 1, 20, new HashSet<>(Arrays.asList("eat", "swim", "sleep")));
        Dog pet2 = new Dog("Chester", 2, 60, new HashSet<>(Arrays.asList("eat", "walk", "sleep")));
        RoboCat pet3 = new RoboCat("R2D2", 99, 99, new HashSet<>(Arrays.asList("clean", "charge")));
        newFamily.addPet(pet1);
        newFamily.addPet(pet2);
        newFamily.addPet(pet3);
        System.out.println(newFamily.toString());
    }

    public static void GarbageCollectorInit() throws ParseException {
        Woman mother = new Woman("Ann", "Cini", "12/12/1992", 85);
        Man father = new Man("Serg", "Cini", "19/11/1987", 99);
        for (int i = 0; i < 1000000; i++) {
            new Family(mother, father);
        }
    }
}
