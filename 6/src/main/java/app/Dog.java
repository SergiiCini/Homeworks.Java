package app;

public class Dog extends Pet implements Foul{
    public Dog(String nickname, int age, int trickLevel, String[] habits){
        super(nickname,age, trickLevel, habits);
        this.species = Species.DOG;
    }
    @Override
    public void foul() {
        System.out.println("Я погрыз плинтус, гав-гав...");
    }

    @Override
    public void respond(String nickname) {
        System.out.printf("Привет, хозяин! Я - %s. Я соскучился!", nickname);
    }
}
