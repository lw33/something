package lw.learn.lc.medium;

/**
 * @Author lw
 * @Date 2018-11-30 21:43:33
 **/
public class NthUglyNumber_264 {

    //  1, 2, 3, 4, 5, 6, 8, 9, 10, 12
    public int nthUglyNumber(int n) {

        if (n < 1) {
            return 0;
        }
        int[] uglyNumbers = new int[1695];
        uglyNumbers[0] = 0;
        uglyNumbers[1] = 1;
        uglyNumbers[2] = 2;
        for (int i = 0; i <= n; i++) {
            //uglyNumbers[i]
        }
        return 0;
    }
}
