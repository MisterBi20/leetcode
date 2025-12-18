package day42;

/*如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为 摆动序列 。第一个差（如果存在的话）可能是正数或负数。仅有一个元素或者含两个不等元素的序列也视作摆动序列。
        例如， [1, 7, 4, 9, 2, 5] 是一个 摆动序列 ，因为差值 (6, -3, 5, -7, 3) 是正负交替出现的。
        相反，[1, 4, 7, 2, 5] 和 [1, 7, 4, 5, 5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
        子序列 可以通过从原始序列中删除一些（也可以不删除）元素来获得，剩下的元素保持其原始顺序。
        给你一个整数数组 nums ，返回 nums 中作为 摆动序列 的 最长子序列的长度 。*/

public class Ex376 {
    public static void main(String[] args) {
        int[] nums = {1, 7, 4, 9, 2, 5};
        Ex376 ex376 = new Ex376();
        System.out.println(ex376.wiggleMaxLength(nums));
    }

    //    动态规划，定义dp[i][2]数组，i表示第i天，2表示2种状态
//    dp[i][0]表示第i天作为波峰的最大长度
//    dp[i][1]表示第i天作为波谷的最大长度
    public int wiggleMaxLength(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][0] = dp[0][1] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = dp[i][1] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[i]) dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1); //i是波谷
                if (nums[j] < nums[i]) dp[i][0] = Math.max(dp[i][0], dp[j][1] + 1); //i是波峰
            }
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }

    //    贪心算法，定义curDiff表示当前差值，preDiff表示前一个差值，res表示结果
//    遍历数组，计算当前差值，判断是否是波峰或波谷
//    如果是波峰或波谷，res++，并更新preDiff为当前差值
//    最后返回res
    public int wiggleMaxLength2(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int curDiff = 0;
        int preDiff = 0;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            curDiff = nums[i] - nums[i - 1];
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                res++;
                preDiff = curDiff;
            }
        }
        return res;
    }
}
