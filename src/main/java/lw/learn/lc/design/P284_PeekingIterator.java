package lw.learn.lc.design;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @Author lw
 * @Date 2019-01-06 16:28:06
 **/
public class P284_PeekingIterator {

    class PeekingIterator1 implements Iterator<Integer> {

        LinkedList<Integer> linkedList = new LinkedList<>();

        public PeekingIterator1(Iterator<Integer> iterator) {
            // initialize any member here.
            iterator.forEachRemaining(num -> linkedList.offer(num));
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return linkedList.peek();
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            return linkedList.poll();
        }

        @Override
        public boolean hasNext() {
            return linkedList.size() > 0;
        }
    }

    class PeekingIterator implements Iterator<Integer> {

        private Iterator<Integer> iterator;
        private Integer peek;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            this.iterator = iterator;
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            if (peek == null) {
                peek = iterator.next();
            }
            return peek;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            if (peek == null) {
                return iterator.next();
            }
            Integer tmp = peek;
            peek = null;
            return tmp;
        }

        @Override
        public boolean hasNext() {
            return peek != null || iterator.hasNext();
        }
    }
}
