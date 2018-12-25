package lw.learn.lc.medium;

import lw.learn.utils.JSON2Java;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author lw
 * @Date 2018-12-24 01:07:01
 **/
public class P452_MinimumNumberOfArrowsToBurstBalloons {

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int cnt = 1;
        int last = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > last) {
                cnt++;
                last = points[i][1];
            }
        }
        return cnt;
    }
    
    @Test
    public void test() {
        int[][] ints = JSON2Java.json2int2Array("[[10,16], [2,8], [1,6], [7,12]]");
        System.out.println(this.findMinArrowShots(ints));
    }
}
