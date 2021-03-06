package lw.learn.lc.easy;


import java.util.HashMap;

/**
 * @Author lw
 * @Date 2018-11-24 23:14:45
 **/
public class P169_MajorityElement {

    public int majorityElement666(int[] nums) {
        int count = 1;
        int candidate = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != candidate) {
                if (count == 0) {
                    candidate = nums[i];
                } else {
                    --count;
                }

            } else {
                ++count;
            }
        }
        return candidate;
    }

    public int majorityElement(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        Integer res;
        for (int num : nums) {
            res = map.get(num);
            if (res == null) {
                map.put(num, 1);
            } else {
                map.put(num, res + 1);
                if (res >= nums.length / 2) {
                    return num;
                }
            }
        }
        return 0;
    }
}
