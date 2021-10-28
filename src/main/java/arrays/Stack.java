package arrays;

public class Stack<T> {
    Array<T> arr;

    public Stack(int capacity) {
        this.arr = new Array<>(capacity);
    }
    public void pushIn(T item) throws Exception {
        arr.pushIn(Direction.LEFT_TO_RIGHT, item);
    }
    public T pushOut() throws Exception {
        return arr.pushOut(Direction.LEFT_TO_RIGHT);
    }
    public T read() throws Exception {
        return arr.read(Direction.LEFT_TO_RIGHT);
    }
    public T[] getArr() {
        return arr.getArr();
    }
    public boolean isEmpty() {
        return arr.isEmpty();
    }
}

