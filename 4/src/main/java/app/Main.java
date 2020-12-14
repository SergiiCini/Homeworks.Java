package app;

public class Main {

    public static void main(String[] args) {
        showHuman();
        showPet();
    }

    public static void showHuman() {
        Human Michael = new Human();
        Michael.setName("Michael");
        Michael.setSurname("Karleone");
        Michael.setYear(1977);
        Michael.setIq(90);
        Michael.pet = new Pet();
        Michael.mother = new Human();
        Michael.mother.setName("Jane Karleone");
        Michael.father = new Human();
        Michael.father.setName("Vito Karleone");
        Michael.pet.setSpecies("dog");
        Michael.pet.setNickname("Rock");
        Michael.pet.setAge(5);
        Michael.pet.setTrickLevel(75);
        Michael.pet.setHabits(new String[]{"eat", "drink", "sleep"});
        System.out.println(Michael.toString());
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
}
