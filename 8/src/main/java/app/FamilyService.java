package app;

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
        Human father = family.getFather();
        String surname = father.getSurname();
        int barthYear = LocalDate.now().getYear();
        int childGenderProbability = (int) Math.round(Math.random());
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
        for (Family family : allFamilies) {
            List<Human> children = family.getChildren();
            for (Human child : children) {
                int currentAge = LocalDate.now().getYear() - child.getYear();
                if (currentAge > year) {
                    family.deleteChildByObj(child);
                    familyDao.saveFamily(family);
                    break;
                }
            }
        }
    }

    public int count() {
        return getAllFamilies().size();
    }

    public Family getFamilyById(int familyIndex) {
        return familyDao.getFamilyByIndex(familyIndex);
    }

    public ArrayList<Pet> getPet(int familyIndex) {
        ArrayList<Pet> pets = new ArrayList<>();
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
