package lw.learn.lc.medium;

/**
 *
 * @Author lw
 * @Date 2018-11-29 14:49:57
 *
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 *
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 *
 **/
public class MaxProfit_309 {

    public int maxProfit(int[] prices) {

        maxP(prices, 0, true, false, 0);
        return 0;
    }

    public int maxP(int[] prices, int index, boolean canBuy, boolean frozen, int pre) {

        if (prices.length == index) {
            return -pre;
        }

        int res = 0;

        for (int i = index; i < prices.length; i++) {
            if (frozen) {
                res = Math.max(res,maxP(prices, index + 1, true, false, pre));
            } else if (canBuy) {
                res = Math.max(res, maxP(prices, index + 1, true, false, pre));
                res += Math.max(res, maxP(prices, index + 1, false, true, pre));
            } else {
                res = Math.max(res, maxP(prices, index + 1, true, false, pre));
            }
        }
        return res;
    }
}
