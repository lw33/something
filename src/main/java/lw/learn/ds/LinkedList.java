package lw.learn.ds;

/**
 * @Author lw
 * @Date 2018-11-04 21:10:42
 **/
public class LinkedList<E> {

    private class Node {

        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList(){
        dummyHead = new Node();
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, E e) {

        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");

        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        //Node next = pre.next;
        //pre.next = new Node(e);
        //pre.next = next;
        pre.next = new Node(e, pre.next);
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E remove(int index) {
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Add failed. Illegal index.");

        Node cur = dummyHead;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        Node remove = cur.next;
        cur.next = remove.next;
        remove.next = null;
        size--;
        return (E) remove.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeEelement(E e) {
        Node cur = dummyHead;
        while (cur.next != null) {
            if (e.equals(cur.next.e)) {
                break;
            }
            cur = cur.next;
        }

        if (cur.next != null) {
            Node remove = cur.next;
            cur.next = remove.next;
            remove.next = null;
            size--;
        }
    }

    public void set(int index, E e) {
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Add failed. Illegal index.");
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    public boolean contains(E e) {
        if (isEmpty()) {
            return false;
        }
        Node cur = dummyHead.next;
        while (cur != null) {
            if (e.equals(cur.e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public E get(int index) {
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Add failed. Illegal index.");

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

}
