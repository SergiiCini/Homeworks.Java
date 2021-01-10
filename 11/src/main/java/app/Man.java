package app;

import java.text.ParseException;
import java.util.HashMap;

public final class Man extends Human {

    public Man(String name, String surname, String birthday, int iq) throws ParseException {
        super(name, surname, birthday, iq);
    }

    public Man(String name, String surname, String birthday, int iq, HashMap<WeekData, String> schedule) throws ParseException {
        super(name, surname, birthday, iq, schedule);
    }

    @Override

    public void greetPet(int petIndex) {
        System.out.printf("Привет, %s", family.getSomePet(petIndex).getNickname());
    }

    public void repairCar() {
        System.out.println("Похоже пора заменить тормозные колонки...");
    }
}
