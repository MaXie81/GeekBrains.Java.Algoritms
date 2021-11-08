package pkg;

public class Node {
    public Person person;
    public int vPos;
    public int hPos;
    public Node leftNode;
    public Node rightNode;

    public Node(Person person, int vPos, int hPos) {
        this.person = person;
        this.vPos = vPos;
        this.hPos = hPos;
    }

    @Override
    public String toString() {
        return person.toString() + " " + vPos + "/" + hPos;
    }
}
