package app.domain;

import app.controller.FamilyController;

import java.text.ParseException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class PrintFamilyService {
    public static FamilyController familyController;

    public static void PrintFamilyService() throws ParseException {
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

        Woman mother1 = new Woman("Kate", "Middletone", "24/01/1954", 80, schedule1);
        Man father1 = new Man("Michael", "Kors", "18/12/1956", 60, schedule2);
        Woman mother2 = new Woman("Sara", "Cooper", "15/04/1954", 80, schedule1);
        Man father2 = new Man("Bob", "Cooper", "12/12/1956", 60, schedule2);
        Woman mother3 = new Woman("Anna", "Stone", "18/04/1954", 80, schedule1);
        Man father3 = new Man("Alex", "Stone", "16/04/1956", 60, schedule2);

        Fish pet1 = new Fish("Flaunder", 1, 20, new HashSet<>(Arrays.asList("eat", "swim", "sleep")));
        Dog pet2 = new Dog("Chester", 2, 60, new HashSet<>(Arrays.asList("eat", "walk", "sleep")));
        RoboCat pet3 = new RoboCat("R2D2", 99, 99, new HashSet<>(Arrays.asList("clean", "charge")));
        Family newFamily1 = familyController.createNewFamily(mother1, father1);
        Family newFamily2 = familyController.createNewFamily(mother2, father2);
        Family newFamily3 = familyController.createNewFamily(mother3, father3);
        familyController.addPet(0, pet1);
        familyController.addPet(0, pet2);
        familyController.addPet(1, pet3);

        familyController.bornChild(newFamily1, "Sergio", "Jane");
        familyController.bornChild(newFamily1, "Sam", "Samanta");
        familyController.bornChild(newFamily2, "Ivan", "Vera");

//        Print.TestFamily();
        System.out.println("*******************************************************************************");
        System.out.println("1. Checking getAllFamilies(): ");
        List<Family> allFamilies = familyController.getAllFamilies();
        System.out.printf("Number of families: %d", allFamilies.size());
        System.out.println("\n*******************************************************************************");

        System.out.println("2. Checking displayAllFamilies(): ");
        familyController.displayAllFamilies();
        System.out.println("*******************************************************************************");

        System.out.println("3. Checking getFamiliesBiggerThan(): ");
        //there are 5 people in our family
        familyController.getFamiliesBiggerThan(2);
        System.out.println("*******************************************************************************");

        System.out.println("4. Checking getFamiliesLessThan(): ");
        //there are 5 people in our family
        familyController.getFamiliesLessThan(3);
        System.out.println("*******************************************************************************");

        System.out.println("5. Checking countFamiliesWithMemberNumber(): ");
        //there are 5 people in our family
        familyController.countFamiliesWithMemberNumber(4);
        System.out.println("*******************************************************************************");

        System.out.println("6. Checking createNewFamily(): ");
        Woman mother = new Woman("Samanta", "Liberman", "14/01/1984", 80, schedule2);
        Man father = new Man("Charley", "Kostner", "12/04/1963", 90, schedule3);
        Family family = familyController.createNewFamily(mother, father);
        System.out.println(family.toString());
        System.out.println("*******************************************************************************");

        System.out.println("7. Checking deleteFamilyByIndex(): ");
        System.out.println("Family with index 1 was deleted? " + familyController.deleteFamilyByIndex(1));
        System.out.println("*******************************************************************************");

        System.out.println("8. Checking bornChild(): ");
        familyController.bornChild(family, "Anna", "Robert");
        System.out.println("*******************************************************************************");

        System.out.println("9. Checking adoptChild(): ");
        Man child = new Man("Muhamed", "Chaker", "01/01/1999", 55);
        Woman child4 = new Woman("Rebeka", "Fiore", "01/01/1990", 80);
        familyController.adoptChild(family, child);
        familyController.adoptChild(family, child4);
        System.out.println(family.getChildren());
        System.out.println("*******************************************************************************");

        System.out.println("10. Checking deleteAllChildrenOlderThen(): ");
        familyController.deleteAllChildrenOlderThen(5);
        System.out.println(familyController.getAllFamilies());
        System.out.println("*******************************************************************************");

        System.out.println("11. Checking count(): ");
        System.out.printf("There are %d families in our DB.", familyController.count());
        System.out.println("\n*******************************************************************************");

        System.out.println("12. Checking getFamilyById(): ");
        System.out.println( familyController.getFamilyById(2).toString());
        System.out.println("*******************************************************************************");

        System.out.println("13. Checking addPets(): ");
        familyController.addPet(1, pet1);
        familyController.addPet(1, pet2);
        familyController.addPet(0, pet3);
        System.out.println("*******************************************************************************");

        System.out.println("14. Checking getPets(): ");
        System.out.println(familyController.getPet(0));
        System.out.println(familyController.getPet(1));
        System.out.println(familyController.getPet(2));
        System.out.println("*******************************************************************************");

        System.out.println("15. Checking describeAge(): ");
        System.out.println(child.describeAge());



//        Print.GarbageCollectorInit();
    }
}
