package lw.learn.lc.easy;


import java.util.HashSet;

/**
 * @Author lw
 * @Date 2018-11-13 20:54:39
 **/
public class P219_ContainsNearbyDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashSet<Integer> set = new HashSet<>(k * 2);

        for (int i = 0; i < nums.length; i++) {

            if (set.contains(nums[i]))
                return true;
            set.add(nums[i]);
            if (set.size() == k + 1)
                set.remove(nums[i - k]);
        }

        return false;
    }
}
