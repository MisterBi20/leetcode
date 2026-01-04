package day59;

/*给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。*/

public class Ex1143 {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        Ex1143 ex1143 = new Ex1143();
        System.out.println(ex1143.longestCommonSubsequence(text1, text2));
    }

    //    动态规划，dp[i][j]表示text1的前i个字符和text2的前j个字符的最长公共子序列的长度，
//    其中dp[i][j]的状态转移方程为：
//    如果text1[i-1]==text2[j-1]，则dp[i][j]=dp[i-1][j-1]+1;
//    如果text1[i-1]!=text2[j-1]，则dp[i][j]=max(dp[i-1][j],dp[i][j-1]);
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            char char1 = text1.charAt(i - 1);
            for (int j = 1; j <= text2.length(); j++) {
                char char2 = text2.charAt(j - 1);
                if (char1 == char2) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }

        }
        return dp[text1.length()][text2.length()];
    }
}
