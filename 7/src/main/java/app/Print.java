package app;

import java.util.Arrays;

public class Print {
    public static void showHuman() {
        Man Michael = new Man("Michael", "Karleone", 1987, 90);
        Woman mother = new Woman("Jane", "Karleone", 1963, 95);
        Woman father = new Woman("Vito", "Karleone", 1961, 99);
        Family family = new Family(mother, father);
        family.setMother(mother);

        DomesticCat pet = new DomesticCat("Rock", 3, 55, new String[]{"eat", "drink", "sleep"});
        family.setPet(pet);
        System.out.println("*****************************************************************************************");
        System.out.println(Michael.toString());
    }

    public static void showPet() {
        Dog pet = new Dog("Rock", 5, 75, new String[]{"eat", "drink", "sleep"});
        System.out.println("*****************************************************************************************");
        System.out.println(pet.toString());
    }

    public static void showFamily() {
        Woman mother = new Woman("Valentyna", "Romaniuk", 1963, 95);
        Man father = new Man("Viktor", "Romaniuk", 1961, 95);
        Man son = new Man("Serhii", "Romaniuk", 1987, 95);
        Woman daughter = new Woman("Alona", "Romaniuk", 1990, 90);
        Dog pet = new Dog("Chester", 5, 99, new String[]{"eat", "drink", "sleep"});

        Family myFamily = new Family(mother, father);
        myFamily.setChildren(new Human[]{son, daughter});
        myFamily.setPet(pet);

        System.out.println("*****************************************************************************************");
        System.out.println(myFamily.toString());
    }

    public static void newHuman() {
        String[][] schedule1 = {
                {WeekData.SUNDAY.name(), "Task for " + WeekData.SUNDAY.name()},
                {WeekData.MONDAY.name(), "Task for " + WeekData.MONDAY.name()}
        };
        Man Chester = new Man("Chester", "Thompson", 1987, 90, schedule1);
        System.out.println("*****************************************************************************************");
        System.out.println(Chester);
    }

    public static void newFamily() {
        String[][] scheduleSon = {
                {WeekData.SUNDAY.name(), "Task for " + WeekData.SUNDAY.name()},
                {WeekData.MONDAY.name(), "Task for " + WeekData.MONDAY.name()}
        };
        String[][] scheduleDaughter1 = {
                {WeekData.WEDNESDAY.name(), "Task for " + WeekData.WEDNESDAY.name()},
                {WeekData.MONDAY.name(), "Task for " + WeekData.MONDAY.name()}
        };
        String[][] scheduleDaughter2 = {
                {WeekData.WEDNESDAY.name(), "Task for " + WeekData.WEDNESDAY.name()},
                {WeekData.SATURDAY.name(), "Task for " + WeekData.SATURDAY.name()}
        };
        Woman mother = new Woman("Jane", "Verno", 1963, 90);
        Man father = new Man("Roberto", "Carlos", 1961, 93);
        Man son1 = new Man("Charly", "Carlos", 1990, 92, scheduleSon);
        Woman daughter1 = new Woman("Marry", "Carlos", 1993, 90, scheduleDaughter1);
        Woman daughter2 = new Woman("Kate", "Carlos", 1996, 95, scheduleDaughter2);
        Family myNewFamily = new Family(mother, father);
        RoboCat pet = new RoboCat("Jack", 3, 95, new String[] {"clean", "clean", "clean"});

        myNewFamily.setPet(pet);
        daughter1.makeup();
        System.out.println("*****************************************************************************************");
        mother.describePet();
        System.out.println("\n*****************************************************************************************");
        father.greetPet();
        System.out.println("\n*****************************************************************************************");
        myNewFamily.addChild(son1);
        myNewFamily.addChild(daughter1);
        myNewFamily.addChild(daughter2);
        System.out.println("*****************************************************************************************");
        System.out.println(myNewFamily.toString());
        System.out.println("*****************************************************************************************");
//        myNewFamily.deleteChild(1);
        myNewFamily.deleteChildByObj(daughter2);
        System.out.println("\n*****************************************************************************************");
        System.out.printf("There are %d people in this family.", myNewFamily.countFamily());
        System.out.println("\n*****************************************************************************************");
    }
    public static void TestFamily(){
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
        Woman mother1 = new Woman("Kate", "Middletone", 54, 80, schedule1);
        Man father1 = new Man("Michael", "Kors", 56, 60, schedule2);
        Man child1 = new Man("Sergio", "Kors", 25, 90, schedule4);
        Man child2 = new Man("Alex", "Kors", 21, 90, schedule3);
        Woman child3 = new Woman("Jane", "Kors", 20, 80, schedule1);

        Family newFamily = new Family(mother1,father1);
        newFamily.addChild(child1);
        newFamily.addChild(child2);
        newFamily.addChild(child3);

        Pet newPet = new Fish("Flaunder", 1, 20, new String[]{"eat", "swim", "sleep"});
        newFamily.setPet(newPet);
        System.out.println(newFamily.toString());
    }
    public static void GarbageCollectorInit(){
        Woman mother = new Woman("Ann", "Cini", 1992, 85);
        Man father = new Man("Serg", "Cini", 1987, 99);
        for(int i = 0; i < 1000000; i++){
            new Family(mother, father);
        }
    }
}
