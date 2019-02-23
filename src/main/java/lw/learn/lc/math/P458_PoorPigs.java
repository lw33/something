package lw.learn.lc.math;

/**
 * @Author lw
 * @Date 2019-02-22 18:16:27
 **/
public class P458_PoorPigs {

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        // 测试轮数
        int round = minutesToTest / minutesToDie + 1;
        return (int) Math.ceil(Math.log(buckets) / Math.log(round));
    }
}
