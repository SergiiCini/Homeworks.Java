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
        familyController.deleteFamilyByIndex(0);
        assertEquals(2, familyController.getAllFamilies().size());
    }

    @Test
    void getFamiliesBiggerThan() {
        family3 = familyController.getFamilyById(2);
        List<Family> filteredFamilies = familyController.getFamiliesBiggerThan(5);
        System.out.println(family3);
        assertEquals(filteredFamilies, family3);
    }

    @Test
    void getFamiliesLessThan() {
    }

    @Test
    void countFamiliesWithMemberNumber() {
    }

    @Test
    void createNewFamily() {
    }

    @Test
    void deleteFamilyByIndex() {
    }

    @Test
    void bornChild() {
    }

    @Test
    void adoptChild() {
    }

    @Test
    void deleteAllChildrenOlderThen() {
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