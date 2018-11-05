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
        return bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int size() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
