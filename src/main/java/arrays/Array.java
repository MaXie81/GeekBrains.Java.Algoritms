package arrays;

public class Array<T>{
    private T[] arr;
    private int capacity;
    private int size;
    private int indexInRightToLeft;
    private int indexOutRightToLeft;
    private int indexInLeftToRight;
    private int indexOutLeftToRight;

    public Array(int capacity) {
        this.capacity = capacity;
        this.arr = (T[]) new Object[this.capacity];
        this.size = 0;
    }
    public void pushIn(Direction direction, T item) throws Exception {
        if (isFull()) throw new Exception("Стек переполнен!");
        moveIndex(Action.PUT_IN, direction);
        arr[getIndex(Action.PUT_IN, direction)] = item;
    }
    public T pushOut(Direction direction) throws Exception {
        if (isEmpty()) throw new Exception("Стек пуст!");
        T item = arr[getIndex(Action.PUT_OUT, direction)];
        arr[getIndex(Action.PUT_OUT, direction)] = null;
        moveIndex(Action.PUT_OUT, direction);
        return item;
    }
    public T read(Direction direction) throws Exception {
        if (isEmpty()) throw new Exception("Стек пуст!");
        T item = arr[getIndex(Action.PUT_OUT, direction)];
        return item;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    private boolean isFull() {
        return size == capacity;
    }
    private void moveIndex(Action action, Direction direction) throws Exception {
        switch (action) {
            case PUT_IN:
                switch (direction) {
                    case RIGHT_TO_LEFT:
                        size += 1;
                        if (size == 1) {
                            indexInRightToLeft = 0;
                            indexInLeftToRight = capacity;
                            indexOutLeftToRight = 0;
                            indexOutRightToLeft = 0;
                        } else {
                            indexInRightToLeft = (indexInRightToLeft + capacity + 1) % capacity;
                            indexOutRightToLeft = indexInRightToLeft;
                        }
                        break;
                    case LEFT_TO_RIGHT:
                        size += 1;
                        if (size == 1) {
                            indexInRightToLeft = -1;
                            indexInLeftToRight = capacity - 1;
                            indexOutRightToLeft = capacity - 1;
                            indexOutLeftToRight = capacity - 1;
                        } else {
                            indexInLeftToRight = (indexInLeftToRight + capacity - 1) % capacity;
                            indexOutLeftToRight = indexInLeftToRight;
                        }
                        break;
                    default:
                        throw new Exception("Неизвестный тип!");
                }
                break;
            case PUT_OUT:
                switch (direction) {
                    case RIGHT_TO_LEFT:
                        size -= 1;
                        if (size == 0) {
                            indexInRightToLeft = -1;
                            indexOutRightToLeft = -1;
                            indexOutLeftToRight = -1;
                        } else {
                            indexOutRightToLeft = (indexOutRightToLeft + capacity - 1) % capacity;
                            indexInRightToLeft = indexOutRightToLeft;
                        }
                        break;
                    case LEFT_TO_RIGHT:
                        size -= 1;
                        if (size == 0) {
                            indexInLeftToRight = -1;
                            indexOutRightToLeft = -1;
                            indexOutLeftToRight = -1;
                        } else {
                            indexOutLeftToRight = (indexOutLeftToRight + capacity + 1) % capacity;
                            indexInLeftToRight = indexOutLeftToRight;
                        }
                        break;
                    default:
                        throw new Exception("Неизвестный тип!");
                }
                break;
            default:
                throw new Exception("Неизвестный тип!");
        }
    }
    private int[] getArrIndex() {
        int[] arrIndex = new int[size];
        for (int i = 0; i < size; i++) {
            arrIndex[i] = (indexOutLeftToRight + capacity + i) % capacity;
        }
        return arrIndex;
    }
    public T[] getArr() {
        int[] arrIndex = getArrIndex();
        T[] arr = (T[]) new Object[arrIndex.length];

        for (int i = 0; i < arrIndex.length; i++) {
            arr[i] = this.arr[arrIndex[i]];
        }
        return arr;
    }
    private int getIndex(Action action, Direction direction) throws Exception {
        switch (action) {
            case PUT_IN:
                switch (direction) {
                    case RIGHT_TO_LEFT: return indexInRightToLeft;
                    case LEFT_TO_RIGHT: return indexInLeftToRight;
                    default: throw new Exception("Неизвестный тип!");
                }
            case PUT_OUT:
                switch (direction) {
                    case RIGHT_TO_LEFT: return indexOutRightToLeft;
                    case LEFT_TO_RIGHT: return indexOutLeftToRight;
                    default: throw new Exception("Неизвестный тип!");
                }
            default:
                throw new Exception("Неизвестный тип!");
        }
    }
}

