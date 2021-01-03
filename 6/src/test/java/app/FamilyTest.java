package app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FamilyTest {
    private Family newFamily;
    private Man child1;
    private Man child2;
    private Woman child3;
    private Man child4;

    @BeforeEach
    void createDataToTest() {
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
        Woman mother = new Woman("Kate", "Middletone", 54, 80, schedule1);
        Man father = new Man("Michael", "Kors", 56, 60, schedule2);
        child1 = new Man("Sergio", "Kors", 25, 90, schedule4);
        child2 = new Man("Alex", "Kors", 21, 90, schedule3);
        child3 = new Woman("Jane", "Kors", 20, 80, schedule1);
        child4 = new Man("Jack", "Kors", 28, 99, schedule4);

        newFamily = new Family(mother, father);
        newFamily.addChild(child1);
        newFamily.addChild(child2);
        newFamily.addChild(child3);

        Dog newPet = new Dog("Chester", 3, 90, new String[]{"eat", "drink", "sleep"});
        newFamily.setPet(newPet);
    }

    @Test
    void testPrinting() {
        System.out.println("Family class testing...");
        String expectedPrint =
                "Family:\n" +
                        "mother=Kate Middletone, \n" +
                        "father=Michael Kors, \n" +
                        "children:\n" +
                        "Human{name='Sergio', surname='Kors', year=25, iq=90, schedule=[[THURSDAY, Task for THURSDAY], [WEDNESDAY, Task for WEDNESDAY]]};\n" +
                        "Human{name='Alex', surname='Kors', year=21, iq=90, schedule=[[WEDNESDAY, Task for WEDNESDAY], [SATURDAY, Task for SATURDAY]]};\n" +
                        "Human{name='Jane', surname='Kors', year=20, iq=80, schedule=[[SUNDAY, Task for SUNDAY], [MONDAY, Task for MONDAY]]};, \n" +
                        "pet:\n" +
                        "DOG{nickname='Chester', age=3, trickLevel=90, habits=[eat, drink, sleep]}";
        assertEquals(newFamily.toString(), expectedPrint);
    }

    @Test
    void testDeleteChildMethod() {
        System.out.println("DeleteChild by obj method testing...");
        int initialArrayLength = newFamily.getChildren().length;
        assertEquals(child1.getFamily(), newFamily);

        newFamily.deleteChildByObj(child1);
        int arrayAfterDeletingChild = newFamily.getChildren().length;
        assertEquals(arrayAfterDeletingChild, initialArrayLength - 1);

        newFamily.deleteChildByObj(child2);
        arrayAfterDeletingChild = newFamily.getChildren().length;
        assertEquals(arrayAfterDeletingChild, initialArrayLength - 2);
    }

    @Test
    void testDeleteChildByIdMethod(){
        System.out.println("DeleteChild method by id testing...");
        int initialArrayLength = newFamily.getChildren().length;
        assertEquals(child1.getFamily(), newFamily);

        newFamily.deleteChild(1);
        int arrayAfterDeletingChild = newFamily.getChildren().length;
        assertEquals(arrayAfterDeletingChild, initialArrayLength - 1);

        newFamily.deleteChild(0);
        arrayAfterDeletingChild = newFamily.getChildren().length;
        assertEquals(arrayAfterDeletingChild, initialArrayLength - 2);
    }

    @Test
    void testAddChildMethod() {
        System.out.println("AddChild method testing...");
        assertEquals(child1.getFamily(), newFamily);
        int initialArrayLength = newFamily.getChildren().length;
//        System.out.printf("Initial children array length are: %d", initialArrayLength);
        newFamily.addChild(child4);
        assertEquals(child4.getFamily(), newFamily);
        assertEquals(newFamily.getChildren().length, initialArrayLength + 1);
    }

    @Test
    void testCountFamilyMethod() {
        System.out.println("\nCountFamily method testing...");
        newFamily.addChild(child1);
        newFamily.addChild(child1);
//        System.out.println("NewFamily amount is: " + newFamily.countFamily());
        assertEquals(7, newFamily.countFamily());

        newFamily.deleteChild(1);
        assertEquals(6, newFamily.countFamily());
    }
}