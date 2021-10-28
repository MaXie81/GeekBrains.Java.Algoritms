package arrays;

public class Dequeue<T> {
    Array<T> arr;

    public Dequeue(int capacity) {
        this.arr = new Array<>(capacity);
    }
    public void pushInLeft(T item) throws Exception {
        arr.pushIn(Direction.LEFT_TO_RIGHT, item);
    }
    public void pushInRight(T item) throws Exception {
        arr.pushIn(Direction.RIGHT_TO_LEFT, item);
    }
    public T pushOutLeft() throws Exception {
        return arr.pushOut(Direction.LEFT_TO_RIGHT);
    }
    public T pushOutRight() throws Exception {
        return arr.pushOut(Direction.RIGHT_TO_LEFT);
    }
    public T readLeft() throws Exception {
        return arr.read(Direction.LEFT_TO_RIGHT);
    }
    public T readRight() throws Exception {
        return arr.read(Direction.RIGHT_TO_LEFT);
    }
    public T[] getArr() {
        return arr.getArr();
    }
    public boolean isEmpty() {
        return arr.isEmpty();
    }
}
