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
        System.out.println("Ok!");
    }

    @Test
    void displayAllFamilies() {
        System.out.println("Testing displayAllFamilies():");
        familyController.deleteFamilyByIndex(0);
        assertEquals(2, familyController.getAllFamilies().size());
        System.out.println("Ok!");
    }

    @Test
    void getFamiliesBiggerThan() {
        System.out.println("Testing getFamiliesBiggerThan():");
        family3 = familyController.getAllFamilies().get(2);
        List<Family> familyList = new ArrayList<>();
        familyList.add(family3);
        List<Family> filteredFamilies = familyController.getFamiliesBiggerThan(5);
        assertEquals(familyList, filteredFamilies);
        System.out.println("Ok!");
    }

    @Test
    void getFamiliesLessThan() {
        System.out.println("Testing getFamiliesLessThan():");
        family2 = familyController.getAllFamilies().get(1);
        List<Family> familyList = new ArrayList<>();
        familyList.add(family2);
        List<Family> filteredFamilies = familyController.getFamiliesLessThan(4);
        assertEquals(familyList, filteredFamilies);
        System.out.println("Ok!");
    }

    @Test
    void countFamiliesWithMemberNumber() {
        System.out.println("Testing countFamiliesWithMemberNumber():");
        assertEquals(1, familyController.countFamiliesWithMemberNumber(6));
        System.out.println("Ok!");
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
        System.out.println("Ok!");
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
        System.out.println("Ok!");
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
        System.out.println("Ok!");
    }

    @Test
    void adoptChild() {
        System.out.println("Testing adoptChild():");
        Family family1 = familyController.getFamilyById(0);
        Man child = new Man("Muhamed", "Chaker", 1985, 55);
        familyController.adoptChild(family1, child);
        assertTrue(family1.getChildren().contains(child));
        System.out.println("Ok!");
    }

    @Test
    void deleteAllChildrenOlderThen() {
        System.out.println("Testing deleteAllChildrenOlderThen():");
        ArrayList<Family> families = (ArrayList<Family>) familyController.getAllFamilies();
        // there is only one child in family3 that was born in 1987, so now he is 34 y.o..
        Family family3 = families.get(2);
        //initial number of children are 4;
        int initialChildrenAm = family3.getChildren().size();
        // deleting children older then 33 y.o.
        familyController.deleteAllChildrenOlderThen(33);
        //amount of children after deleting are 3;
        int newChildrenAm = family3.getChildren().size();
        assertEquals(initialChildrenAm - 1, newChildrenAm);
        System.out.println("Ok!");
    }

    @Test
    void count() {
        System.out.println("Testing count():");
        ArrayList<Family> families = (ArrayList<Family>) familyController.getAllFamilies();
        Family family3 = families.get(2);
        //there are 3 families.
        int initialFamiliesAm = families.size();
        // let's delete the family3 (index of this family is 2)
        familyController.deleteFamilyByIndex(2);
        //there are 2 families after deleting family with index 2 (family3);
        int newFamiliesAm = families.size();
        //let's check that the number of families was decreased by 1 after deleting
        assertEquals(initialFamiliesAm - 1, newFamiliesAm);
        //let's check that there isn't family3 in families ArrayList.
        assertFalse(families.contains(family3));
        System.out.println("Ok!");
    }

    @Test
    void getFamilyById() {
        System.out.println("Testing getFamilyById():");
        ArrayList<Family> families = (ArrayList<Family>) familyController.getAllFamilies();
        Family expectFamily1 = families.get(0);
        Family actualFamily1 = familyController.getFamilyById(0);
        assertEquals(expectFamily1, actualFamily1);

        Family expectFamily3 = families.get(2);
        Family actualFamily3 = familyController.getFamilyById(2);
        assertEquals(expectFamily3, actualFamily3);
        System.out.println("Ok!");
    }

    @Test
    void getPet() {
        System.out.println("Testing getPet():");
        ArrayList<Family> families = (ArrayList<Family>) familyController.getAllFamilies();

        ArrayList<Pet> expectFamily1Pets = families.get(0).getPet();
        ArrayList<Pet> actualFamily1Pets = familyController.getPet(0);
        assertEquals(expectFamily1Pets, actualFamily1Pets);

        ArrayList<Pet> expectFamily2Pets = families.get(1).getPet();
        ArrayList<Pet> actualFamily2Pets = familyController.getPet(1);
        assertEquals(expectFamily2Pets, actualFamily2Pets);
        System.out.println("Ok!");
    }

    @Test
    void addPet() {
        System.out.println("Testing addPet():");
        Dog rich = new Dog("Rich", 5, 60, new HashSet<>(Arrays.asList("eat", "walk", "sleep")));
        ArrayList<Pet> family3Pets = familyController.getPet(2);
        //No pets in this family!
        int initialFamily3PetsNumb = family3Pets.size();
        //0
        familyController.addPet(2, rich);
        assertTrue(family3Pets.contains(rich));
        assertEquals(initialFamily3PetsNumb+1, family3Pets.size());
        System.out.println("Ok!");
    }
}