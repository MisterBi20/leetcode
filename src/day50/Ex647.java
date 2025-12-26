package day50;

/*给你一个字符串s，请你统计并返回这个字符串中回文子串 的数目。
回文字符串是正着读和倒过来读一样的字符串。
子字符串是字符串中的由连续字符组成的一个序列。*/

public class Ex647 {
    public static void main(String[] args) {
        String s = "abc";
        Ex647 ex647 = new Ex647();
        int i = ex647.countSubstrings(s);
        System.out.println(i);
    }
//    动态规划，dp[i][j]表示字符串s的第i个字符到第j个字符之间的子字符串是否为回文子字符串，
//    所以dp[i][j]的状态转移方程为：
//    如果s.charAt(i)==s.charAt(j)，那么dp[i][j]=dp[i+1][j-1]；
//    如果s.charAt(i)!=s.charAt(j)，那么dp[i][j]=false；
//    所以，最终的结果为dp数组中为true的元素的个数。
    public int countSubstrings(String s){
        char[] chars = s.toCharArray();
        int len = chars.length;
        boolean[][] dp = new boolean[len][len];
        int result = 0;
        for (int i = len-1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (chars[i] == chars[j]){
                    if (j-i<=1){
                        result++;
                        dp[i][j] = true;
                    }else if (dp[i+1][j-1]){
                        result++;
                        dp[i][j] = true;
                    }
                }
            }
        }
        return result;
    }
}
