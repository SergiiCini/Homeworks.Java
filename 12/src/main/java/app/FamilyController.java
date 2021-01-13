package app;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FamilyController implements FamilyServiceDao {
    public final FamilyService familyService;

    public FamilyController() {
        this.familyService = new FamilyService();
    }


    @Override
    public List<Family> getAllFamilies() {
        return familyService.getAllFamilies();
    }

    @Override
    public <T> void printData(List<T> data) {
        for (T item : data) {
            System.out.println(item);
        }
    }

    @Override
    public void displayAllFamilies() {
        familyService.displayAllFamilies();
    }

    @Override
    public Optional<List<Family>> getFamiliesBiggerThan(int numberOfFamilyMembers) {
        return familyService.getFamiliesBiggerThan(numberOfFamilyMembers);
    }

    @Override
    public Optional<List<Family>> getFamiliesLessThan(int numberOfFamilyMembers) {
        return familyService.getFamiliesLessThan(numberOfFamilyMembers);
    }

    @Override
    public int countFamiliesWithMemberNumber(int numberOfFamilyMembers) {
        return familyService.countFamiliesWithMemberNumber(numberOfFamilyMembers);
    }

    @Override
    public Family createNewFamily(Human mother, Human father) {
        return familyService.createNewFamily(mother, father);
    }

    @Override
    public boolean deleteFamilyByIndex(int index) {
        return familyService.deleteFamilyByIndex(index);
    }

    @Override
    public Family bornChild(Family family, String sonsName, String daughterName) throws ParseException {
        return familyService.bornChild(family, sonsName, daughterName);
    }

    @Override
    public Family adoptChild(Family family, Human child) {
        return familyService.adoptChild(family, child);
    }

    @Override
    public void deleteAllChildrenOlderThen(int year) {
        familyService.deleteAllChildrenOlderThen(year);
    }

    @Override
    public int count() {
        return familyService.count();
    }

    @Override
    public Family getFamilyById(int familyIndex) {
        return familyService.getFamilyById(familyIndex);
    }

    @Override
    public ArrayList<Pet> getPet(int familyIndex) {
        return familyService.getPet(familyIndex);
    }

    @Override
    public boolean addPet(int familyIndex, Pet pet) {
        return familyService.addPet(familyIndex, pet);
    }
}
