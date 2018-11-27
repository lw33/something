package lw.learn.lc.medium;

/**
 * @Author lw
 * @Date 2018-11-26 23:28:18
 **/
public class FindPoisonedDuration_495 {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries.length == 0)
            return 0;
        int sum = duration;
        for (int i = 1; i < timeSeries.length; i++) {
            int interval = timeSeries[i] - timeSeries[i - 1];
            sum += Math.min(interval, duration);
        }
        return sum;
    }
}
