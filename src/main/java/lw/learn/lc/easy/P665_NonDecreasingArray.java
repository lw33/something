package lw.learn.lc.easy;

/**
 * @Author lw
 * @Date 2018-12-25 01:32:00
 **/
public class P665_NonDecreasingArray {

    public boolean checkPossibility(int[] nums) {
        int cnt = 0;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] > nums[i]) {
                cnt++;
                if (cnt == 2 || (cnt == 1 && i >= 2 && i < n - 1 && nums[i] < nums[i - 2] && nums[i + 1] < nums[i - 1])) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkPossibility1(int[] nums) {
        boolean modified = false;
        int n = nums.length - 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[i + 1]) {
                if (modified) {
                    return false;
                } else {
                    if (i - 1 < 0 || nums[i + 1] >= nums[i - 1])
                        nums[i] = nums[i + 1];
                    else
                        nums[i + 1] = nums[i];
                    modified = true;
                }
            }
        }
        return true;
    }

}
