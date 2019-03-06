package lw.learn.lc.array;

import lw.learn.utils.LCUtils;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2019-03-05 23:34:07
 **/
public class P274_HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            int x = citations.length - i;
            if (x <= citations[i]) {
                return x;
            }
        }
        return 0;
    }

    @Test
    public void test() {
        int[] arr = LCUtils.stringToIntegerArray("[3,0,6,1,5]");
        System.out.println(this.hIndex(arr));
    }
}
