package lw.learn.lc.map;

import java.util.HashSet;

/**
 * @Author lw
 * @Date 2019-02-11 20:54:41
 **/
public class P575_DistributeCandies {

    public int distributeCandies(int[] candies) {

        HashSet<Integer> set = new HashSet<>();
        for (int candy : candies) {
            set.add(candy);
        }
        int i = candies.length / 2;
        return Math.min(i, set.size());
    }
}
