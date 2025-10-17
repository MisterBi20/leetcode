package day22;

//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

import java.util.Scanner;

public class Ex70 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Ex70 ex70 = new Ex70();
        int result = ex70.climbStairs(n);
        System.out.println(result);
    }

    //    考虑怎么到达第n阶楼梯，只能从第n-1阶或第n-2阶到达，所以到达第n阶的方法数为到达第n-1阶的方法数加上到达第n-2阶的方法数。
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}
