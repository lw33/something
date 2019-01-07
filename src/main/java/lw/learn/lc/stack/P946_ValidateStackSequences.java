package lw.learn.lc.stack;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-01-04 22:47:26
 **/
public class P946_ValidateStackSequences {

    /**
     * 将 pushed 数组中的元素依次放入栈中
     * 维持一个 popped 数组索引 当 popped 数组中的数等于 栈顶数时 将栈顶弹出
     * 并将 popped 索引加 1
     * 如果是合法的序列 则最后 栈中的元素将全被弹出
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) {
            return false;
        }

        int[] stack = new int[popped.length];
        int size = 0;
        int j = 0;
        for (int i : pushed) {
            stack[size++] = i;
            while (size > 0 && stack[size - 1] == popped[j]) {
                --size;
                j++;
            }
        }
        return size == 0;
    }

    @Test
    public void test() {
        //pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};
        System.out.println(this.validateStackSequences(pushed, popped));
    }
}
