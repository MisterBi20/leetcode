package day41;

/*给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
返回 你可以获得的最大乘积 。*/

public class Ex343 {
    public static void main(String[] args) {
        int n = 10;
        Ex343 ex343 = new Ex343();
        int i = ex343.integerBreak(n);
        System.out.println(i);
    }

    //    动态规划，dp[i]表示整数i拆分后的最大乘积，dp[i]=max(dp[i],max(j*(i-j),j*dp[i-j]))
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i - j; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
