package linkedlist;

public class Item<T> {
    private T value;
    private Item<T> itemNext;
    private Item<T> itemPrev;

    public Item(T value, Item<T> itemPrev, Item<T> itemNext) {
        this.value = value;
        this.itemNext = itemNext;
        this.itemPrev = itemPrev;
    }

    public void setValue(T value) {this.value = value;}
    public void setItemNext(Item<T> itemNext) {
        this.itemNext = itemNext;
    }
    public void setItemPrev(Item<T> itemPrev) {
        this.itemPrev = itemPrev;
    }
    public T getValue() {
        return value;
    }
    public Item<T> getItemNext() {
        return itemNext;
    }
    public Item<T> getItemPrev() {
        return itemPrev;
    }
}
