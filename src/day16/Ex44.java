package day16;

/*给你一个输入字符串 (s) 和一个字符模式 (p) ，请你实现一个支持 '?' 和 '*' 匹配规则的通配符匹配：
        '?' 可以匹配任何单个字符。
        '*' 可以匹配任意字符序列（包括空字符序列）。
        判定匹配成功的充要条件是：字符模式必须能够 完全匹配 输入字符串（而不是部分匹配）。*/

import java.util.Scanner;

public class Ex44 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ex44 ex44 = new Ex44();
        System.out.println(ex44.isMatch(scanner.nextLine(), scanner.nextLine()));
    }

    /*动态规划
    状态定义：dp[i][j] 表示 s 的前 i 个字符和 p 的前 j 个字符是否匹配
    状态转移：
        如果 p[j-1] 是普通字符，那么 dp[i][j] 为 true 当且仅当 s[i-1] == p[j-1] 且 dp[i-1][j-1] 为 true
        如果 p[j-1] 是 '?'，那么 dp[i][j] 为 true 当且仅当 dp[i-1][j-1] 为 true
        如果 p[j-1] 是 '*'，那么 dp[i][j] 为 true 当且仅当 dp[i-1][j] 或 dp[i][j-1] 为 true
    初始状态：dp[0][0] = true，即空字符串和空模式是匹配的
    最终状态：dp[m][n] 表示 s 的前 m 个字符和 p 的前 n 个字符是否匹配*/
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
