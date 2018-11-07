package lw.learn.ds;

/**
 * @Author lw
 * @Date 2018-11-07 18:23:09
 **/
public class RBMap<K extends Comparable<K>, V> implements Map<K,V> {

    private RBTree<K, V> rbTree = new RBTree<>();

    @Override
    public void add(K key, V value) {
        rbTree.add(key, value);
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public boolean contains(K key) {
        return rbTree.contains(key);
    }

    @Override
    public V get(K key) {
        return rbTree.get(key);
    }

    @Override
    public void set(K key, V value) {
        rbTree.set(key, value);
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
