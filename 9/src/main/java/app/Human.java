package app;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

abstract public class Human {
    private String name;
    private String surname;
    private long birthDate;
    private int iq;
    private HashMap<WeekData, String> schedule;
    protected Family family;

    public Human() {
    }

    public Human(String name, String surname, String birthday, int iq) throws ParseException {
        this.name = name;
        this.surname = surname;
        this.birthDate = stringToUnixTimeConvertor(birthday);
        this.iq = iq;
    }

    public Human(String name, String surname, String birthday, int iq, HashMap<WeekData, String> schedule) throws ParseException {
        this.name = name;
        this.surname = surname;
        this.birthDate= stringToUnixTimeConvertor(birthday);
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

    public void setYear(String birthday) throws ParseException {
        this.birthDate = stringToUnixTimeConvertor(birthday);
    }

    public long getYear() {
        return birthDate;
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

    public Instant describeAge(){
        long unixTime = Instant.now().getEpochSecond();
        Instant date = Instant.ofEpochSecond(unixTime);
        return date;
    }

    public long stringToUnixTimeConvertor(String birthday) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = dateFormat.parse(birthday);
        long unixTime = (long) date.getTime()/1000;
        return unixTime;
    }

    public String dateToUnixTimeConvertor(LocalDate birthdayDate){
        String birthday = birthdayDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return birthday;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
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
        return birthDate == human.birthDate && iq == human.iq && name.equals(human.name) && surname.equals(human.surname) && schedule.equals(human.schedule) && family.equals(human.family);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthDate, iq, schedule, family);
    }
}

