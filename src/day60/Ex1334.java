package day60;

/*有 n 个城市，按从 0 到 n-1 编号。给你一个边数组 edges，其中 edges[i] = [fromi, toi, weighti] 代表 fromi 和 toi 两个城市之间的双向加权边，距离阈值是一个整数 distanceThreshold。
        返回在路径距离限制为 distanceThreshold 以内可到达城市最少的城市。如果有多个这样的城市，则返回编号最大的城市。
        注意，连接城市 i 和 j 的路径的距离等于沿该路径的所有边的权重之和。*/

import java.util.Arrays;

public class Ex1334 {
    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}};
        int distanceThreshold = 4;
        Ex1334 ex1334 = new Ex1334();
        int res = ex1334.findTheCity(n, edges, distanceThreshold);
        System.out.println(res);
    }

    //    动态规划，memo[k][i][j]表示从i到j经过不超过k步的最短路径长度，
//    若k<0，则表示从i到j经过0步的最短路径长度，即w[i][j]，
//    若k>=0，则表示从i到j经过不超过k步的最短路径长度，即min(memo[k-1][i][j],memo[k-1][k][j])，
//    其中memo[k-1][i][j]表示从i到j经过不超过k-1步的最短路径长度，memo[k-1][k][j]表示从k到j经过不超过k-1步的最短路径长度。
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] w = new int[n][n];
        for (int[] row : w) {
            Arrays.fill(row, Integer.MAX_VALUE / 2);
        }
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1], wt = edge[2];
            w[x][y] = w[y][x] = wt;
        }
        int[][][] memo = new int[n][n][n];
        int ans = 0;
        int minCnt = n;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (j != i && dfs(n - 1, i, j, memo, w) <= distanceThreshold)
                    cnt++;
            }
            if (cnt <= minCnt) {
                minCnt = cnt;
                ans = i;
            }
        }
        return ans;
    }

    private int dfs(int k, int i, int j, int[][][] memo, int[][] w) {
        if (k < 0) return w[i][j];
        if (memo[k][i][j] != 0) return memo[k][i][j];
        return memo[k][i][j] = Math.min(dfs(k - 1, i, j, memo, w), dfs(k - 1, i, k, memo, w) + dfs(k - 1, k, j, memo, w));
    }
}
