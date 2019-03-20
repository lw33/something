package lw.learn.lc.map;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author lw
 * @Date 2019-03-20 18:27:21
 **/
public class P146_LRUCache {

    public class LRUCache {

        class LRULinkedHashMap<K, V> extends LinkedHashMap<K, V> {
            private int capacity;

            public LRULinkedHashMap(int initialCapacity) {
                super(initialCapacity, 1f, true);
                this.capacity = initialCapacity;
            }

            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > capacity;
            }
        }

        private LinkedHashMap<Integer, Integer> map;

        public LRUCache(int capacity) {
            map = new LRULinkedHashMap<>(capacity);
        }

        public int get(int key) {
            return map.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            map.put(key, value);
        }
    }

    @Test
    public void test() {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 3);
        lruCache.put(1, 3);
        lruCache.put(2, 5);
        lruCache.put(2, 5);
        lruCache.put(4, 2);
        System.out.println(lruCache.get(1));
    }
}
