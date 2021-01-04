package app;

import java.util.HashSet;
import java.util.Objects;

abstract class Pet {
    Species species;
    String nickname;
    int age;
    int trickLevel;
    private HashSet<String> habits;

    public Pet() {
    }

    public Pet(String nickname) {
        this.nickname = nickname;
    }

    public Pet(String nickname, int age, int trickLevel, HashSet<String> habits) {
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
        this.species = Species.UNKNOWN;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTrickLevel() {
        return trickLevel;
    }

    public void setTrickLevel(int trickLevel) {
        if (trickLevel < 0 || trickLevel > 100) {
            throw new IllegalArgumentException("Incorrect range, trickLevel should be from 0 to 100");
        }
        this.trickLevel = trickLevel;
    }

    public HashSet<String> getHabits() {
        return habits;
    }

    public void setHabits(HashSet<String> habits) {
        this.habits = habits;
    }

    public void eat() {
        System.out.printf("Я кушаю!");
    }

    abstract public void respond(String nickname);

    @Override
    public String toString() {
        return getSpecies() + "{" +
                "nickname='" + getNickname() + '\'' +
                ", age=" + age +
                ", trickLevel=" + getTrickLevel() +
                ", habits=" + habits.toString() +
                '}';
    }

    protected void finalize() throws Throwable {
        System.out.println("Pet object was destroyed.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet)) return false;
        Pet pet = (Pet) o;
        return age == pet.age && trickLevel == pet.trickLevel && species == pet.species && nickname.equals(pet.nickname) && habits.equals(pet.habits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(species, nickname, age, trickLevel, habits);
    }
}
