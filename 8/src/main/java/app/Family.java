package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Family {

    private Human mother;
    private Human father;
    private ArrayList<Human> children;
    private Pet pet;

    static int childrenAm = 0;

    public Family(Human mother, Human father) {
        childrenAm = 0;
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<>();
        mother.setFamily(this);
        father.setFamily(this);
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

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public int getChildrenAm() {
        return childrenAm;
    }

    public void setChildrenAm(int childrenAm) {
        Family.childrenAm = childrenAm;
    }

    public String childrenString(){
        String childrenLine = "";
        for (Human child : children) {
            System.out.println(child);
            childrenLine += child.toString() + ';';
            if (children.indexOf(child) != children.size()) childrenLine += "\n";
        }
        return childrenLine;
    }

    @Override
    public String toString() {
             return "Family:" +
                "\nmother=" + mother.getName() + " " + mother.getSurname() +
                ", \nfather=" + father.getName() + " " + father.getSurname() +
                ", \nchildren:" + "\n" + childrenString() +
                "pet:" + "\n" + pet;
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
        if (children.size()== 0) {
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
