import java.util.LinkedList;

public class ChainingHashMap<K, V> {
    private int capacity;
    private int size;
    private LinkedList<Node>[] nodeChain;

    public ChainingHashMap(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;

        nodeChain = new LinkedList[capacity];
        for (int i = 0; i < nodeChain.length; i++) {
            nodeChain[i] = new LinkedList<>();
        }
    }

    private class Node {
        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    public boolean contains(K key) {
        return get(key) != null;
    }

    public void checkKeyNotNull(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
    }

    public void put(K key, V value) {
        checkKeyNotNull(key);
        int hashMapIndex = hash(key);
        for (Node node : nodeChain[hashMapIndex]) {
            if (key.equals(node.key)) {
                node.value = value;
                return;
            }
        }
        nodeChain[hashMapIndex].addLast(new Node(key, value));
        size++;
    }

    public boolean remove(K key) {
        checkKeyNotNull(key);
        int hashMapIndex = hash(key);
        for (Node node : nodeChain[hashMapIndex]) {
            if (key.equals(node.key)) {
                nodeChain[hashMapIndex].remove(node);
                return true;
            }
        }
        return false;
    }

    public V get(K key) {
        checkKeyNotNull(key);
        int i = hash(key);
        for (Node node : nodeChain[i]) {
            if (key.equals(node.key)) {
                return node.value;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < capacity; i++) {
            sb.append("<" + i + "> ");
            for (Node node : nodeChain[i]) {
//                sb.append(node.key).append(" = ").append(node.value).append(" ");
                sb.append("[").append(node.key).append("]");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
