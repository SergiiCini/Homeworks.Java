package app;

import java.text.ParseException;
import java.util.HashMap;

public final class Woman extends Human {

    private final String gender;

    public Woman(String name, String surname, String birthday, int iq) throws ParseException {
        super(name, surname, birthday, iq);
        this.gender = "woman";
    }

    public Woman(String name, String surname, String birthday, int iq, HashMap<WeekData, String> schedule) throws ParseException {
        super(name, surname, birthday, iq, schedule);
        this.gender = "woman";
    }

    @Override
    public void greetPet(int petIndex) {
        System.out.printf("Привет, %s", family.getSomePet(petIndex).getNickname());
    }

    public void makeup() {
        System.out.println("Сегодня особый день, пойдука я в салон красоты...");
    }

    public String getGender() {
        return gender;
    }
}
