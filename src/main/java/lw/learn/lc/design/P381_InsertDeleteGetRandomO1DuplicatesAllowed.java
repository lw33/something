package lw.learn.lc.design;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @Author lw
 * @Date 2019-02-24 10:29:12
 **/
public class P381_InsertDeleteGetRandomO1DuplicatesAllowed {

    class RandomizedCollection {

        HashMap<Integer, HashSet<Integer>> data2index;
        HashMap<Integer, Integer> index2data;
        int size;

        /**
         * Initialize your data structure here.
         */
        public RandomizedCollection() {
            data2index = new HashMap<>();
            index2data = new HashMap<>();
            size = 0;
        }

        /**
         * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
         */
        public boolean insert(int val) {
            boolean res = true;
            if (data2index.containsKey(val)) {
                res = false;
            }
            index2data.put(size, val);
            HashSet<Integer> indexes = data2index.getOrDefault(val, new HashSet<>());
            indexes.add(size);
            data2index.put(val, indexes);
            size++;
            return res;
        }

        /**
         * Removes a value from the collection. Returns true if the collection contained the specified element.
         */
        public boolean remove(int val) {
            if (data2index.containsKey(val)) {
                // 取出 val 对应的 index 集合
                HashSet<Integer> set = data2index.get(val);
                Iterator<Integer> iterator = set.iterator();
                // 取出并删除 第一个索引
                Integer index = iterator.next();
                iterator.remove();
                // 如果空了。。。 则删除掉集合
                if (set.isEmpty()) {
                    data2index.remove(val);
                }
                // 如果删除的元素是最后一个 那就直接删
                if (index + 1 == size) {
                    index2data.remove(--size);
                    return true;
                }

                --size;
                // 取出最后一个数
                Integer lastVal = index2data.get(size);
                // 将数放入 index 对应的位置
                index2data.put(index, lastVal);
                // 删除最后一个数对应的索引
                data2index.get(lastVal).remove(size);
                // 添加最后一个数的索引
                data2index.get(lastVal).add(index);
                // 删除最后一位
                index2data.remove(size);
                return true;
            } else {
                return false;
            }
        }

        /**
         * Get a random element from the collection.
         */
        public int getRandom() {
            if (size == 0) {
                return -1;
            }
            int index = (int) (Math.random() * size);
            return index2data.get(index);
        }
    }

    @Test
    public void test() {
        RandomizedCollection collection = new RandomizedCollection();
        collection.insert(0);
        collection.remove(0);
        collection.insert(-1);
        collection.remove(0);
    }

}
