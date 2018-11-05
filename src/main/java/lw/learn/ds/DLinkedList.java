package lw.learn.ds;

/**
 * @Author lw
 * @Date 2018-11-04 21:10:42
 **/
public class DLinkedList<E> {

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

    private Node head;
    private int size;


}
