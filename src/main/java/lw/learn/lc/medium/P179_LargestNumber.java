package lw.learn.lc.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author lw
 * @Date 2018-12-25 22:40:09
 **/
public class P179_LargestNumber {
    public String largestNumber(int[] nums) {
        boolean flag = true;
        Long[] integers = new Long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            integers[i] = (long) nums[i];
            if (flag && nums[i] != 0) {
                flag = false;
            }
        }
        if (flag) {
            return "0";
        }
        Arrays.sort(integers, new Comparator<Long>() {
            @Override
            public int compare(Long a, Long b) {
                Long i1 = Long.valueOf(a + "" + b);
                Long i2 = Long.valueOf(b + "" + a);
                if (i1.equals(i2)) {
                    return 0;
                }
                return -i1.compareTo(i2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Long integer : integers) {
            sb.append(integer);
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
