package day51;

/*给定一个未排序的整数数组 nums ， 返回最长递增子序列的个数 。
注意 这个数列必须是 严格 递增的。*/

public class Ex673 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 7};
        Ex673 ex673 = new Ex673();
        int res = ex673.findNumberOfLIS(nums);
        System.out.println(res);
    }

    //    count[i]记录了以nums[i]为结尾的字符串，最长递增子序列的个数。
//    dp[i]记录了i之前（包括i）最长递增序列的长度,
//    maxCount记录了dp数组中的最大值,
//    res记录了dp数组中等于maxCount的元素的count数组中的值的总和。
    public int findNumberOfLIS(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) dp[i] = 1;
        int[] count = new int[nums.length];
        for (int i = 0; i < count.length; i++) count[i] = 1;
        int maxCount = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i])
                        count[i] += count[j];
                }
                if (dp[i] > maxCount) maxCount = dp[i];
            }
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxCount == dp[i]) res += count[i];
        }
        return res;
    }
}
