package app;

import java.util.Arrays;

public class Family {
    public Human mother;
    public Human father;
    public Human [] children;
    public Pet pet;

    public int childrenAm = 0;

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        this.children = new Human[childrenAm];
    }

    public Human getMother(){
        return mother;
    }

    public Human getFather(){
        return father;
    }

    public Pet getPet(){
        return pet;
    }

    public Human[] getChildren(){
        return children;
    }

    @Override
    public String toString() {
        return "Family{" +
                "mother=" + mother +
                ", father=" + father +
                ", children=" + Arrays.toString(children) +
                ", pet=" + pet +
                ", childrenAm=" + childrenAm +
                '}';
    }
}
