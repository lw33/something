package lw.learn.p;

import lw.learn.utils.SortUtil;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-10-08 11:15:52
 **/
public class Coin {

    public int coins1(int[] arr, int aim) {
        if (SortUtil.isEmptyOrLength(arr) || aim < 0) {
            return 0;
        }
        return process1(arr, 0, aim);
    }

    public int process1(int[] arr, int index, int aim) {
        int res = 0;
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            for (int i = 0; arr[index] * i <= aim; i++) {
                res += process1(arr, index + 1, aim - arr[index] * i);
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] arr = {5, 10, 25, 1};
        System.out.println(coins1(arr, 2));
    }
}
