package app;

public class Printing {
    public static void showHuman() {
        Human Michael = new Human();
        Michael.setName("Michael");
        Michael.setSurname("Karleone");
        Michael.setYear(1977);
        Michael.setIq(90);

        Human mother = new Human();
        mother.setName("Jane Karleone");
        Human father = new Human();
        father.setName("Vito Karleone");
        Family family = new Family(mother, father);
        family.setMother(mother);

        Pet pet = new Pet();
        pet.setSpecies("dog");
        pet.setNickname("Rock");
        pet.setAge(5);
        pet.setTrickLevel(75);
        pet.setHabits(new String[]{"eat", "drink", "sleep"});
        family.setPet(pet);
        System.out.println(Michael.toString());
        System.out.println(family.toString());
    }

    public static void showPet() {
        Pet pet = new Pet();
        pet.setSpecies("dog");
        pet.setNickname("Rock");
        pet.setAge(5);
        pet.setTrickLevel(75);
        pet.setHabits(new String[]{"eat", "drink", "sleep"});
        System.out.println(pet.toString());
    }

    public static void showFamily() {
        Human mother = new Human();
        Human father = new Human();
        Human son = new Human();
        Human daughter = new Human();
        Pet pet = new Pet();
        mother.setName("Valentyna Romaniuk");
        father.setName("Viktor Romaniuk");
        son.setName("Serhii Romaniuk");
        daughter.setName("Alona Kozeletska");
        Family myFamily = new Family(mother, father);
        myFamily.setChildren(new Human[]{son, daughter});
        myFamily.setPet(pet);
        pet.setSpecies("dog");
        pet.setNickname("Chester");
        pet.setAge(5);
        pet.setTrickLevel(99);
        pet.setHabits(new String[]{"eat", "drink", "sleep"});
        System.out.println(myFamily.toString());
    }
}
