package day25;

//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数

import java.util.Scanner;

public class Ex96 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Ex96 ex96 = new Ex96();
        int res = ex96.numTrees(n);
        System.out.println(res);
    }

    //动态规划，dp[i]表示i个节点的二叉搜索树的种数，dp[i] = dp[j-1]*dp[i-j]，j表示根节点的位置
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
