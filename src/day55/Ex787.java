package day55;

/*有 n 个城市通过一些航班连接。给你一个数组 flights ，
其中 flights[i] = [fromi, toi, pricei] ，表示该航班都从城市 fromi 开始，以价格 pricei 抵达 toi。
现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到出一条最多经过 k 站中转的路线，
使得从 src 到 dst 的 价格最便宜 ，并返回该价格。 如果不存在这样的路线，则输出 -1。*/

import java.util.Arrays;

public class Ex787 {
    public static void main(String[] args) {
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        int n = 4;
        int src = 0;
        int dst = 3;
        int k = 1;
        Ex787 ex787 = new Ex787();
        int res = ex787.findCheapestPrice(n, flights, src, dst, k);
        System.out.println(res);
    }

    //    动态规划
//    定义f[i][j]表示从src出发，经过i次航班，到达j城市的最小价格。
//    初始时f[0][src]=0，其他f[0][j]=INF。
//    状态转移方程为f[i][j]=min(f[i][j],f[i-1][from]+price)，其中from是j的前一个城市，price是从from到j的价格。
//    最终答案为f[k+1][dst]，如果f[k+1][dst]=INF，则返回-1。
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        final int INF = 10000 * 101 + 1;
        int[][] f = new int[k + 2][n];
        for (int i = 0; i < k + 2; i++) {
            Arrays.fill(f[i], INF);
        }
        f[0][src] = 0;
        for (int i = 1; i <= k + 1; i++) {
            for (int[] flight : flights) {
                int from = flight[0], to = flight[1], price = flight[2];
                f[i][to] = Math.min(f[i][to], f[i - 1][from] + price);
            }
        }
        int res = INF;
        for (int i = 1; i <= k + 1; i++) {
            res = Math.min(res, f[i][dst]);
        }
        return res == INF ? -1 : res;
    }
}
