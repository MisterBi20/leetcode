package day40;

/*给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
        完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。
        例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。*/

public class Ex279 {
    public static void main(String[] args) {
        Ex279 ex279 = new Ex279();
        System.out.println(ex279.numSquares(12));
    }

    //    背包问题，动态规划，完全平方数，每个数可以用多次，求最少的数的平方和为n，返回最少的数的平方和
    public int numSquares(int n) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = max;
        }
        dp[0] = 0;
        for (int i = 1; i * i <= n; i++) {
            for (int j = i * i; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[n];
    }
}
