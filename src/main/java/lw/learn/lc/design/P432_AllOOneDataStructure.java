package lw.learn.lc.design;

import java.util.LinkedList;
import java.util.Map;

/**
 * @Author lw
 * @Date 2019-01-06 22:38:29
 **/
public class P432_AllOOneDataStructure {

    class AllOne {

        class Node {
            Map<String, Node> map;
            String key;
            int freq;
        }

        LinkedList<Node> list;


        /** Initialize your data structure here. */
        public AllOne() {

        }

        /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
        public void inc(String key) {

        }

        /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
        public void dec(String key) {

        }

        /** Returns one of the keys with maximal value. */
        public String getMaxKey() {

            return "";
        }

        /** Returns one of the keys with Minimal value. */
        public String getMinKey() {
            return "";
        }
    }
}
