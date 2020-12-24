package app;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Family {

    private Human mother;
    private Human father;
    private Human[] children;
    private Pet pet;

    static int childrenAm = 0;

    public Family(Human mother, Human father) {
        childrenAm = 0;
        this.mother = mother;
        this.father = father;
        this.children = new Human[childrenAm];
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

    public Human[] getChildren() {
        return children;
    }

    public void setChildren(Human[] children) {
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

    @Override
    public String toString() {
        String child = "";
        for (int i = 0; i < children.length; i++) {
            child += children[i].toString() + ';';
            if (i != children.length - 1) child += "\n";
        }
        return "Family:" +
                "\nmother=" + mother.getName() + " " + mother.getSurname() +
                ", \nfather=" + father.getName() + " " + father.getSurname() +
                ", \nchildren:" + "\n" + child +
                ", \npet:" + "\n" + pet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Family)) return false;
        Family family = (Family) o;
        return Objects.equals(mother, family.mother) && Objects.equals(father, family.father) && Arrays.equals(children, family.children) && Objects.equals(pet, family.pet);
    }

    public void addChild(Human child) {
        child.setFamily(this);
        if (childrenAm == 0) {
            children = new Human[childrenAm + 1];
        }
        childrenAm = childrenAm + 1;
        Human[] addedChildren = new Human[childrenAm];
        for (int i = 0; i < children.length; i++) {
            addedChildren[i] = children[i];
        }
        children = addedChildren;
        children[childrenAm - 1] = child;
    }

    public boolean deleteChild(int childId) {
        if (children.length == 0) {
            throw new NoSuchElementException("This family haven't any children yet.");
        } else if (childId > children.length - 1) {
            throw new NoSuchElementException("This family haven't this child.");
        } else {
            Human[] removedChild = new Human[children.length - 1];
            System.arraycopy(children, 0, removedChild, 0, childId);
            if (children.length != childId) {
                System.arraycopy(children, childId + 1, removedChild, childId, children.length - childId - 1);
            }
            children = removedChild;
        }
        System.out.printf("Child %d was deleted from this family.", childId);
        return true;
    }

    public boolean deleteChildByObj(Human child){
        if (children.length == 0) {
            throw new NoSuchElementException("This family haven't any children yet.");
        }
        for(int i = 0; i<children.length; i++) {
            if(children[i].getName().equals(child.getName())) {
                Human[] removedChild = new Human[children.length - 1];
                System.arraycopy(children, 0, removedChild, 0, i);
                if (children.length != i) {
                    System.arraycopy(children, i + 1, removedChild, i, children.length - i - 1);
                }
                children = removedChild;
            }
            else {
                System.out.println("This family doesn't have children with this name.");
            }
        }
        System.out.printf("\nChild %s was deleted from this family.", child.getName());
        return true;
    }

    public int countFamily() {
        return children.length + 2;
    }

    protected void finalize() throws Throwable {
        System.out.println("Family object was destroyed.");
    }

}
