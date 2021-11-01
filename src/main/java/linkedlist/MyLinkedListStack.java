package linkedlist;

import java.util.List;

public class MyLinkedListStack<T> {
    private MyLinkedList<T> linkedList = new MyLinkedList<>();

    public void push(T item) {
        linkedList.addFirst(item);
    }
    public T pop() throws Exception {
        return linkedList.removeFirst().getValue();
    }
    public T peek() throws Exception {
        return linkedList.getByIndex(0).getValue();
    }
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
    public List<T> getList() {
        return linkedList.getList(true);
    }
}
