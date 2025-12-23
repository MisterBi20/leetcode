package day47;

/*给你一个非负整数数组 nums 和一个整数 target 。
向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。*/

public class Ex494 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        Ex494 ex494 = new Ex494();
        int targetSumWays = ex494.findTargetSumWays(nums, target);
        System.out.println(targetSumWays);
    }

    //    动态规划，01背包问题，背包容量为left，物品为nums，每个物品的重量为nums[i]，每个物品的价值为1，求背包容量为left时的最大价值，
//    最后返回dp[nums.length-1][left]即可
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum < Math.abs(target)) return 0;
        if ((sum + target) % 2 != 0) return 0;
        int left = (sum + target) / 2;
        int[][] dp = new int[nums.length][left + 1];
        if (nums[0] <= left) dp[0][nums[0]] = 1;
        int numZeros = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) numZeros++;
            dp[i][0] = (int) Math.pow(2, numZeros);
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= left; j++) {
                if (nums[i] > j) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]];
            }
        }
        return dp[nums.length - 1][left];
    }
}
