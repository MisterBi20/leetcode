package day41;

/*给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
你可以认为每种硬币的数量是无限的。*/

public class Ex322 {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        Ex322 ex322 = new Ex322();
        int i = ex322.coinChange(coins, amount);
        System.out.println(i);
    }

    //    动态规划，dp[i]表示金额为i所需的最少硬币个数，dp[i]=min(dp[i],dp[i-coins[j]]+1)
    public int coinChange(int[] coins, int amount) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[amount + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = max;
        }
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] != max)
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }
}
