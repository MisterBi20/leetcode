package day48;

/*给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。*/

public class Ex516 {
    public static void main(String[] args) {
        String s = "bbbab";
        Ex516 ex516 = new Ex516();
        int i = ex516.longestPalindromeSubseq(s);
        System.out.println(i);
    }

    //    动态规划，dp[i][j]表示字符串s的第i个字符到第j个字符之间的最长回文子序列的长度，
//    所以dp[i][j]的状态转移方程为：
//    如果s.charAt(i)==s.charAt(j)，那么dp[i][j]=dp[i+1][j-1]+2；
//    如果s.charAt(i)!=s.charAt(j)，那么dp[i][j]=Math.max(dp[i+1][j],Math.max(dp[i][j],dp[i][j-1]))；
//    所以，最终的结果为dp[0][len-1]。
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len + 1][len + 1];
        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i + 1][j - 1] + 2;
                else dp[i][j] = Math.max(dp[i + 1][j], Math.max(dp[i][j], dp[i][j - 1]));
            }
        }
        return dp[0][len - 1];
    }
}
