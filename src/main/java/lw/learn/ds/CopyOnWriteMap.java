package lw.learn.ds;

import org.junit.Test;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author lw
 * @Date 2018-11-19 23:35:12
 **/
public class CopyOnWriteMap<K, V> implements Map<K, V> {

    private volatile HashMap<K, V> map = new HashMap<>();
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void add(K key, V value) {

        put(key, value);
    }

    @Override
    public boolean contains(K key) {
        return map.containsKey(key);
    }

    @Override
    public void set(K key, V value) {
        put(key, value);
    }

    @Override
    public int size() {

        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public V get(Object key) {
        return map.get(key);
    }

    public V put(K key, V value) {
        try {
            lock.lock();

            HashMap<K, V> kvMap = new HashMap<>(map);
            V v = kvMap.put(key, value);
            map = kvMap;
            return v;

        } finally {
            lock.unlock();
        }
    }

    @Override
    public V remove(Object key) {
        try {
            lock.lock();
            return map.remove(key);
        } finally {
            lock.unlock();

        }
    }

    @Test
    public void test() throws InterruptedException {

        CopyOnWriteMap<String, Integer> map = new CopyOnWriteMap<>();
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                map.put("java", map.get("java") == null ? 1 : map.get("java") + 1);
            }

        }).start();
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                map.put("java", map.get("java") == null ? 1 : map.get("java") + 1);
            }
        }).start();
        Thread.sleep(10000);
        System.out.println(map.map);
    }
}
