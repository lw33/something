package lw.learn.lc.medium;

import org.junit.Test;


/**
 * @Author lw
 * @Date 2018-11-29 14:49:57
 * <p>
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * <p>
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * <p>
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 * <p>
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 **/
// TODO: 2018/11/30 待实现
public class MaxProfit_309 {

    public int maxProfit(int[] prices) {
        return maxP(prices, 0, true, false, 0);
    }

    public int maxP(int[] prices, int index, boolean canBuy, boolean frozen, int pre) {

        if (prices.length == index) {
            return 0;
        }

        if (frozen) {

            return maxP(prices, index + 1, true, false, 0);
        } else if (canBuy) {

            int donotBuy = maxP(prices, index + 1, true, false, 0);
            int buy = maxP(prices, index + 1, false, false, prices[index]);
            return Math.max(donotBuy, buy);
        } else {

            int ns = maxP(prices, index + 1, false, false, pre);
            int s = prices[index] - pre + maxP(prices, index + 1, true, true, 0);
            return Math.max(ns, s);
        }
    }

    @Test
    public void test() {
        int[] arr = {1,2,4};
        System.out.println(this.maxProfit(arr));
    }
}
