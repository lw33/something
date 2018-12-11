package lw.learn.lc.medium;

import org.junit.Test;

import java.util.TreeSet;

/**
 * @Author lw
 * @Date 2018-11-13 21:38:29
 **/
public class P220_ContainsNearbyAlmostDuplicateII {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {

            if (set.ceiling((long)nums[i] - t) != null && set.ceiling((long)nums[i] - t) <= (long)nums[i] + t )
                return true;

            set.add((long) nums[i]);

            if (set.size() == k+1)
                set.remove((long)nums[i - k]);
        }

        return false;
    }

    @Test
    public void test() {
        int a = 0x7fffffff;
        System.out.println(a);
        System.out.println((long)a + 1);
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(3);
        System.out.println(treeSet.ceiling(1));

    }
}
