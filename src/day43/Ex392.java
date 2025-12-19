package day43;

/*给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
        字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
        （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
        进阶：
        如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，
        你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？*/

public class Ex392 {
    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        Ex392 ex392 = new Ex392();
        System.out.println(ex392.isSubsequence(s, t));
    }

    //    动态规划，定义dp[i][j]为s的前i个字符是否为t的前j个字符的子序列
//    如果s的第i个字符等于t的第j个字符，那么dp[i][j]=dp[i-1][j-1]+1
//    如果s的第i个字符不等于t的第j个字符，那么dp[i][j]=dp[i][j-1]
//    最后判断dp[length1][length2]是否等于length1即可
    public boolean isSubsequence(String s, String t) {
        int length1 = s.length();
        int length2 = t.length();
        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        if (dp[length1][length2] == length1) return true;
        else return false;
    }
}
