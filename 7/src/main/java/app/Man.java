package app;

public final class Man extends Human {

    public Man(String name, String surname, int year, int iq) {
        super(name, surname, year, iq);
    }

    public Man(String name, String surname, int year, int iq, String[][] schedule) {
        super(name, surname, year, iq, schedule);
    }

    @Override
    public void greetPet() {
        System.out.printf("Привет, %s", family.getPet().getNickname());
    }

    public void repairCar() {
        System.out.println("Похоже пора заменить тормозные колонки...");
    }
}
