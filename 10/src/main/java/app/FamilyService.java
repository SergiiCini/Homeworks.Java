package app;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


public class FamilyService {
    static FamilyDao familyDao;

    public FamilyService() {
        familyDao = new CollectionFamilyDao();
    }

    public List<Family> getAllFamilies() {
        return familyDao.getAllFamilies();
    }

    public <T> void printData(List<T> data) {
        for (T item : data) {
            System.out.println(item);
        }
    }

    public void displayAllFamilies() {
        List<Family> allFamilies = familyDao.getAllFamilies();
        if (allFamilies.size() == 0) {
            System.out.println("Family doesn't exist!");
        } else {
            printData(allFamilies);
        }
    }

    public Optional<List<Family>> getFamiliesBiggerThan(int numberOfFamilyMembers) {
        List<Family> allFamilies = familyDao.getAllFamilies();
        Optional<List<Family>> filteredFamilies = Optional.of(allFamilies
                .stream()
                .filter(family -> family.countFamily() > numberOfFamilyMembers)
                .collect(Collectors.toList())
        );
        printData(filteredFamilies.get());
        return filteredFamilies;
    }

    public Optional<List<Family>> getFamiliesLessThan(int numberOfFamilyMembers) {
        List<Family> allFamilies = familyDao.getAllFamilies();
        Optional<List<Family>> filteredFamilies = Optional.of(allFamilies
                .stream()
                .filter(family -> family.countFamily() < numberOfFamilyMembers)
                .collect(Collectors.toList())
        );
        printData(filteredFamilies.get());
        return filteredFamilies;
    }

    public int countFamiliesWithMemberNumber(int numberOfFamilyMembers) {
        List<Family> allFamilies = familyDao.getAllFamilies();
        Optional<List<Family>> filteredFamilies = Optional.of(allFamilies
                .stream()
                .filter(family -> family.countFamily() == numberOfFamilyMembers)
                .collect(Collectors.toList())
        );
        if (filteredFamilies.get().size() != 0) {
            System.out.printf("There is/are %d family/ies with %d members.\n", filteredFamilies.get().size(), numberOfFamilyMembers);
        } else {
            System.out.printf("There is no families with %d members.\n", numberOfFamilyMembers);
        }
        return filteredFamilies.get().size();
    }

    public Family createNewFamily(Human mother, Human father) {
        Family family = new Family(mother, father);
        familyDao.saveFamily(family);
        return family;
    }

    public boolean deleteFamilyByIndex(int index) {
        return familyDao.deleteFamilyByIndex(index);
    }

    public Family bornChild(Family family, String sonsName, String daughterName) throws ParseException {
        Human father = family.getFather();
        String surname = father.getSurname();
        LocalDate birthdayDate = LocalDate.now();
        String birthday = father.dateToUnixTimeConvertor(birthdayDate);
        int childGenderProbability = (int) Math.round(Math.random());
        String childGender = (childGenderProbability == 1) ? "Boy" : "Girl";
        switch (childGender) {
            case "Boy":
                Man son = new Man(sonsName, surname, birthday, 5);
                family.addChild(son);
                familyDao.saveFamily(family);
                return family;
            case "Girl":
                Woman daughter = new Woman(daughterName, surname, birthday, 0);
                family.addChild(daughter);
                familyDao.saveFamily(family);
                return family;
            default:
                System.out.println("I'm in default");
                return null;
        }
    }

    public Family adoptChild(Family family, Human child) {
        family.addChild(child);
        familyDao.saveFamily(family);
        return family;
    }

    public void deleteAllChildrenOlderThen(int year) {
        List<Family> allFamilies = familyDao.getAllFamilies();
        List<Human> children = new ArrayList<>();
        allFamilies.stream()
                .map(Family::getChildren)
                .flatMap(Collection::stream)
                .forEach(child -> {
                    Date childBirthDay = new java.util.Date(child.getYear());
                    int birthYear = child.getBirthYear(childBirthDay);
                    long currentAge = LocalDate.now().getYear() - birthYear;
                    if (currentAge > year) {
                        children.add(child);
                    }
                });
        children.stream()
                .peek(child -> {
                    child.getFamily().deleteChildByObj(child);
                })
                .forEach(System.out::println);
    }

    public int count() {
        return getAllFamilies().size();
    }

    public Family getFamilyById(int familyIndex) {
        return familyDao.getFamilyByIndex(familyIndex);
    }

    public ArrayList<Pet> getPet(int familyIndex) {
        if (familyIndex > getAllFamilies().size()) {
            System.out.println("No family with entered index...");
            return null;
        } else {
            Family family = familyDao.getFamilyByIndex(familyIndex);
            if (family.getPet().size() == 0) {
                System.out.print("No pets in this family");
            }
            return family.getPet();
        }
    }

    public boolean addPet(int familyIndex, Pet pet) {
        if (familyIndex > getAllFamilies().size()) {
            System.out.println("No family with entered index...");
            return false;
        }
        Family family = familyDao.getFamilyByIndex(familyIndex);
        family.addPet(pet);
        familyDao.saveFamily(family);
        return true;
    }


}
