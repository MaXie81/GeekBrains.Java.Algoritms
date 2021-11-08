package pkg;

public class Person {
    public final int ID;

    public Person(int id) {
        this.ID = id;
    }

    @Override
    public String toString() {
        return String.valueOf(ID);
    }
}

