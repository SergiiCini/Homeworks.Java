package app;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FamilyTest {
    @BeforeAll
            void createDataToTest(){
        String[][] schedule1 = {
                {WeekData.SUNDAY.name(), "Task for " + WeekData.SUNDAY.name()},
                {WeekData.MONDAY.name(), "Task for " + WeekData.MONDAY.name()}
        };
        String[][] schedule2 = {
                {WeekData.WEDNESDAY.name(), "Task for " + WeekData.WEDNESDAY.name()},
                {WeekData.MONDAY.name(), "Task for " + WeekData.MONDAY.name()}
        };
        String[][] schedule3 = {
                {WeekData.WEDNESDAY.name(), "Task for " + WeekData.WEDNESDAY.name()},
                {WeekData.SATURDAY.name(), "Task for " + WeekData.SATURDAY.name()}
        };
        String[][] schedule4 = {
                {WeekData.THURSDAY.name(), "Task for " + WeekData.THURSDAY.name()},
                {WeekData.WEDNESDAY.name(), "Task for " + WeekData.WEDNESDAY.name()}
        };
    Human mother = new Human("Kate", "Middletone", 54, 80, schedule1);
    Human father = new Human("Michael", "Kors", 56, 60, schedule2);
    Human child1 = new Human("Sergio", "Kors", 25, 90, schedule4);
    Human child2 = new Human("Alex", "Kors", 21, 90, schedule3);
    Human child3 = new Human("Jane", "Kors", 20, 80, schedule1);

    Family newFamily = new Family(mother,father);
    newFamily.addChild(child1);
    newFamily.addChild(child2);
    newFamily.addChild(child3);

    Pet newPet = new Pet(Species.DOG, "Chester");
    newPet.setAge(3);
    newPet.setTrickLevel(90);
    newPet.setHabits(new String[]{"eat", "drink", "sleep"});

    newFamily.setPet(newPet);
    }

    @Test
    void testToString() {
        System.out.println("Family class testing...");

    }
}