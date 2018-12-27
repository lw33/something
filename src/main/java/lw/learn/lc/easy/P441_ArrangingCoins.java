package lw.learn.lc.easy;

/**
 * @Author lw
 * @Date 2018-12-27 00:50:14
 **/
public class P441_ArrangingCoins {

    public int arrangeCoins(int n) {

        int count = 0;
        while (n >= count + 1) {
            n -= ++count;
        }
        return count;
    }
}
