package lw.learn.lc.math;

/**
 * @Author lw
 * @Date 2019-01-30 22:29:20
 **/
public class P492_ConstructTheRectangle {

    public int[] constructRectangle(int area) {

        int n = (int) Math.sqrt(area);
        while (n >= 1) {
            if (area % n == 0) {
                return new int[]{area / n, n};
            }
            n--;
        }
        return null;
    }
}
