package lw.learn.lc.array;

import lw.learn.lc.ds.IndexHeap;
import lw.learn.utils.LCUtils;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2019-01-30 22:42:57
 **/
public class P506_RelativeRanks {

    public String[] findRelativeRanks(int[] nums) {
        
        String[] res = new String[nums.length];
        if (nums.length == 0) {
            return res;
        }
        
        String[] medal = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        
        IndexHeap<Integer> ipq = new IndexHeap<>(nums.length, Integer::compareTo);
        for (int i = 0; i < nums.length; i++) {
            ipq.add(i, nums[i]);
        }
        
        int i = 0;
        for (; i < nums.length && i < medal.length; i++) {
            int index = ipq.pollIndex();
            res[index] = medal[i];
        }
        while (ipq.size() > 0) {
            int maxIndex = ipq.pollIndex();
            res[maxIndex] = String.valueOf(++i);
        }
        return res;
    }
    
    @Test
    public void test() {
        //int[] arr = LCUtils.stringToIntegerArray(" [5, 4, 3, 2, 8]");
        int[] arr = LCUtils.stringToIntegerArray(" [1]");
        System.out.println(Arrays.toString(this.findRelativeRanks(arr)));
    }
}
