package lw.learn.lc.stack.medium;

import lw.learn.lc.ds.NestedInteger;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author lw
 * @Date 2019-01-04 22:39:14
 **/
public class P341_FlattenNestedListIterator {
    class NestedIterator implements Iterator<Integer> {

        private LinkedList<Integer> queue = new LinkedList<>();

        public NestedIterator(List<NestedInteger> nestedList) {
            for (NestedInteger nestedInteger : nestedList) {
                add(nestedInteger);
            }
        }

        private void add(NestedInteger nestedInteger) {
            if (nestedInteger.isInteger()) {
                queue.offer(nestedInteger.getInteger());
            } else {
                for (NestedInteger integer : nestedInteger.getList()) {
                    add(integer);
                }
            }
        }

        @Override
        public Integer next() {
            return queue.poll();
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }
    }


}
