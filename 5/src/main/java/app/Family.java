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
    static int pos = 0;

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

//    private void resize() {
//        // according to the task initial size of children array should be 0.
//        if (childrenAm == 0) {
//            childrenAm = 1;
//            children = new Human[childrenAm];
//            return;
//        }
//
//        childrenAm = childrenAm + 1;
//        Human[] resizedChildrenArr = new Human[childrenAm];
//        System.arraycopy(children, 0, resizedChildrenArr, 0, children.length);
//        children = resizedChildrenArr;
//
//    }
//
//    private void resizeIfNeed() {
//        if (pos == childrenAm) resize();
//    }
//
//    public void addChild(Human child) {
//        child.setFamily(this);
//        resizeIfNeed();
//        this.children[pos++] = child;
//    }


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
        System.out.println("children: " + Arrays.toString(this.children));
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

    public int countFamily() {
        return children.length + 2;
    }

    protected void finalize() throws Throwable {
        System.out.println("Family object was destroyed.");
    }

}
