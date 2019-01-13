package lw.learn.lc.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2019-01-13 22:58:20
 **/
public class P16_3SumClosest {

    /**
     * 选出离 target 最近的3数和
     * 先排序 再使用双指针
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {

        int res = 0;
        int min = Integer.MAX_VALUE;
        // 排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 跳过与前一个数相同的数
            if(i>0 && nums[i] == nums[i-1])
                continue;
            // start
            int start = i + 1;
            // end
            int end = nums.length - 1;
            while (end > start) {
                int tmp = nums[i] + nums[start] + nums[end];
                // 如果比target大 则end--
                if (tmp > target) {
                    --end;
                } else if (tmp < target) {
                    ++start;

                } else {
                    // 如果结果为target 则直接返回target
                    return target;
                }
                // 比较
                int sub = Math.abs(target - tmp);
                if (min > sub) {
                    min = sub;
                    res = tmp;
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] arr = {0,1,2};
        int target = 3;
        System.out.println(this.threeSumClosest(arr, target));
    }
}
