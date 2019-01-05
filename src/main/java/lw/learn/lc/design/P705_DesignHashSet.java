package lw.learn.lc.design;

/**
 * @Author lw
 * @Date 2019-01-05 23:44:40
 **/
public class P705_DesignHashSet {

    class MyHashSet {
        private int N = 1000001;
        private boolean[] hash = new boolean[N];
        /** Initialize your data structure here. */
        public MyHashSet() {
        }

        public void add(int key) {
            hash[key] = true;
        }

        public void remove(int key) {
            hash[key] = false;
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            return hash[key];
        }
    }
}
