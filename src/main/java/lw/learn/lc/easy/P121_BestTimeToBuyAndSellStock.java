package lw.learn.lc.easy;

/**
 * @Author lw
 * @Date 2019-01-01 01:52:41
 **/
public class P121_BestTimeToBuyAndSellStock {


    public int maxProfit(int[] prices) {

        int min = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            min = min > prices[i] ? prices[i] : min;
            int tmp = prices[i] - min;
            profit = tmp > profit ? tmp : profit;
        }
        return profit;
    }



}
