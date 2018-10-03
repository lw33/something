package lw.learn.offer;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2018-10-02 20:10:44
 **/
public class P32_PrintContactMinNumber {

    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        if (numbers.length == 1) {
            return String.valueOf(numbers[0]);
        }

        Integer[] nums = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = numbers[i];
        }
        Arrays.sort(nums, (o1, o2) -> Integer.parseInt(o1 + "" + o2) - Integer.parseInt(o2 + "" + o1));

        StringBuilder sb = new StringBuilder();
        for (Integer num : nums) {
            sb.append(num);
        }
        return sb.toString();
    }
}
