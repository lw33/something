package lw.learn.ds;

/**
 * @Author lw
 * @Date 2018-11-05 16:46:07
 **/
public class LinkedListMap<K, V> implements Map<K, V> {

    private class Node {
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key) {
            this(key, null, null);
        }

        public Node() {
        }
    }

    private Node dymmyHead;
    private int size;

    public LinkedListMap() {
        dymmyHead = new Node();
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (node == null) {
            dymmyHead.next = new Node(key, value, dymmyHead.next);
            size++;
        } else {
            node.value = value;
        }
    }

    @Override
    public V remove(K key) {

        Node cur = dymmyHead;
        while (cur.next != null) {
            if (key.equals(cur.next.key)) {
                break;
            }
            cur = cur.next;
        }
        if (cur.next != null) {
            Node remove = cur.next;
            cur.next = remove.next;
            remove.next = null;
            size--;
            return remove.value;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(key);
        if (node != null) {
            node.value = value;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private Node getNode(K key) {

        Node cur = dymmyHead.next;
        while (cur != null) {
            if (key.equals(cur.key)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
}
