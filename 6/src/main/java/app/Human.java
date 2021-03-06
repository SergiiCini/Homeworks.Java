package app;

import java.util.Arrays;

abstract public class Human {
    private String name;
    private String surname;
    private int year;
    private int iq;
    private String[][] schedule;
    protected Family family;

    public Human() {
    }

    public Human(String name, String surname, int year, int iq) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
    }

    public Human(String name, String surname, int year, int iq, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.schedule = schedule;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setIq(int iq) {
        if(iq < 0 || iq > 100){
            throw new IllegalArgumentException("Incorrect range, iq level should be from 0 to 100");
        }
        this.iq = iq;
    }

    public int getIq() {
        return iq;
    }

    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;
    }

    public String[][] getSchedule() {
        return schedule;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }


    abstract public void greetPet();

    public String checkTrickLevel() {
        return family.getPet().getTrickLevel() > 50 ? "очень хитрый" : "почти не хитрый";
    }

    public void describePet() {
        System.out.printf("У меня есть %s, ему %d лет, он %s\"", family.getPet().getSpecies(), family.getPet().getAge(), checkTrickLevel());
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year=" + year +
                ", iq=" + iq +
                ", schedule=" + Arrays.deepToString(schedule) +
                '}';
    }
    protected void finalize() throws Throwable {
        System.out.println("Human object was destroyed.");
    }

}

