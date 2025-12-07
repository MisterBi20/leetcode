package day30;

/*
给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。然而，你可以在 同一天 多次买卖该股票，但要确保你持有的股票不超过一股。
返回 你能获得的 最大 利润 。
*/

import java.util.Scanner;

public class Ex122 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] prices = new int[num];
        for (int i = 0; i < num; i++) {
            prices[i] = sc.nextInt();
        }
        Ex122 ex122 = new Ex122();
        System.out.println(ex122.maxProfit(prices));
    }

    //贪心算法，把每个一天的盈利都加起来
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            res += Math.max(prices[i] - prices[i - 1], 0);
        }
        return res;
    }
}
