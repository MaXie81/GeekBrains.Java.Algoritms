package linkedlist;

import linkedlist.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedList<T> implements ListIterator<T> {
    private Item<T> itemFirst;
    private Item<T> itemCurrent;
    private Item<T> itemLast;
    private int size = 0;
    private boolean iteratorState = false;
    private int iteratorIndex = -1;

    public boolean isEmpty() {
        return size == 0;
    }
    public void addFirst(T value) {
        if (size == 0) {
            itemFirst = new Item(value, null, null);
            itemLast = itemFirst;
        } else {
            Item<T> itemNext = itemFirst;
            itemFirst = new Item(value, null, itemNext);
            itemNext.setItemPrev(itemFirst);
        }
        size++;
    }
    public void addLast(T value) {
        if (size == 0) {
            itemLast = new Item(value, null, null);
            itemFirst = itemLast;
        } else {
            Item<T> itemPrev = itemLast;
            itemLast = new Item(value, itemPrev, null);
            itemPrev.setItemNext(itemLast);
        }
        size++;
    }
    public void add(int index, T value) throws Exception {
        if (index == 0)
            addFirst(value);
        else if (index == size)
            addLast(value);
        else {
            Item<T> itemPrev = getByIndex(index - 1);
            Item<T> itemNext = itemPrev.getItemNext();

            Item<T> itemCurr = new Item(value, itemPrev, itemNext);

            itemPrev.setItemNext(itemCurr);
            itemNext.setItemPrev(itemCurr);

            size++;
        }
    }
    public Item<T> removeFirst() throws Exception {
        Item<T> itemCurr = itemFirst;
        switch (size) {
            case 0:
                throw new Exception("Индекс выходит за пределы!");
            case 1:
                itemFirst = null;
                itemLast = null;
                break;
            default:
                Item<T> itemNext = itemFirst.getItemNext();
                itemFirst = itemNext;
                itemNext.setItemPrev(null);
        }
        size--;
        return itemCurr;
    }
    public Item<T> removeLast() throws Exception {
        Item<T> itemCurr = itemLast;
        switch (size) {
            case 0:
                throw new Exception("Индекс выходит за пределы!");
            case 1:
                itemLast = null;
                itemFirst = null;
                break;
            default:
                Item<T> itemPrev = itemLast.getItemPrev();
                itemLast = itemPrev;
                itemPrev.setItemNext(null);
        }
        size--;
        return itemCurr;
    }
    public Item<T> remove(int index) throws Exception {
        if (index == 0)
            return removeFirst();
        else if (index == size)
            return removeLast();
        else {
            Item<T> itemCurr = getByIndex(index);

            Item<T> itemPrev = itemCurr.getItemPrev();
            Item<T> itemNext = itemCurr.getItemNext();

            itemPrev.setItemNext(itemNext);
            itemNext.setItemPrev(itemPrev);

            size--;
            return itemCurr;
        }
    }
    public List<T> getList(boolean isForward) {
        Item<T> itemCurr;
        List<T> list = new ArrayList<>();

        if (isForward) {
            itemCurr = itemFirst;
            while (itemCurr != null) {
                list.add(itemCurr.getValue());
                itemCurr = itemCurr.getItemNext();
            }
        } else {
            itemCurr = itemLast;
            while (itemCurr != null) {
                list.add(itemCurr.getValue());
                itemCurr = itemCurr.getItemPrev();
            }
        }
        return list;
    }
    public Item<T> getByIndex(int index) throws Exception {
        if (index < 0 || index >= size) throw new Exception("Индекс выходит за пределы!");
        Item<T> itemCurr;
        if (index < (size / 2)) {
            itemCurr = itemFirst;
            for (int i = 1; i <= index; i++) {
                itemCurr = itemCurr.getItemNext();
            }
        } else {
            itemCurr = itemLast;
            for (int i = size - 2; i >= index; i--) {
                itemCurr = itemCurr.getItemPrev();
            }
        }
        return itemCurr;
    }

    @Override
    public boolean hasNext() {
        if (itemFirst == null) return false;
        if (itemCurrent == null) return true;
        if (itemCurrent.getItemNext() == null)
            return false;
        else
            return true;
    }

    @Override
    public T next() {
        if (!hasNext()) return null;
        itemCurrent = itemCurrent.getItemNext();
        iteratorState = true;
        iteratorIndex++;
        return itemCurrent.getValue();
    }

    @Override
    public boolean hasPrevious() {
        if (itemLast == null) return false;
        if (itemCurrent == null) return false;
        if (itemCurrent.getItemPrev() == null)
            return false;
        else
            return true;
    }

    @Override
    public T previous() {
        if (!hasPrevious()) return null;
        if (iteratorState) {
            itemCurrent = itemCurrent.getItemPrev();
            iteratorIndex--;
        } else {
            iteratorState = true;
        }
        return itemCurrent.getValue();
    }

    @Override
    public int nextIndex() {
        if (itemFirst == null) return -1;
        if (itemCurrent == null) return 0;
        if (itemCurrent.getItemNext() == null)
            return -1;
        else
            return iteratorIndex + 1;
    }

    @Override
    public int previousIndex() {
        if (itemLast == null) return -1;
        if (itemCurrent == null) return -1;
        if (itemCurrent.getItemPrev() == null)
            return -1;
        else
            return iteratorIndex - 1;
    }

    @Override
    public void remove() {
        if (itemCurrent == null) return;
        if (!iteratorState) return;

        Item<T> itemPrev = itemCurrent.getItemPrev();
        Item<T> itemNext = itemCurrent.getItemNext();

        if (itemPrev == null)
            itemFirst = itemNext;
        else
            itemPrev.setItemNext(itemNext);

        if (itemNext == null)
            itemLast = itemPrev;
        else
            itemNext.setItemPrev(itemPrev);

        itemCurrent = itemPrev;
        iteratorState = false;
        size--;
    }

    @Override
    public void set(T t) {
        if (itemCurrent != null) itemCurrent.setValue(t);
    }

    @Override
    public void add(T t) {
        Item<T> itemPrev;
        Item<T> itemNext;

        if (itemFirst == null) {
            itemPrev = null;
            itemNext = null;

            itemCurrent = new Item<>(t, itemPrev, itemNext);
            itemFirst = itemCurrent;
            itemLast  = itemCurrent;

        } else if (itemCurrent == null) {
            itemPrev = null;
            itemNext = itemFirst;

            itemCurrent = new Item<>(t, itemPrev, itemNext);
            itemFirst = itemCurrent;
            itemNext.setItemPrev(itemCurrent);

        } else if (!hasNext()) {
            itemPrev = itemCurrent;
            itemNext = null;

            itemCurrent = new Item<>(t, itemPrev, itemNext);
            itemPrev.setItemNext(itemCurrent);
            itemLast = itemCurrent;
        } else {
            itemPrev = itemCurrent;
            itemNext = itemCurrent.getItemNext();

            itemCurrent = new Item<>(t, itemPrev, itemNext);
            itemPrev.setItemNext(itemCurrent);
            itemNext.setItemPrev(itemCurrent);
        }
        iteratorState = false;
        size++;
    }
}
