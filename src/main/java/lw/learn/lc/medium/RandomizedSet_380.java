package lw.learn.lc.medium;

import java.util.HashMap;

/**
 * @Author lw
 * @Date 2018-11-21 20:09:36
 **/
public class RandomizedSet_380 {

    class RandomizedSet {
        private HashMap<Integer, Integer> indexMap;
        private HashMap<Integer, Integer> dataMap;
        private int size;

        /** Initialize your data structure here. */
        public RandomizedSet() {
            indexMap = new HashMap<>();
            dataMap = new HashMap<>();
            size = 0;
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (dataMap.containsKey(val))
                return false;
            indexMap.put(size, val);
            dataMap.put(val, size);
            size++;
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (dataMap.containsKey(val)) {
                size--;
                Integer index = dataMap.get(val);
                Integer finalData = indexMap.get(size);
                dataMap.put(finalData, index);
                indexMap.put(index, finalData);
                dataMap.remove(val);
                indexMap.remove(size);

                return true;
            } else {
                return false;
            }
        }

        /** Get a random element from the set. */
        public int getRandom() {
            int i = (int) (Math.random() * size);
            return indexMap.get(i);
        }
    }
}
