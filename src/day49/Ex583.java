package day49;

/*给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。
每步 可以删除任意一个字符串中的一个字符。*/

public class Ex583 {
    public static void main(String[] args) {
        Ex583 ex583 = new Ex583();
        System.out.println(ex583.minDistance("sea", "eat"));
    }

    //    动态规划,dp数组中存储word1和word2最长相同子序列的长度，
//    则word1和word2的最小删除步数为len1+len2-2*dp[len1][len2]
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return len1 + len2 - 2 * dp[len1][len2];
    }
}
