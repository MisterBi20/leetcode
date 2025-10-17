package day22;

/*一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
        机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
        问总共有多少条不同的路径？*/

import java.util.Scanner;

public class Ex62 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ex62 ex62 = new Ex62();
        System.out.println("输入网格的行数：");
        int m = scanner.nextInt();
        System.out.println("输入网格的列数：");
        int n = scanner.nextInt();
        int uniquePaths = ex62.uniquePaths(m, n);
        System.out.println("不同的路径数为：" + uniquePaths);
    }

    //        动态规划，dp[i][j]表示到达第i行第j列的不同路径数，dp[i][j]=dp[i-1][j]+dp[i][j-1]
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
