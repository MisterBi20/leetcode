package day31;

//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文串。返回符合要求的 最少分割次数 。

public class Ex132 {
    public static void main(String[] args) {
        String s = "aab";
        Ex132 ex132 = new Ex132();
        System.out.println(ex132.minCut(s));
    }
    public int minCut(String s){
        if (s==null||"".equals(s)) return 0;
        int len = s.length();
        boolean[][] isPalindromic = new boolean[len][len];
        for (int i = len-1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i)==s.charAt(j)){
                    if (j-i<=1) isPalindromic[i][j] =true;
                    else isPalindromic[i][j] = isPalindromic[i+1][j+1];
                }else isPalindromic[i][j] = false;
            }
        }
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i]=i;
        }
        for (int i = 1; i < len; i++) {
            if (isPalindromic[0][i]){
                dp[i] = 0;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (isPalindromic[j+1][i]){
                    dp[i] = Math.min(dp[i],dp[j]+1);
                }
            }
        }
        return dp[len-1];
    }

}
