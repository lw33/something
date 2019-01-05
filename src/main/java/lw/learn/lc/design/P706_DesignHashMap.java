package lw.learn.lc.design;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2019-01-05 23:51:04
 **/
public class P706_DesignHashMap {

    class MyHashMap {
        private int N = 1000001;
        private int[] hash = new int[N];
        /** Initialize your data structure here. */
        public MyHashMap() {
            Arrays.fill(hash, -1);
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            hash[key] = value;
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            return hash[key];
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            hash[key] = -1;
        }
    }

}
