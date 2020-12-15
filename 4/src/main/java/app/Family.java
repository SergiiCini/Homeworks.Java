package app;

public class Family {
    private Human mother;
    private Human father;
    private Human[] children;
    private Pet pet;

    private int childrenAm = 0;

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        this.children = new Human[childrenAm];
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
        this.childrenAm = childrenAm;
    }

    @Override
    public String toString() {
        String child = "";
        for (Human human : children) {
            assert false;
            child += human.getName() + ", ";
        }
        return "Family{" +
                "mother=" + mother.getName() +
                ", father=" + father.getName() +
                ", children=" + child +
                "pet=" + pet +
                '}';
    }
}
