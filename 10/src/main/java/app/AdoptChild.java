package app;

import java.text.ParseException;

public class AdoptChild extends Human {

    public AdoptChild(String name, String surname, String birthDate, int iq) throws ParseException {
        super(name, surname, birthDate, iq);
    }

    @Override
    public void greetPet(int petIndex) {
        System.out.printf("Привет, %s, идем гулять!", family.getSomePet(petIndex).getNickname());
    }
}
