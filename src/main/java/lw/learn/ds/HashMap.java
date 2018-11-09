package lw.learn.ds;

import java.util.TreeMap;

/**
 * @Author lw
 * @Date 2018-11-07 20:55:55
 **/
public class HashMap<K, V> {

    private TreeMap<K, V>[] hashTable;
    private int M;
    private int size;

    private static final int initCapacity = 16;
    public static final int upperTol = 10;
    public static final int lowerTol = 2;
    static final int MAXIMUM_CAPACITY = 1 << 30;
    public HashMap(int m) {
        if (m < initCapacity) {
            m = initCapacity;
        } else {
            m = tableSizeFor(m);
        }
        M = m;
        size = 0;
        hashTable = new TreeMap[m];
        for (int i = 0; i < m; i++) {
            hashTable[i] = new TreeMap<>();
        }
    }
    public static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
    public HashMap() {
        this(initCapacity);
    }

    public void add(K key, V value) {
        TreeMap<K, V> map = hashTable[hash(key)];

        if (!map.containsKey(key))
            size++;
        map.put(key, value);

        if (size >= upperTol * M) {
            resize(2 * M);
        }
    }


    public V remove(K key) {
        TreeMap<K, V> map = hashTable[hash(key)];
        V res = null;
        if (map.containsKey(key)) {
            res = map.remove(key);
            size--;
        }

        if (size < lowerTol * M && M / 2 > initCapacity) {
            resize(M / 2);
        }
        return res;
    }

    private void resize(int capacity) {
        TreeMap<K, V>[] newHashTable = new TreeMap[capacity];
        for (int i = 0; i < capacity; i++) {
            newHashTable[i] = new TreeMap<>();
        }
        int oldM = M;
        M = capacity;
        for (int i = 0; i < oldM; i++) {
            TreeMap<K, V> map = hashTable[i];
            map.forEach((k, v) -> {
                newHashTable[hash(k)].put(k, v);
            });
        }
        hashTable = newHashTable;
    }

    public void set(K key, V value) {
        TreeMap<K, V> map = hashTable[hash(key)];

        if (map.containsKey(key))
            map.put(key, value);
    }

    public boolean contains(K key) {
        TreeMap<K, V> map = hashTable[hash(key)];
        return map.containsKey(key);
    }

    public V get(K key) {
        TreeMap<K, V> map = hashTable[hash(key)];
        return map.get(key);
    }


    public int size() {
        return size;
    }

    private int hash(K key) {
        //return (k.hashCode() & 0x7fffffff) % M;
        //return k.hashCode() & (M - 1);
        int h;
        return (key == null) ? 0 : ((h = key.hashCode()) ^ (h >>> 16)) & (M - 1);
    }

}
