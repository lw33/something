package lw.learn.lc.easy;

/**
 * @Author lw
 * @Date 2018-12-06 22:22:51
 **/
public class MissingNumber_268 {

    public int missingNumber(int[] nums) {
        int[] bucket = new int[nums.length + 1];
        for (int num : nums) {
            bucket[num] = 1;
        }
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] == 0) {
                return i;
            }
        }
        return 0;
    }

    // TODO: 2018/12/6 666 
    public int missingNumber666(int[] nums) {
        int missing = nums.length;
        for(int i=0; i<nums.length; i++) {
            missing ^= nums[i] ^ i;
        }
        return missing;
    }
}
