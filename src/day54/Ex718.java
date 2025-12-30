package day54;

//给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。

public class Ex718 {
    public static void main(String[] args) {
        int[] num1 = {1, 2, 3, 2, 1};
        int[] num2 = {3, 2, 1, 4, 7};
        Ex718 ex718 = new Ex718();
        int res = ex718.findLength(num1, num2);
        System.out.println(res);
    }

    //    动态规划，dp[i][j]表示以下标i-1为结尾的A，和以下标j-1为结尾的B，最长重复子数组长度为dp[i][j]。
    public int findLength(int[] num1, int[] num2) {
        int res = 0;
        int[][] dp = new int[num1.length + 1][num2.length + 1];
        for (int i = 1; i < num1.length + 1; i++) {
            for (int j = 1; j < num2.length + 1; j++) {
                if (num1[i - 1] == num2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }
}
