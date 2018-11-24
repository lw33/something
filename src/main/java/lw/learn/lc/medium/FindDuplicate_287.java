package lw.learn.lc.medium;

/**
 * @Author lw
 * @Date 2018-11-24 20:09:23
 **/
public class FindDuplicate_287 {

    public int findDuplicate(int[] nums) {
        int[] records = new int[nums.length + 1];
        for (int num : nums) {
            if (records[num] == 1) {
                return num;
            }
            records[num]++;
        }
        return -1;
    }
}
