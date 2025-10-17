package day22;

/*给定一个 m x n 的整数数组 grid。一个机器人初始位于 左上角（即 grid[0][0]）。
        机器人尝试移动到 右下角（即 grid[m - 1][n - 1]）。机器人每次只能向下或者向右移动一步。
        网格中的障碍物和空位置分别用 1 和 0 来表示。机器人的移动路径中不能包含 任何 有障碍物的方格。
        返回机器人能够到达右下角的不同路径数量。
        测试用例保证答案小于等于 2 * 109。*/

import java.util.Scanner;

public class Ex63 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] obstacleGrid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                obstacleGrid[i][j] = scanner.nextInt();
            }
        }
        Ex63 ex63 = new Ex63();
        System.out.println(ex63.uniquePathsWithObstacles(obstacleGrid));
    }

    /*      动态规划，dp[i][j]表示到达第i行第j列的不同路径数，dp[i][j]=dp[i-1][j]+dp[i][j-1],
            初始化dp[0][0]=1,如果obstacleGrid[0][0]=1,则dp[0][0]=0,
            否则dp[0][0]=1,
            遍历网格，若obstacleGrid[i][j]=1,则dp[i][j]=0,
            否则dp[i][j]=dp[i-1][j]+dp[i][j-1],
            返回dp[m-1][n-1].*/
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1) return 0;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) continue;
                if (i > 0) dp[i][j] += dp[i - 1][j];
                if (j > 0) dp[i][j] += dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
