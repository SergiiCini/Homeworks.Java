package app.domain;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

abstract public class Human {
    private String name;
    private String surname;
    private long birthDate;
    private int iq;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human human = (Human) o;
        return birthDate == human.birthDate && iq == human.iq && Objects.equals(name, human.name) && Objects.equals(surname, human.surname) && Objects.equals(schedule, human.schedule) && Objects.equals(family, human.family) && Objects.equals(gender, human.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthDate, iq, schedule, family, gender);
    }

    private HashMap<WeekData, String> schedule;
    protected Family family;
    private String gender;

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
        this.birthDate = stringToUnixTimeConvertor(birthday);
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

    public String getGender(){
        return gender;
    }

    abstract public void greetPet(int petIndex);

    public String checkTrickLevel(int petIndex) {
        Pet pet = family.getPet().get(petIndex);
        return pet.getTrickLevel() > 50 ? "очень хитрый" : "почти не хитрый";
    }

    public void describePet(int petIndex) {
        System.out.printf("У меня есть %s, ему %d лет, он %s\"", family.getSomePet(petIndex).getSpecies(), family.getSomePet(petIndex).getAge(), checkTrickLevel(petIndex));
    }

    public String scheduleToDisplay() {
        if(schedule == null || schedule.size() == 0) return "null";
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

    public String describeAge() {
        String age;
        LocalDate dateOfBirth = unixTimeToLocalDateConverter(birthDate);
        Period period = Period.between(dateOfBirth, LocalDate.now());
        age =
                name + " " + surname + " lived " + period.getYears() + " years "
                        + period.getMonths() + " months and " + period.getDays() + " days.";
        return age;
    }

    public long stringToUnixTimeConvertor(String birthday) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = dateFormat.parse(birthday);
        return date.getTime();
    }

    public String dateToUnixTimeConvertor(LocalDate birthdayDate) {
        return birthdayDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

    }

    public LocalDate unixTimeToLocalDateConverter(long unixTime) {
        return new Timestamp(unixTime).toLocalDateTime().toLocalDate();
    }

    public String unixTimeToStringConverter(long unixTime) {
        Date birthDay = new java.util.Date(unixTime);
        SimpleDateFormat getYear = new java.text.SimpleDateFormat("dd/MM/yyyy");
        return getYear.format(birthDay);
    }

    public int getBirthYear(Date date) {
        SimpleDateFormat getYear = new java.text.SimpleDateFormat("yyyy");
        String formatedToStringYear = getYear.format(date);
        return Integer.parseInt(formatedToStringYear);
    }

    public String prettyFormat(){
        return "{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + unixTimeToStringConverter(birthDate) +
                ", iq=" + iq +
                ", schedule=" + scheduleToDisplay() +
                '}';
    }

    @Override
    public String toString() {
        return prettyFormat();
    }

    protected void finalize() throws Throwable {
        System.out.println("Human object was destroyed.");
    }

}

