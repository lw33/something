package lw.learn.lc.hard;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @Author lw
 * @Date 2018-11-23 22:44:16
 **/
public class P293_MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || k < 1 || k > nums.length) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        LinkedList<Integer> dbQueue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!dbQueue.isEmpty() && nums[dbQueue.peekLast()] <= nums[i]) {
                dbQueue.pollLast();
            }
            dbQueue.addLast(i);
            if (i - k == dbQueue.peekFirst()) {
                dbQueue.pollFirst();
            }
            if (i >= k - 1) {
                res[index++] = nums[dbQueue.peekFirst()];
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        this.maxSlidingWindow(arr, 3);
    }
}
