package app;

import java.util.Arrays;

public class Pet {
    private String species;
    private String nickname;
    private int age;
    private int trickLevel;
    private String[] habits;

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getSpecies() {
        return species;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setTrickLevel(int trickLevel) {
        this.trickLevel = trickLevel;
    }

    public int getTrickLevel() {
        return trickLevel;
    }

    public void setHabits(String[] habits) {
        this.habits = habits;
    }

    public String[] getHabits() {
        return habits;
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
                ", trickLevel=" + trickLevel +
                ", habits=" + Arrays.toString(habits) +
                '}';
    }

    Pet() {
    }

    Pet(String species, String nickname) {
        this.species = species;
        this.nickname = nickname;
    }

    Pet(String species, String nickname, int age, int trickLevel, String[] habits) {
        this.species = species;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }


}
