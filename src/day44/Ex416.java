package day44;

//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

public class Ex416 {
    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        Ex416 ex416 = new Ex416();
        boolean b = ex416.canPartition(nums);
        System.out.println(b);
    }

    //    动态规划，01背包问题，背包容量为sum/2，物品为nums，物品重量为nums[i]，物品价值也为nums[i]，
//    所以dp[j]表示背包容量为j时，能够装下的最大价值，最后判断dp[target]是否等于target即可，
//    如果等于target，说明能够将数组分割成两个子集，使得两个子集的元素和相等，
//    否则，说明不能将数组分割成两个子集，使得两个子集的元素和相等。
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < n; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
            if (dp[target] == target) return true;
        }
        return dp[target] == target;
    }
}
