package lw.learn.lc.sort;

import lw.learn.utils.LCUtils;
import lw.learn.utils.SortUtil;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2019-03-11 20:00:50
 **/
public class P493_ReversePairs {

    // FIXME 2019/3/12  optimize
    public int reversePairs(int[] nums) {
        int[] aux = new int[nums.length];
        return mergeSort(nums, aux, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int[] aux, int start, int end) {
        if (end > start) {
            int mid = start + ((end - start) >> 1);
            return mergeSort(nums, aux, start, mid) +
                    mergeSort(nums, aux, mid + 1, end) +
                    merge(nums, aux, start, mid, end);
        }
        return 0;
    }

    private int merge(int[] nums, int[] aux, int start, int mid, int end) {

        int p1 = start;
        int p2 = mid + 1;
        int res = 0;
        int i = 0;

        while (p1 <= mid && p2 <= end) {

            // 如果都为负数
            if (nums[p1] < nums[p2] &&
                    nums[p2] < 0 &&
                    (long) nums[p1] > (2 * (long) nums[p2])) {

                int tmp = p2;
                // 向右扩 找所有成立的结果
                while (tmp <= end && (long) nums[p1] > (2 * (long) nums[tmp])) {
                    res++;
                    tmp++;
                }
                aux[i++] = nums[p1++];
                continue;
            }

            if (nums[p1] >= nums[p2]) {
                int tmp = p1;
                while (tmp <= mid) {
                    if ((long) nums[tmp] > (2 * (long) nums[p2])) {
                        res += mid - tmp + 1;
                        break;
                    }
                    tmp++;
                }
            }

            aux[i++] = nums[p1] < nums[p2] ? nums[p1++] : nums[p2++];
        }

        while (p1 <= mid) {
            aux[i++] = nums[p1++];
        }
        while (p2 <= end) {
            aux[i++] = nums[p2++];
        }
        System.arraycopy(aux, 0, nums, start, i);
        return res;
    }

    @Test
    public void test() {
        //int[] arr = LCUtils.stringToIntegerArray("[1,3,2,3,1]");
        //int[] arr = LCUtils.stringToIntegerArray("[2147483647,2147483647,-2147483647,-2147483647,-2147483647,2147483647]");
        int[] arr = LCUtils.stringToIntegerArray("[-264,-319,-253,-151]");
        System.out.println(this.reversePairs(arr));
        System.out.println(Arrays.toString(arr));
        System.out.println(SortUtil.isOrder(arr));
    }

}
