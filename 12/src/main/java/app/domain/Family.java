package app.domain;

import java.util.*;

public class Family {

    private Human mother;
    private Human father;
    private ArrayList<Human> children;
    private ArrayList<Pet> pets;

    static int childrenAm = 0;

    public Family(Human mother, Human father) {
        childrenAm = 0;
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<>();
        mother.setFamily(this);
        father.setFamily(this);
        this.pets = new ArrayList<>();
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public ArrayList<Human> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Human> children) {
        this.children = children;
    }

    public ArrayList<Pet> getPet() {
        return pets;
    }

    public Pet getSomePet(int petIndex) {
        return pets.get(petIndex);
    }

    public void setPet(ArrayList<Pet> pets) {
        this.pets = pets;
    }

    public void addPet(Pet pet) {
        if (pets.contains(pet)) {
            System.out.println("This family has had this pet already!");
        }
        pets.add(pet);
    }

    public int getChildrenAm() {
        return childrenAm;
    }

    public void setChildrenAm(int childrenAm) {
        Family.childrenAm = childrenAm;
    }

    public String childrenString() {
        String childrenLine = "";
        String childGender = "";
        for (Human child : children) {
            childGender = child.getGender().equals("man") ? "son" : "daughter";
            childrenLine += "\t\t" + childGender + ": " + child.prettyFormat() + '\n';
            if (children.indexOf(child) != children.size()) childrenLine += "";
        }
        return childrenLine;
    }

    public String prettyFormat() {
        return "family: \n" +
                "\tmother: " + mother.toString() + "\n" +
                "\tfather: " + father.toString() + "\n" +
                "\tchildren: \n" + childrenString() +
                "\tpets: \n" + "\t\t" + pets + "\n";
    }

    @Override
    public String toString() {
        return prettyFormat();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Family)) return false;
        Family family = (Family) o;
        return Objects.equals(mother, family.mother) && Objects.equals(father, family.father);
    }

    public void addChild(Human child) {
        child.setFamily(this);
        children.add(child);
    }

    public boolean deleteChild(int childId) {
        if (children.size() == 0) {
            throw new NoSuchElementException("This family haven't any children yet.");
        } else if (childId > children.size() - 1) {
            throw new NoSuchElementException("This family haven't this child.");
        } else {
            children.remove(childId);
            System.out.printf("\nChild %d was deleted from this family.", childId);
        }
        Human child = children.get(childId);
        child.setFamily(null);
        return true;
    }

    public boolean deleteChildByObj(Human child) {
        if (children.size() == 0) {
            throw new NoSuchElementException("This family haven't any children yet.");
        }
        int childIndex = children.indexOf(child);
        children.remove(childIndex);
        child.setFamily(null);
        return true;
    }

    public int countFamily() {
        return children.size() + 2;
    }

    protected void finalize() throws Throwable {
        System.out.println("Family object was destroyed.");
    }

}
