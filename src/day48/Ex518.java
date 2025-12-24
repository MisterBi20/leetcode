package day48;

/*给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
假设每一种面额的硬币有无限个。
题目数据保证结果符合 32 位带符号整数。*/

public class Ex518 {
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};
        Ex518 ex518 = new Ex518();
        int i = ex518.change(amount, coins);
        System.out.println(i);
    }

    //    动态规划，dp[i][j]表示使用前i个硬币凑成金额j的组合数，
//    所以dp[i][j]的状态转移方程为：
//    如果j<coins[i]，那么dp[i][j]=dp[i-1][j]；
//    如果j>=coins[i]，那么dp[i][j]=dp[i-1][j]+dp[i][j-coins[i]]；
//    所以，最终的结果为dp[coins.length-1][amount]。
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            dp[i][0] = 1;
        }
        for (int j = coins[0]; j <= amount; j++) {
            dp[0][j] = dp[0][j - coins[0]];
        }
        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j < coins[i]) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = dp[i][j - coins[i]] + dp[i - 1][j];
            }
        }
        return dp[coins.length - 1][amount];
    }
}
