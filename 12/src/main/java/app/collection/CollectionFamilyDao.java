package app.collection;

import app.contract.FamilyDao;
import app.domain.Family;
import app.service.FileSystemService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements FamilyDao {

    //List is working like a database
    private List<Family> familiesList;

    public CollectionFamilyDao() {
        this.familiesList = new ArrayList<>();
    }

    @Override
    public List<Family> getAllFamilies() {
        return familiesList;
    }

    @Override
    public Family getFamilyByIndex(int familyIndex) {
        if (familyIndex > familiesList.size()) {
            return null;
        } else {
            return familiesList.get(familyIndex);
        }
    }

    @Override
    public boolean deleteFamilyByIndex(int familyIndex) {
        if (familyIndex > familiesList.size()) {
            return false;
        } else {
            familiesList.remove(familyIndex);
            return true;
        }
    }

    @Override
    public boolean deleteFamilyByObject(Family family) {
        if (!familiesList.contains(family)) {
            return false;
        } else {
            familiesList.remove(family);
            return true;
        }
    }

    @Override
    public void saveFamily(Family family) {
        if (familiesList.contains(family)) {
            int index = familiesList.indexOf(family);
            familiesList.set(index, family);
        } else {
            familiesList.add(family);
        }
    }

    @Override
    public void getDataFromFile() throws IOException, ClassNotFoundException {
        FileSystemService fss = new FileSystemService();
        Object receivedData = fss.getDataFromFile("families.bin");
        if (receivedData instanceof List) {
            familiesList = (List<Family>) receivedData;
        }
    }

    @Override
    public void saveDataToFile() throws IOException {
        FileSystemService fss = new FileSystemService();
        fss.saveDataToFile("families.bin", familiesList);
    }
}
