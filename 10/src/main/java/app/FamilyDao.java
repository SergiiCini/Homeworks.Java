package app;

import java.util.List;

public interface FamilyDao {
    public List<Family> getAllFamilies();
    public Family getFamilyByIndex(int familyIndex);
    public boolean deleteFamilyByIndex (int familyIndex);
    public boolean deleteFamilyByObject(Family family);
    public void saveFamily(Family family);
}
