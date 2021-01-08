package app;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

abstract public class Human {
    private String name;
    private String surname;
    private int year;
    private int iq;
    private HashMap<WeekData, String> schedule;
    protected Family family;

    public Human() {
    }

    public Human(String name, String surname, int year, int iq) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
    }

    public Human(String name, String surname, int year, int iq, HashMap<WeekData, String> schedule) {
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
        if (iq < 0 || iq > 100) {
            throw new IllegalArgumentException("Incorrect range, iq level should be from 0 to 100");
        }
        this.iq = iq;
    }

    public int getIq() {
        return iq;
    }

    public void setSchedule(HashMap<WeekData, String> schedule) {
        this.schedule = schedule;
    }

    public HashMap<WeekData, String> getSchedule() {
        return schedule;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

//    abstract public void greetPet();

    abstract public void greetPet(int petIndex);

    public String checkTrickLevel(int petIndex) {
        Pet pet = family.getPet().get(petIndex);
        return pet.getTrickLevel() > 50 ? "очень хитрый" : "почти не хитрый";
    }

    public void describePet(int petIndex) {
        System.out.printf("У меня есть %s, ему %d лет, он %s\"", family.getSomePet(petIndex).getSpecies(), family.getSomePet(petIndex).getAge(), checkTrickLevel(petIndex));
    }

    public String scheduleToDisplay() {
        HashMap<WeekData, String> personalSchedule = new HashMap<>();
        personalSchedule.putAll(schedule);
        String scheduleString = "[";
        for (Map.Entry<WeekData, String> entry : personalSchedule.entrySet()) {
            scheduleString = scheduleString + "[" + entry.getKey() + ", " + entry.getValue() + "]" + ", ";
        }
        scheduleString = scheduleString.substring(0, scheduleString.length() - 2);
        scheduleString = scheduleString + "]";
        return scheduleString;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year=" + year +
                ", iq=" + iq +
//                ", schedule=" + scheduleToDisplay() +
                '}';
    }

    protected void finalize() throws Throwable {
        System.out.println("Human object was destroyed.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human human = (Human) o;
        return year == human.year && iq == human.iq && name.equals(human.name) && surname.equals(human.surname) && schedule.equals(human.schedule) && family.equals(human.family);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, year, iq, schedule, family);
    }
}

