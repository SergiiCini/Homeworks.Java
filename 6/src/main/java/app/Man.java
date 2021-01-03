package app;

public final class Man extends Human {
    private Family family;

    public Man (String name, String surname, int year) {
        super(name, surname, year);
    }

    @Override
    public void greetPet() {
        System.out.printf("Привет, %s", family.getPet().getNickname());
    }

    public void repairCar(){
        System.out.println("Похоже пора заменить тормозные колонки...");
    }
}
