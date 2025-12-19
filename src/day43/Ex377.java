package day43;

/*给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。
        请你从 nums 中找出并返回总和为 target 的元素组合的个数。
        题目数据保证答案符合 32 位整数范围。*/

public class Ex377 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int target = 4;
        Ex377 ex377 = new Ex377();
        int combinationSum4 = ex377.combinationSum4(nums, target);
        System.out.println(combinationSum4);
    }
//    动态规划，dp[i]表示目标为i的组合数，遍历nums数组，
//    当i大于等于nums[j]时，dp[i]可以由dp[i-nums[j]]转移而来，
//    即dp[i] += dp[i-nums[j]]。
    public int combinationSum4(int[] nums,int target){
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]){
                    dp[i]+=dp[i-nums[j]];
                }
            }
        }
        return dp[target];
    }
}
