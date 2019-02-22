package lw.learn.lc.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lw
 * @Date 2019-01-27 21:17:30
 **/
public class P306_AdditiveNumber {

    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3) {
            return false;
        }
        char[] nums = num.toCharArray();
        List<Integer> list = new ArrayList<>();
        return isAdditiveNumber(nums, 0, list);
    }

    private boolean isAdditiveNumber(char[] nums, int index, List<Integer> list) {
        if (list.size() >= 3) {
            int size = list.size();
            if (list.get(size - 1) != list.get(size - 2) + list.get(size - 3)) {
                return false;
            }
        }
        if (nums.length == index) {
            if (list.size() < 3) {
                return false;
            }
            int size = list.size();
            return list.get(size - 1) == list.get(size - 2) + list.get(size - 3);
        }
        int ins = 0;
        for (int i = index; i < nums.length; i++) {

            ins = ins * 10 + nums[i] - '0';

            if (i > index && nums[i] != '0' && nums[i - 1] == '0') {
                return false;
            }
            list.add(ins);
            if (isAdditiveNumber(nums, i + 1, list)) {
                return true;
            }
            list.remove(list.size() - 1);
        }
        return false;
    }

    @Test
    public void test() {
        String s = "1023";
        System.out.println(this.isAdditiveNumber(s));
    }
}
