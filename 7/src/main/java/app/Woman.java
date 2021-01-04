package app;

import java.util.HashMap;

public final class Woman extends Human {

    public Woman(String name, String surname, int year, int iq){
        super(name, surname, year, iq);
    }

    public Woman(String name, String surname, int year, int iq, HashMap<WeekData, String> schedule){
        super(name, surname, year, iq, schedule);
    }

    @Override
    public void greetPet() {
        System.out.printf("Привет, %s", family.getPet().getNickname());
    }

    public void makeup(){
        System.out.println("Сегодня особый день, пойдука я в салон красоты...");
    }
}
