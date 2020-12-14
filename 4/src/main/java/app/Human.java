package app;

public class Human {
    private String name;
    private String surname;
    private int year;
    private int iq;
    public Human mother;
    public Human father;
    public Pet pet;
    private String[][] schedule;

    public Human() {
    }

    public Human(String name, String surname, int year, Human mother, Human father) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.mother = mother;
        this.father = father;
    }

    public Human(String name, String surname, int year, Human mother, Human father, int iq, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.schedule = schedule;
        this.mother = mother;
        this.father = father;
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
        this.iq = iq;
    }

    public int getIq() {
        return iq;
    }

    public Pet getPet() {
        return pet;
    }

    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;
    }

    public String[][] getSchedule() {
        return schedule;
    }


    public void greetPet(String petName) {
        System.out.printf("Привет, %s", pet.getNickname());
    }

    public String checkTrickLevel() {
        return pet.getTrickLevel() <= 50 ? "очень хитрый" : "почти не хитрый";
    }

    public void describePet(String petSpecies, int petAge, int tricksLevel) {
        System.out.printf("У меня есть %s, ему %d лет, он %s\"", pet.getSpecies(), pet.getAge(), pet.getTrickLevel());
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year=" + year +
                ", iq=" + iq +
                ", mother=" + mother.name +
                ", father=" + father.name +
                ", pet=" + pet +
                '}';
    }


}

