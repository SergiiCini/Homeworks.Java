package app.domain;

import app.controller.FamilyController;
import app.domain.*;

import java.text.ParseException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class RandomFamilyCreator {
    private static FamilyController familyController;

    public RandomFamilyCreator(FamilyController familyController) {
        this.familyController = new FamilyController();
    }

    public void FamiliesCreator() throws ParseException {

        // Just create several families to operate.
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

        Woman mother1 = new Woman("Kate", "Middletone", "24/01/1954", 80, schedule1);
        Man father1 = new Man("Michael", "Kors", "18/12/1956", 60, schedule2);
        Woman child1 = new Woman("Nika", "Kors", "31/01/1988", 90, schedule4);
        Woman child2 = new Woman("Samanta", "Kors", "21/04/1990", 85, schedule3);
        Fish pet1 = new Fish("Flaunder", 1, 20, new HashSet<>(Arrays.asList("eat", "swim", "sleep")));
        Dog pet2 = new Dog("Chester", 2, 60, new HashSet<>(Arrays.asList("eat", "walk", "sleep")));

        Woman mother2 = new Woman("Sara", "Cooper", "15/04/1954", 80, schedule3);
        Man father2 = new Man("Bob", "Cooper", "12/12/1956", 60, schedule4);
        Woman child3 = new Woman("Anna", "Cooper", "16/03/1985", 90, schedule1);
        Dog pet3 = new Dog("Chelsy", 5, 80, new HashSet<>(Arrays.asList("eat", "sleep")));

        Woman mother3 = new Woman("Anna", "Stone", "08/08/1992", 95, schedule2);
        Man father3 = new Man("Alex", "Stone", "19/11/1987", 99, schedule4);
        Man child4 = new Man("Fred", "Stone", "02/11/2008", 70, schedule3);
        RoboCat pet4 = new RoboCat("R2D2", 99, 99, new HashSet<>(Arrays.asList("clean", "charge")));


        Family newFamily1 = familyController.createNewFamily(mother1, father1);
        newFamily1.addChild(child1);
        newFamily1.addChild(child2);
        Family newFamily2 = familyController.createNewFamily(mother2, father2);
        newFamily2.addChild(child3);
        Family newFamily3 = familyController.createNewFamily(mother3, father3);
        newFamily3.addChild(child4);
        familyController.addPet(0, pet1);
        familyController.addPet(0, pet2);
        familyController.addPet(1, pet3);
        familyController.addPet(2, pet4);

        familyController.bornChild(newFamily3, "Ivan", "Vera");

    }

}
