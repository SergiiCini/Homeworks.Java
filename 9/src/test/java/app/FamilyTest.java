package app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class FamilyTest {
    private Family newFamily;
    private Man child1;
    private Man child2;
    private Woman child3;
    private Man child4;

    @BeforeEach
    void createDataToTest() throws ParseException {
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

        Woman mother = new Woman("Kate", "Middletone", "16/04/1954", 80, schedule1);
        Man father = new Man("Michael", "Kors", "12/12/1956", 60, schedule2);
        child1 = new Man("Sergio", "Kors", "01/11/1998", 90, schedule4);
        child2 = new Man("Alex", "Kors", "16/04/2001", 90, schedule3);
        child3 = new Woman("Jane", "Kors", "14/08/2002", 80, schedule1);
        child4 = new Man("Jack", "Kors", "24/06/1994", 99, schedule4);

        newFamily = new Family(mother, father);
        newFamily.addChild(child1);
        newFamily.addChild(child2);
        newFamily.addChild(child3);

        Dog newPet = new Dog("Chester", 3, 90, new HashSet<>(Arrays.asList("eat", "drink", "sleep")));
        newFamily.addPet(newPet);
    }

    @Test
    void testPrinting() {
        System.out.println("Family class testing...");
        String expectedPrint =
                "Family:\n" +
                        "mother=Kate Middletone, \n" +
                        "father=Michael Kors, \n" +
                        "children:\n" +
                        "Human{name='Sergio', surname='Kors', birthDate=01/11/1998, iq=90};\n" +
                        "Human{name='Alex', surname='Kors', birthDate=16/04/2001, iq=90};\n" +
                        "Human{name='Jane', surname='Kors', birthDate=14/08/2002, iq=80};\n" +
                        "pet:\n" +
                        "[DOG{nickname='Chester', age=3, trickLevel=90, habits=[sleep, eat, drink]}]";
        assertEquals(expectedPrint, newFamily.toString());
    }

    @Test
    void testDeleteChildMethod() {
        System.out.println("DeleteChild by obj method testing...");
        int initialArrayLength = newFamily.getChildren().size();
        assertEquals(child1.getFamily(), newFamily);

        newFamily.deleteChildByObj(child1);
        int arrayAfterDeletingChild = newFamily.getChildren().size();
        assertEquals(arrayAfterDeletingChild, initialArrayLength - 1);

        newFamily.deleteChildByObj(child2);
        arrayAfterDeletingChild = newFamily.getChildren().size();
        assertEquals(arrayAfterDeletingChild, initialArrayLength - 2);
    }

    @Test
    void testDeleteChildByIdMethod(){
        System.out.println("DeleteChild method by id testing...");
        int initialArrayLength = newFamily.getChildren().size();
        assertEquals(child1.getFamily(), newFamily);

        newFamily.deleteChild(1);
        int arrayAfterDeletingChild = newFamily.getChildren().size();
        assertEquals(arrayAfterDeletingChild, initialArrayLength - 1);

        newFamily.deleteChild(0);
        arrayAfterDeletingChild = newFamily.getChildren().size();
        assertEquals(arrayAfterDeletingChild, initialArrayLength - 2);
    }

    @Test
    void testAddChildMethod() {
        System.out.println("AddChild method testing...");
        assertEquals(child1.getFamily(), newFamily);
        int initialArrayLength = newFamily.getChildren().size();
        newFamily.addChild(child4);
        assertEquals(child4.getFamily(), newFamily);
        assertEquals(newFamily.getChildren().size(), initialArrayLength + 1);
    }

    @Test
    void testCountFamilyMethod() {
        System.out.println("\nCountFamily method testing...");
        newFamily.addChild(child1);
        newFamily.addChild(child1);
        assertEquals(7, newFamily.countFamily());
        newFamily.deleteChild(1);
        assertEquals(6, newFamily.countFamily());
    }
}