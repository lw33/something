package lw.learn.offer;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @Author lw
 * @Date 2018-10-01 20:50:56
 * <p>
 * 题目描述
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 *
 **/
public class P21_IsPopOrder {

    public boolean IsPopOrder(int[] pushA, int[] popA) {

        if (pushA.length != popA.length) {
            return false;
        }

        LinkedList<Integer> stack = new LinkedList<>();

        int j = 0;
        for (int i = 0; i < pushA.length; i++) {
            if (pushA[i] == popA[j]) {
                j++;
            } else {
                stack.push(pushA[i]);
            }
        }
        while (!stack.isEmpty()) {
            if (stack.pop() != popA[j++]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {4, 5, 3, 2, 1};
        System.out.println(this.IsPopOrder(push, pop));
    }
}
