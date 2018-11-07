package lw.learn.ds;

/**
 * @Author lw
 * @Date 2018-11-07 18:21:16
 **/
public class RBSet<K extends Comparable<K>> implements Set<K> {

    private RBTree<K, Object> rbTree;

    public RBSet() {
        rbTree = new RBTree<>();
    }

    @Override
    public void add(K k) {
        rbTree.add(k, null);
    }

    @Override
    public K remove(K k) {

        return null;
    }

    @Override
    public boolean contains(K k) {
        return rbTree.contains(k);
    }

    @Override
    public int size() {
        return rbTree.size();
    }

    @Override
    public boolean isEmpty() {
        return rbTree.isEmpty();
    }
}
