package app;

public class DomesticCat extends Pet implements Foul {

    public DomesticCat(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        this.species = Species.DOMESTIC_CAT;
    }

    @Override
    public void foul() {
        System.out.println("Я перегрызла зарядку от телефона зозяина, мяяяу...");
    }

    @Override
    public void respond(String nickname) {

    }
}
