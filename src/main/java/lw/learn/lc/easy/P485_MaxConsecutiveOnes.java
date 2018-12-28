package lw.learn.lc.easy;

/**
 * @Author lw
 * @Date 2018-12-27 14:06:58
 **/
public class P485_MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {

        int count = 0;
        int max = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                //max = Math.max(count, max);
                max = max > count ? max : count;
                count = 0;
            }
        }
        //max = Math.max(max, count);
        //max = max > count ? max : count;
        return max > count ? max : count;
    }

}
