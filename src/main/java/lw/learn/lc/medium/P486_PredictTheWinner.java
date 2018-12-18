package lw.learn.lc.medium;

/**
 * @Author lw
 * @Date 2018-12-18 11:13:17
 **/
// FIXME 2018/12/18  可以更快
public class P486_PredictTheWinner {

    public boolean PredictTheWinner1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int f = f1(nums, 0, nums.length - 1);
        if (sum - f <= f) {
            return true;
        } else {
            return false;
        }
    }

    private int f2(int[] nums, int i, int j) {
        if (i == j) {
            return nums[i];
        }
        if (i + 1 == j) {
            return Math.max(nums[i], nums[j]);
        }
        return Math.max(nums[i] + Math.min(f2(nums, i + 2, j), f2(nums, i + 1, j - 1))
                            , nums[j] + Math.min(f2(nums, i + 1, j - 1), f2(nums, i, j - 2)));
    }

    private int f1(int[] nums, int i, int j) {
        if (i == j) {
            return nums[i];
        }
        return Math.max(nums[i] + s(nums, i + 1, j), nums[j] + s(nums, i, j - 1));
    }

    private int s(int[] nums, int i, int j) {
        if (i == j) {
            return 0;
        }
        return Math.min(f1(nums, i + 1, j), f1(nums, i, j - 1));
    }
}
