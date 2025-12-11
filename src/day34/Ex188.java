package day34;

/*给你一个整数数组 prices 和一个整数 k ，其中 prices[i] 是某支给定的股票在第 i 天的价格。
设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。*/

public class Ex188 {
    public static void main(String[] args) {
        int k = 2;
        int[] prices =new  int[]{3,2,6,5,0,3};
        Ex188 ex188 = new Ex188();
        System.out.println(ex188.maxProfit(k,prices));
    }
//    动态规划，定义多个天数，参考Ex123
    public int maxProfit(int k,int[] prices){
        if (prices.length==0)return 0;
        int len = prices.length;
        int[][] dp = new int[len][k*2+1];
        for (int i = 1; i < k*2; i+=2) {
            dp[0][i]=-prices[0];
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < k*2-1; j+=2) {
                dp[i][j+1]=Math.max(dp[i-1][j+1],dp[i-1][j]-prices[i]);
                dp[i][j+2]=Math.max(dp[i-1][j+2],dp[i-1][j+1]+prices[i]);
            }
        }
        return dp[len-1][k*2];
    }
}
