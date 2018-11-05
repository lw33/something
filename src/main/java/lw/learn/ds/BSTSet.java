package lw.learn.ds;

/**
 * @Author lw
 * @Date 2018-11-04 21:57:35
 **/
public class BSTSet<E extends Comparable<E>> implements Set<E> {


    private BST<E> bst;

    public BSTSet() {
        this.bst = new BST<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public E remove(E e) {
        return null;
    }

    @Override
    public boolean contains(E e) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
