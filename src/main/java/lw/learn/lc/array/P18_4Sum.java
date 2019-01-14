package lw.learn.lc.array;

import lw.learn.utils.JSON2Java;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author lw
 * @Date 2019-01-13 23:17:28
 **/
public class P18_4Sum {

    /**
     * 排序后使用双指针
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            if (nums[i] * 4 > target) break;// Too Big!!太大了，后续只能更大，可以直接结束循环；
            if (nums[i] + 3 * nums[nums.length - 1] < target) continue;//Too Small！太小了，当前值不需要再算，可以继续循环尝试后面的值。
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                if (nums[j] * 3 > target - nums[i]) break;//Too Big！ 注意此时不能结束i的循环，因为j是移动的 当j移动到后面的时候继续i循环也sum可能变小
                if (nums[j] + 2 * nums[nums.length - 1] < target - nums[i]) continue;// Too Small
                int tmp2 = nums[i] + nums[j];
                int start = j + 1;
                int end = nums.length - 1;
                while (end > start) {
                    int tmp4 = tmp2 + nums[start] + nums[end];
                    if (tmp4 > target) {
                        --end;
                    } else if (tmp4 < target) {
                        ++start;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                        ++start;
                        while (start > 0 && end > start && nums[start] == nums[start - 1])
                            ++start;
                        --end;
                        while (end < nums.length - 1 && end > start && nums[end] == nums[end + 1])
                            --end;
                    }
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] arr = JSON2Java.json2intArray("[4,-9,-2,-2,-7,9,9,5,10,-10,4,5,2,-4,-2,4,-9,5]");
        //int[] arr = {1, 1, 1, 1, 1, 1, 1, 1};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(this.fourSum(arr, -13));
    }
}
