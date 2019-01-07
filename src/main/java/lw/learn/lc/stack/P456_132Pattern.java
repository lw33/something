package lw.learn.lc.stack;


import org.junit.Test;

import java.util.LinkedList;

/**
 * @Author lw
 * @Date 2019-01-04 10:43:23
 * @tag medium
 **/
public class P456_132Pattern {

    /**
     * 首先第二个数最大 而第三个数 找 第二个数中 右边比第第二个数小的最大的数
     * 将元素逆序放入栈中
     * 栈中的元素 大 --> 小 单调存放
     * 碰到比栈顶元素大的值 将栈顶弹出 弹出的值可能是第三个数 loop
     * 比较第三个数与当前数
     * @param nums
     * @return
     */
    public boolean find132pattern(int[] nums) {

        if (nums.length < 3) {
            return false;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        // 初始化第三个数 为最小整数
        int third = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {
            // 如果第三个数比当前数大
            if (third > nums[i])
                return true;
            // 如果栈不为空且栈顶元素小于当前数
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                // 弹出的数可能是最大的第三个数
                third = stack.pop();
            }
            // 将当前数入栈
            stack.push(nums[i]);
        }
        return false;
    }

    @Test
    public void test() {
        int[] arr = {3, 5, 0, 3, 4};
        System.out.println(this.find132pattern(arr));
    }
}
