package lw.learn.lc.map;

/**
 * @Author lw
 * @Date 2019-01-21 22:03:01
 **/
public class P645_SetMismatch {

    public int[] findErrorNums(int[] nums) {
        int[] hash = new int[nums.length];
        int duplicate = 0;
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i] - 1;
            hash[index]++;
            if (hash[index] == 2) {
                duplicate = nums[i];
            }
        }
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] == 0) {
                return new int[]{duplicate, i + 1};
            }
        }
        return nums;
    }
}
