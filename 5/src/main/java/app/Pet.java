package app;

import java.util.Arrays;

public class Pet {
    private Species species;
    private String nickname;
    private int age;
    private int trickLevel;
    private String[] habits;

    Pet() {
    }

    Pet(Species species, String nickname) {
        this.species = species;
        this.nickname = nickname;
    }

    Pet(Species species, String nickname, int age, int trickLevel, String[] habits) {
        this.species = species;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
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
        if(trickLevel < 0 || trickLevel > 100){
            throw new IllegalArgumentException("Incorrect range, trickLevel should be from 0 to 100");
        }
        this.trickLevel = trickLevel;
    }

    public String[] getHabits() {
        return habits;
    }

    public void setHabits(String[] habits) {
        this.habits = habits;
    }

    public void est() {
        System.out.printf("Я кушаю!");
    }

    public void respond(String nickname) {
        System.out.printf("Привет, хозяин! Я - %s. Я соскучился!", nickname);
    }

    public void foul() {
        System.out.printf("Нужно хорошо замести следы...");
    }

    @Override
    public String toString() {
        return getSpecies() + "{" +
                "nickname='" + getNickname() + '\'' +
                ", age=" + age +
                ", trickLevel=" + getTrickLevel() +
                ", habits=" + Arrays.toString(habits) +
                '}';
    }
    protected void finalize() throws Throwable {
        System.out.println("Pet object was destroyed.");
    }
}
