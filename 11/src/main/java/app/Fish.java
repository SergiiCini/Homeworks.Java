package app;

import java.util.HashSet;

public class Fish extends Pet {

    public Fish(String nickname, int age, int trickLevel, HashSet<String> habits) {
        super(nickname, age, trickLevel, habits);
        this.species = Species.FISH;
    }

    @Override
    public void respond(String nickname) {

    }
}
