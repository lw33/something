package lw.learn.lc.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-12-29 01:17:08
 **/
public class P228_SummaryRanges {

    public List<String> summaryRanges(int[] nums) {

        List<String> res = new ArrayList<>();
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] + 1 != nums[i]) {
                if (pre != nums[i - 1]) {
                    res.add(pre + "->" + nums[i - 1]);
                } else {
                    res.add(String.valueOf(pre));
                }
                pre = nums[i];
            }
        }
        if (pre != nums[nums.length - 1]) {
            res.add(pre + "->" + nums[nums.length - 1]);
        } else {
            res.add(String.valueOf(pre));
        }
        return res;
    }
}
