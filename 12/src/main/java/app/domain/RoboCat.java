package app.domain;

import java.io.Serializable;
import java.util.HashSet;

public class RoboCat extends Pet implements Serializable {

    public RoboCat(String nickname, int age, int trickLevel, HashSet<String> habits) {
        super(nickname, age, trickLevel, habits);
        this.species = Species.ROBOCAT;
    }

    @Override
    public void respond(String nickname) {

    }
}
