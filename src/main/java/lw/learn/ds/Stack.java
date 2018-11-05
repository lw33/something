package lw.learn.ds;

public interface Stack<E> {

    // c
    void push(E e);

    // d
    E pop();


    // r
    E peek();

    int search(E e);

    boolean isEmpty();

    int size();
}
