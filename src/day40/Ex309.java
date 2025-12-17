package day40;

/*给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格
        设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
        卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
        注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。*/

public class Ex309 {
    public static void main(String[] args) {
        int[] princes = {1, 2, 3, 0, 2};
        Ex309 ex309 = new Ex309();
        System.out.println(ex309.maxProfit(princes));
    }

    //    动态规划，定义dp[i][4]数组，i表示第i天，4表示4种状态
//    dp[i][0]表示第i天持有股票的最大利润
//    dp[i][1]表示第i天不持有股票,且不处于冷冻期的最大利润
//    dp[i][2]表示第i天不持有股票,且下一天处于冷冻期的最大利润
//    dp[i][3]表示第i天不持有股票,且处于冷冻期的最大利润
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int dp[][] = new int[len][4];
        dp[0][0] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]), dp[i - 1][3] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            dp[i][2] = dp[i - 1][0] + prices[i];
            dp[i][3] = dp[i - 1][2];
        }
        return Math.max(Math.max(dp[len - 1][1], dp[len - 1][2]), dp[len - 1][3]);
    }
}
