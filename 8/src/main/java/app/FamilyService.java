package app;

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

    public <T> void printData(List<T> data){
        for(T item: data) {
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
        List<Family> allFamilies = familyDao.getAllFamilies();
        for(Family family : allFamilies) {
            if(family.countFamily() > numberOfFamilyMembers){
                assert false;
                filteredFamilies.add(family);
            }
        }
        printData(filteredFamilies);
        return filteredFamilies;
    }

    public List<Family> getFamiliesLessThan(int numberOfFamilyMembers) {
        List<Family> filteredFamilies = new ArrayList<>();
        List<Family> allFamilies = familyDao.getAllFamilies();
        for(Family family : allFamilies) {
            if(family.countFamily() < numberOfFamilyMembers){
                assert false;
                filteredFamilies.add(family);
            }
        }
        printData(allFamilies);
        return filteredFamilies;
    }


}
