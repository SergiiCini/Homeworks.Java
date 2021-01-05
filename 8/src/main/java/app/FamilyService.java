package app;

import jdk.vm.ci.meta.Local;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    public List<Family> getFamiliesBiggerThan(int numberOfFamilyMembers) {
        List<Family> filteredFamilies = new ArrayList<>();
        List<Family> allFamilies = getAllFamilies();
        for (Family family : allFamilies) {
            if (family.countFamily() > numberOfFamilyMembers) {
                assert false;
                filteredFamilies.add(family);
            }
        }
        printData(filteredFamilies);
        return filteredFamilies;
    }

    public List<Family> getFamiliesLessThan(int numberOfFamilyMembers) {
        List<Family> filteredFamilies = new ArrayList<>();
        List<Family> allFamilies = getAllFamilies();
        for (Family family : allFamilies) {
            if (family.countFamily() < numberOfFamilyMembers) {
                assert false;
                filteredFamilies.add(family);
            }
        }
        printData(allFamilies);
        return filteredFamilies;
    }

    public int countFamiliesWithMemberNumber(int numberOfFamilyMembers) {
        List<Family> filteredFamilies = new ArrayList<>();
        List<Family> allFamilies = getAllFamilies();
        for (Family family : allFamilies) {
            if (family.countFamily() == numberOfFamilyMembers) {
                assert false;
                filteredFamilies.add(family);
            }
        }
        System.out.println(filteredFamilies.size());
        return filteredFamilies.size();
    }

    public Family createNewFamily(Human mother, Human father) {
        Family family = new Family(mother, father);
        familyDao.saveFamily(family);
        return family;
    }

    public boolean deleteFamilyByIndex(int index) {
        return familyDao.deleteFamilyByIndex(index);
    }

    public Family bornChild(Family family, String sonsName, String daughterName) {
        //born child
        Human father = family.getFather();
        String surname = father.getSurname();
        int barthYear = LocalDate.now().getYear();
        int childGenderProbability = (int) Math.floor(Math.random());
        String childGender = (childGenderProbability == 1) ? "Boy" : "Girl";
        switch (childGender) {
            case "Boy":
                Man son = new Man(sonsName, surname, barthYear, 0);
                family.addChild(son);
                familyDao.saveFamily(family);
                return family;
            case "Girl":
                Woman daughter = new Woman(daughterName, surname, barthYear, 0);
                family.addChild(daughter);
                familyDao.saveFamily(family);
                return family;
            default:
                return null;
        }
    }

    public Family adoptChild(Family family, Human child){
        family.addChild(child);
        familyDao.saveFamily(family);
        return family;
    }



}
