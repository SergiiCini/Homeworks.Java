package app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class FamilyServiceTest {
    private FamilyController familyController;
    Family family1, family2, family3;

    @BeforeEach
    void createDataBeforeTest() {
        familyController = new FamilyController();

        // Just create Family1 to operate.
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

        Woman mother1 = new Woman("Kate", "Middletone", 1954, 80, schedule1);
        Man father1 = new Man("Michael", "Kors", 1956, 60, schedule2);
        Woman mother2 = new Woman("Sara", "Cooper", 1954, 80, schedule1);
        Man father2 = new Man("Bob", "Cooper", 1956, 60, schedule2);
        Woman mother3 = new Woman("Anna", "Stone", 1954, 80, schedule1);
        Man father3 = new Man("Alex", "Stone", 1956, 60, schedule2);
        Woman child1 = new Woman("Kira", "Stone", 1990, 80);
        Man child2 = new Man("Monika", "Stone", 1987, 60);

        Fish pet1 = new Fish("Flaunder", 1, 20, new HashSet<>(Arrays.asList("eat", "swim", "sleep")));
        Dog pet2 = new Dog("Chester", 2, 60, new HashSet<>(Arrays.asList("eat", "walk", "sleep")));
        RoboCat pet3 = new RoboCat("R2D2", 99, 99, new HashSet<>(Arrays.asList("clean", "charge")));
        Family family1 = familyController.createNewFamily(mother1, father1);
        Family family2 = familyController.createNewFamily(mother2, father2);
        Family family3 = familyController.createNewFamily(mother3, father3);
        family3.addChild(child1);
        family3.addChild(child2);
        familyController.addPet(0, pet1);
        familyController.addPet(0, pet2);
        familyController.addPet(1, pet3);

        familyController.bornChild(family1, "Sergio", "Jane");
        familyController.bornChild(family1, "Mark", "Sara");
        familyController.bornChild(family3, "Nick", "Marta");
        familyController.bornChild(family3, "ALex", "Sofia");
        familyController.bornChild(family2, "Ivan", "Vera");
    }

    @Test
    void getAllFamilies() {
        System.out.println("Testing getAllFamilies():");
        assertEquals(3, familyController.getAllFamilies().size());
    }

    @Test
    void displayAllFamilies() {
        System.out.println("Testing displayAllFamilies():");
        familyController.deleteFamilyByIndex(0);
        assertEquals(2, familyController.getAllFamilies().size());
    }

    @Test
    void getFamiliesBiggerThan() {
        System.out.println("Testing getFamiliesBiggerThan():");
        family3 = familyController.getAllFamilies().get(2);
        List<Family> familyList = new ArrayList<>();
        familyList.add(family3);
        List<Family> filteredFamilies = familyController.getFamiliesBiggerThan(5);
        assertEquals(familyList, filteredFamilies);
    }

    @Test
    void getFamiliesLessThan() {
        System.out.println("Testing getFamiliesLessThan():");
        family2 = familyController.getAllFamilies().get(1);
        List<Family> familyList = new ArrayList<>();
        familyList.add(family2);
        List<Family> filteredFamilies = familyController.getFamiliesLessThan(4);
        assertEquals(familyList, filteredFamilies);
    }

    @Test
    void countFamiliesWithMemberNumber() {
        System.out.println("Testing countFamiliesWithMemberNumber():");
        assertEquals(1, familyController.countFamiliesWithMemberNumber(6));
    }

    @Test
    void createNewFamily() {
        System.out.println("Testing createNewFamily():");
        HashMap<WeekData, String> schedule3 = new HashMap<>();
        schedule3.put(WeekData.WEDNESDAY, "Task for " + WeekData.WEDNESDAY.name());
        schedule3.put(WeekData.SATURDAY, "Task for " + WeekData.SATURDAY.name());

        HashMap<WeekData, String> schedule4 = new HashMap<>();
        schedule4.put(WeekData.THURSDAY, "Task for " + WeekData.THURSDAY.name());
        schedule4.put(WeekData.WEDNESDAY, "Task for " + WeekData.WEDNESDAY.name());

        Woman mother = new Woman("Kate", "Middletone", 1954, 80, schedule3);
        Man father = new Man("Michael", "Kors", 1956, 60, schedule4);
        Family newFamily = familyController.createNewFamily(mother, father);
        assertTrue(familyController.getAllFamilies().contains(newFamily));
    }

    @Test
    void deleteFamilyByIndex() {
        System.out.println("Testing deleteFamilyByIndex():");
        ArrayList<Family> families = (ArrayList<Family>) familyController.getAllFamilies();
        int familiesAmount = families.size();
        System.out.println("Initial number of families: " + familiesAmount);
        familyController.deleteFamilyByIndex(1);
        int newFamiliesAmount = families.size();
        assertEquals(2, newFamiliesAmount);

        familyController.deleteFamilyByIndex(0);
        newFamiliesAmount = families.size();
        assertEquals(1, newFamiliesAmount);
    }

    @Test
    void bornChild() {
        System.out.println("Testing bornChild():");
        Family family2 = familyController.getAllFamilies().get(1);
        ArrayList<Family> families = (ArrayList<Family>) familyController.getAllFamilies();
        ArrayList<Human> children = family2.getChildren();
        int initialChildrenAm = children.size();
        familyController.bornChild(family2, "Antonio", "Lara");
        int newChildrenAm = children.size();
        assertEquals(initialChildrenAm + 1, newChildrenAm);
    }

    @Test
    void adoptChild() {
        System.out.println("Testing adoptChild():");
        Family family1 = familyController.getFamilyById(0);
        Man child = new Man("Muhamed", "Chaker", 1985, 55);
        familyController.adoptChild(family1, child);
        assertTrue(family1.getChildren().contains(child));
    }

    @Test
    void deleteAllChildrenOlderThen() {
        // there is a child in family3 that was born in 1987, so now he is 34.
        Man child = new Man("Monika", "Stone", 1987, 60);

        ArrayList<Family> families = (ArrayList<Family>) familyController.getAllFamilies();
        Family family3 = families.get(2);
        System.out.println(family3);
        assertTrue(family3.getChildren().contains(child));
        familyController.deleteAllChildrenOlderThen(33);
        System.out.println(family3);
//        assertFalse(family3.getChildren().contains(child));
    }

    @Test
    void count() {
    }

    @Test
    void getFamilyById() {
    }

    @Test
    void getPet() {
    }

    @Test
    void addPet() {
    }
}