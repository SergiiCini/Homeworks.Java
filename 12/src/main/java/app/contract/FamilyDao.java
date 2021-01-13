package app.contract;

import app.domain.Family;

import java.io.IOException;
import java.util.List;

public interface FamilyDao {
    List<Family> getAllFamilies();
    Family getFamilyByIndex(int familyIndex);
    boolean deleteFamilyByIndex (int familyIndex);
    boolean deleteFamilyByObject(Family family);
    void saveFamily(Family family);
    void getDataFromFile() throws IOException, ClassNotFoundException;
    void saveDataToFile() throws IOException;
}
