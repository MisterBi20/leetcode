package day58;

/*在两条独立的水平线上按给定的顺序写下 nums1 和 nums2 中的整数。
现在，可以绘制一些连接两个数字 nums1[i] 和 nums2[j] 的直线，这些直线需要同时满足：
nums1[i] == nums2[j]
且绘制的直线不与任何其他连线（非水平线）相交。
请注意，连线即使在端点也不能相交：每个数字只能属于一条连线。
以这种方法绘制线条，并返回可以绘制的最大连线数。*/

public class Ex1035 {
    public static void main(String[] args) {
        int[] nums1 = {1, 4, 2};
        int[] nums2 = {1, 2, 4};
        Ex1035 ex1035 = new Ex1035();
        int res = ex1035.maxUncrossedLines(nums1, nums2);
        System.out.println(res);
    }

    //    动态规划，
//    定义一个二维数组dp，其中dp[i][j]表示nums1的前i个元素和nums2的前j个元素的最大连线数。
//    初始化dp[0][j]和dp[i][0]为0，因为空数组和任何数组的最大连线数都为0。
//    遍历nums1和nums2，当nums1[i-1]等于nums2[j-1]时，dp[i][j]等于dp[i-1][j-1]+1；否则，dp[i][j]等于dp[i-1][j]和dp[i][j-1]的较大值。
//    返回dp[len1][len2]，即nums1和nums2的最大连线数。
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (nums1[i - 1] == nums2[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[len1][len2];
    }
}
