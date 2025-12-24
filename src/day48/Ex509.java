package day48;

/*斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。
该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
F(0) = 0，F(1) = 1
F(n) = F(n - 1) + F(n - 2)，其中 n > 1
给定 n ，请计算 F(n)*/

public class Ex509 {
    public static void main(String[] args) {
        int n = 4;
        Ex509 ex509 = new Ex509();
        int fib = ex509.fib(n);
        System.out.println(fib);
    }

    //    动态规划，dp[i]表示第i个斐波那契数，dp[i]=dp[i-1]+dp[i-2]
    public int fib(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
