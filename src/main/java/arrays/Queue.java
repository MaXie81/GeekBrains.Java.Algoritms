package arrays;

public class Queue<T> {
    Array<T> arr;

    public Queue(int capacity) {
        this.arr = new Array<>(capacity);
    }
    public void pushIn(T item) throws Exception {
        arr.pushIn(Direction.LEFT_TO_RIGHT, item);
    }
    public T pushOut() throws Exception {
        return arr.pushOut(Direction.RIGHT_TO_LEFT);
    }
    public T read() throws Exception {
        return arr.read(Direction.RIGHT_TO_LEFT);
    }
    public T[] getArr() {
        return arr.getArr();
    }
    public boolean isEmpty() {
        return arr.isEmpty();
    }
}
