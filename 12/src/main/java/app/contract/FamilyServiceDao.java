package app.contract;

import app.domain.Family;
import app.domain.Human;
import app.domain.Pet;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface FamilyServiceDao {

    public List<Family> getAllFamilies();
    public <T> void printData(List<T> data);
    public void displayAllFamilies();
    public Optional<List<Family>> getFamiliesBiggerThan(int numberOfFamilyMembers);
    public Optional<List<Family>> getFamiliesLessThan(int numberOfFamilyMembers);
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
    public void getDataFromFile() throws IOException, ClassNotFoundException;
    public void saveDataToFile() throws IOException, ClassNotFoundException;
}
