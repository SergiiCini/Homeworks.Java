package app;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public interface FamilyServiceDao {

    public List<Family> getAllFamilies();
    public <T> void printData(List<T> data);
    public void displayAllFamilies();
    public List<Family> getFamiliesBiggerThan(int numberOfFamilyMembers);
    public List<Family> getFamiliesLessThan(int numberOfFamilyMembers);
    public int countFamiliesWithMemberNumber(int numberOfFamilyMembers);
    public Family createNewFamily(Human mother, Human father);
    public boolean deleteFamilyByIndex(int index);
    public Family bornChild(Family family, String sonsName, String daughterName) throws ParseException;
    public Family adoptChild(Family family, Human child);
    public void deleteAllChildrenOlderThen(int year);
    public int count();
    public Family getFamilyById(int familyIndex);
    public ArrayList<Pet> getPet(int familyIndex);
    public boolean addPet(int familyIndex, Pet pet);
}
