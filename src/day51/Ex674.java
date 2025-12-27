package day51;

/*给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，
都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。*/

public class Ex674 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 7};
        Ex674 ex674 = new Ex674();
        System.out.println(ex674.findLengthOfLCIS(nums));
    }

    //    动态规划，dp[i]表示以nums[i]结尾的连续递增子序列的长度，
//    初始化dp[i]=1，遍历数组，如果nums[i+1]>nums[i]，dp[i+1]=dp[i]+1，
//    最后返回dp数组中的最大值。
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        int res = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) dp[i + 1] = dp[i] + 1;
            res = Math.max(res, dp[i + 1]);
        }
        return res;
    }
}
