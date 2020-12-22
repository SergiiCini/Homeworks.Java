package app;

public class Print {
    public static void showHuman() {
        Human Michael = new Human();
        Michael.setName("Michael");
        Michael.setSurname("Karleone");
        Michael.setYear(1977);
        Michael.setIq(90);

        Human mother = new Human();
        mother.setName("Jane");
        Human father = new Human();
        father.setName("Vito");
        Family family = new Family(mother, father);
        family.setMother(mother);

        Pet pet = new Pet();
        pet.setSpecies("dog");
        pet.setNickname("Rock");
        pet.setAge(5);
        pet.setTrickLevel(75);
        pet.setHabits(new String[]{"eat", "drink", "sleep"});
        family.setPet(pet);
        System.out.println("*****************************************************************************************");
        System.out.println(Michael.toString());
    }

    public static void showPet() {
        Pet pet = new Pet();
        pet.setSpecies("dog");
        pet.setNickname("Rock");
        pet.setAge(5);
        pet.setTrickLevel(75);
        pet.setHabits(new String[]{"eat", "drink", "sleep"});
        System.out.println("*****************************************************************************************");
        System.out.println(pet.toString());
    }

    public static void showFamily() {
        Human mother = new Human();
        Human father = new Human();
        Human son = new Human();
        Human daughter = new Human();
        Pet pet = new Pet();
        mother.setName("Valentyna");
        mother.setSurname("Romaniuk");
        father.setName("Viktor");
        father.setSurname("Romaniuk");
        son.setName("Serhii");
        son.setSurname("Romaniuk");
        daughter.setName("Alona");
        daughter.setSurname("Romaniuk");
        Family myFamily = new Family(mother, father);
        myFamily.setChildren(new Human[]{son, daughter});
        myFamily.setPet(pet);
        pet.setSpecies("dog");
        pet.setNickname("Chester");
        pet.setAge(5);
        pet.setTrickLevel(99);
        pet.setHabits(new String[]{"eat", "drink", "sleep"});
        System.out.println("*****************************************************************************************");
        System.out.println(myFamily.toString());
    }

    public static void newHuman() {
        String[][] schedule1 = {
                {WeekData.SUNDAY.toString(), "Task for " + WeekData.SUNDAY.toString()},
                {WeekData.MONDAY.toString(), "Task for " + WeekData.MONDAY.toString()}
        };
        Human Chester = new Human("Chester", "Thompson", 1987, 90, schedule1);
        System.out.println("*****************************************************************************************");
        System.out.println(Chester);
    }

    public static void newFamily() {
        String[][] scheduleSon = {
                {WeekData.SUNDAY.toString(), "Task for " + WeekData.SUNDAY.toString()},
                {WeekData.MONDAY.toString(), "Task for " + WeekData.MONDAY.toString()}
        };
        String[][] scheduleDaughter1 = {
                {WeekData.WEDNESDAY.toString(), "Task for " + WeekData.WEDNESDAY.toString()},
                {WeekData.MONDAY.toString(), "Task for " + WeekData.MONDAY.toString()}
        };
        String[][] scheduleDaughter2 = {
                {WeekData.WEDNESDAY.toString(), "Task for " + WeekData.WEDNESDAY.toString()},
                {WeekData.SATURDAY.toString(), "Task for " + WeekData.SATURDAY.toString()}
        };
        Human mother = new Human("Jane", "Verno", 1963);
        Human father = new Human("Roberto", "Carlos", 1961);
        Human son1 = new Human("Charly", "Carlos", 1990, 92, scheduleSon);
        Human daughter1 = new Human("Marry", "Carlos", 1993, 90, scheduleDaughter1);
        Human daughter2 = new Human("Kate", "Carlos", 1996, 95, scheduleDaughter2);
        Family myNewFamily = new Family(mother, father);
        Pet pet = new Pet();
        pet.setSpecies("dog");
        pet.setNickname("Jack");
        pet.setAge(3);
        pet.setTrickLevel(95);
        myNewFamily.setPet(pet);
        System.out.println("*****************************************************************************************");
        mother.describePet();
        System.out.println("\n*****************************************************************************************");
        mother.greetPet();
        System.out.println("\n*****************************************************************************************");
        myNewFamily.addChild(son1);
        myNewFamily.addChild(daughter1);
        myNewFamily.addChild(daughter2);
        System.out.println("*****************************************************************************************");
        System.out.println(myNewFamily.toString());
        System.out.println("*****************************************************************************************");
        myNewFamily.deleteChild(1);
        System.out.println("\n*****************************************************************************************");
        System.out.printf("There are %d people in this family.", myNewFamily.countFamily());




    }
}
