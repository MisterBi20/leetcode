package day55;

/*给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。
一旦你支付此费用，即可选择向上爬一个或者两个台阶。
你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
请你计算并返回达到楼梯顶部的最低花费。*/

public class Ex746 {
    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        Ex746 ex746 = new Ex746();
        int res = ex746.minCostClimbingStairs(cost);
        System.out.println(res);
    }

    //    动态规划，dp[i]表示到达第i个台阶的最低花费，dp[i]=min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2])
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= len; i++) dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        return dp[len];
    }
}
