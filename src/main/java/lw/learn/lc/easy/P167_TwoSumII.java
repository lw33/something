package lw.learn.lc.easy;

/**
 * @Author lw
 * @Date 2018-11-13 15:31:11
 **/
public class P167_TwoSumII {

    public int[] twoSum(int[] numbers, int target) {

        // 对撞指针
        int l = 0;
        int r = numbers.length - 1;
        while (r > l) {
            int res = numbers[l] + numbers[r];
            if (res == target) {
                return new int[]{l + 1, r + 1};
            } else if (res > target) {
                r--;
            } else {
                l++;
            }
        }
        return null;
    }
}
