package lw.learn.p.unkonw;

import lw.learn.utils.SortUtil;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2018-11-19 15:11:41
 **/
public class NetherlandsFlag {

    public int[] partition(int[] arr, int start, int end, int target) {

        int less = start - 1;   // [0, less]
        int more = end + 1; //  [more, end]
        int cur = start;
        while (cur < more) {
            if (arr[cur] > target) {
                SortUtil.swap(arr, cur, --more);
            } else if (arr[cur] < target) {
                SortUtil.swap(arr, cur++, ++less);
            } else {
                cur++;
            }
        }

        return new int[]{less, more};
    }

    @Test
    public void test() {
        int[] arr = {1, 2, 3, 1, 1, 3, 3, -1};
        System.out.println(Arrays.toString(this.partition(arr, 0, arr.length - 1, 2)));
        System.out.println(Arrays.toString(arr));
    }
}
