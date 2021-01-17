package app.collection;

import app.contract.FamilyDao;
import app.domain.Family;
import app.exceptions.FamilyOverflowException;
import app.service.FileSystemService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements FamilyDao {

    //List is working like a database
    private List<Family> familiesList;
    String fileName = "families.bin";

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
        try {
            FileSystemService fss = new FileSystemService();
            Object receivedData = fss.getDataFromFile(fileName);
            if (receivedData instanceof List) {
                familiesList = (List<Family>) receivedData;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new FamilyOverflowException("There is an error by loading " + fileName +
                    " from hard disk.");
        }
    }

    @Override
    public void saveDataToFile() throws IOException {
        try {
            FileSystemService fss = new FileSystemService();
            fss.saveDataToFile(fileName, familiesList);
        } catch (IOException e) {
            throw new FamilyOverflowException("There is аn error by saving " + fileName +
                    " into hard disk.");
        }
    }
}
