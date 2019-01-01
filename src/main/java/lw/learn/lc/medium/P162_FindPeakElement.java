package lw.learn.lc.medium;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-01-01 00:48:13
 **/
public class P162_FindPeakElement {

    public int findPeakElement(int[] nums) {

        int low = 0;
        int high = nums.length - 1;
        //当两者相等时，
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] < nums[mid + 1])
                low = mid + 1;  //注意为什么要+1，因为mid位置一定不是峰，而low=mid+1有可能是峰
            else
                high = mid;      //注意这里为什么不加+，因为high=mid有可能是峰
        }
        return low;
    }

    @Test
    public void test() {
        int[] arr = {1, 2, 1, 3, 4, 5, 5, 5};
        System.out.println(this.findPeakElement(arr));
    }
}
