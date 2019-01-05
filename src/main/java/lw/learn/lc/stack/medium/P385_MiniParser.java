package lw.learn.lc.stack.medium;


import java.util.ArrayList;
import java.util.List;

/**
 * @Author lw
 * @Date 2019-01-05 17:24:22
 **/
public class P385_MiniParser {

    public NestedInteger deserialize(String s) {

        return new NestedIntegerImpl();
    }

    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        List<NestedInteger> getList();
    }

    class NestedIntegerImpl implements NestedInteger {

        private List<NestedInteger> nestedIntegers;
        private Integer value = null;
        // Constructor initializes an empty nested list.
        public NestedIntegerImpl() {
            nestedIntegers = new ArrayList<>();
        }

        // Constructor initializes a single integer.
        public NestedIntegerImpl(int value) {
            this.value = value;
        }

        @Override
        public boolean isInteger() {
            return nestedIntegers == null;
        }

        @Override
        public Integer getInteger() {
            return value;
        }

        @Override
        public void setInteger(int value) {
            if (nestedIntegers != null) {
                return;
            }
            this.value = value;
        }

        @Override
        public void add(NestedInteger ni) {
            if (nestedIntegers != null) {
                nestedIntegers.add(ni);
            }
        }

        @Override
        public List<NestedInteger> getList() {
            return nestedIntegers;
        }
    }
}
