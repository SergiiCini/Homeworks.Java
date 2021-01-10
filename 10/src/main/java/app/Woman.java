package app;

import java.text.ParseException;
import java.util.HashMap;

public final class Woman extends Human {

    public Woman(String name, String surname, String birthday, int iq) throws ParseException {
        super(name, surname, birthday, iq);
    }

    public Woman(String name, String surname, String birthday, int iq, HashMap<WeekData, String> schedule) throws ParseException {
        super(name, surname, birthday, iq, schedule);
    }

    @Override
    public void greetPet(int petIndex) {
        System.out.printf("Привет, %s", family.getSomePet(petIndex).getNickname());
    }

    public void makeup(){
        System.out.println("Сегодня особый день, пойдука я в салон красоты...");
    }
}
