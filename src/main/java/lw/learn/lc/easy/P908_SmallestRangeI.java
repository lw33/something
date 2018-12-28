package lw.learn.lc.easy;

/**
 * @Author lw
 * @Date 2018-12-28 00:48:00
 **/
public class P908_SmallestRangeI {

    public int smallestRangeI(int[] A, int K) {

        // 找到最大值与最小值
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : A) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        // 最大值与最小值之间的差距
        int interval = max - min;
        // 2倍的 K 减去 interval
        int res = 2 * K - interval;
        // 如果结果大于或者等于0 则可凑成所有数相等 否则只能 将最大数减 K 最小数加 K 结果为 -res
        return res >= 0 ? 0 : -res;
    }
}
