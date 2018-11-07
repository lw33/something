package lw.learn.ds;

/**
 * @Author lw
 * @Date 2018-11-07 12:41:35
 **/
public class AVLSet<K extends Comparable<K>> implements Set<K>{

    private AVLTree<K, Object> avl;

    public AVLSet() {
        avl = new AVLTree<>();
    }

    @Override
    public void add(K k) {
        avl.add(k, null);
    }

    @Override
    public K remove(K k) {
        avl.remove(k);
        return k;
    }

    @Override
    public boolean contains(K k) {
        return avl.contains(k);
    }

    @Override
    public int size() {
        return avl.size();
    }

    @Override
    public boolean isEmpty() {
        return avl.isEmpty();
    }
}
