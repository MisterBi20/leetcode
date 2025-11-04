package day29;

/*给你两个字符串 s 和 t ，统计并返回在 s 的 子序列 中 t 出现的个数。
        测试用例保证结果在 32 位有符号整数范围内*/

public class Ex115 {
    public static void main(String[] args) {
        Ex115 ex115 = new Ex115();
        int numDistinct = ex115.numDistinct("rabbbit", "rabbit");
        System.out.println(numDistinct);
    }

    /*动态规划，dp[i][j]表示s的前i个字符中t的前j个字符出现的次数,
     状态转移方程：
     如果s[i-1]==t[j-1]，那么dp[i][j]=dp[i-1][j-1]+dp[i-1][j]，
     否则dp[i][j]=dp[i-1][j]
     初始化：dp[i][0]=1，dp[0][j]=0
     遍历顺序：先遍历s，再遍历t   */
    public int numDistinct(String s, String t){
        int[][] dp = new int[s.length()+1][t.length()+1];
        for (int i = 0; i < s.length()+1; i++) {
            dp[i][0]=1;
        }
        for (int i = 1; i < s.length()+1; i++) {
            for (int j = 1; j < t.length()+1; j++) {
                if (s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
