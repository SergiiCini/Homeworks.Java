package app;

import java.util.HashMap;

public final class Man extends Human {

    public Man(String name, String surname, int year, int iq) {
        super(name, surname, year, iq);
    }

    public Man(String name, String surname, int year, int iq, HashMap<WeekData, String> schedule) {
        super(name, surname, year, iq, schedule);
    }

    @Override

    public void greetPet(int petIndex) {
        System.out.printf("Привет, %s", family.getSomePet(petIndex).getNickname());
    }

    public void repairCar() {
        System.out.println("Похоже пора заменить тормозные колонки...");
    }
}
