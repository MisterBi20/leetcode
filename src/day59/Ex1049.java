package day59;

/*有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
如果 x == y，那么两块石头都会被完全粉碎；
如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。*/

public class Ex1049 {
    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
        Ex1049 ex1049 = new Ex1049();
        System.out.println(ex1049.lastStoneWeightII(stones));
    }
//    动态规划，将石头分成两堆，使两堆石头的重量差最小，即两堆石头的重量最接近sum/2,
//    则最后剩下的石头重量最小为sum-2*dp[target]
//    其中dp[j]表示前i个石头中能够凑成重量为j的最大重量
    public int lastStoneWeightII(int[] stones){
        int sum = 0;
        for (int stone : stones) {
            sum+=stone;
        }
        int target = sum/2;
        int[] dp = new int[target+1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }
        return sum-2*dp[target];
    }
}
