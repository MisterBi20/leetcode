package day32;

/*给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
        注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。*/

import java.util.List;

public class Ex139 {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = List.of("leet", "code");
        Ex139 ex139 = new Ex139();
        System.out.println(ex139.wordBreak(s, wordDict));
    }

    //动态规划,用dp[i]表示s的前i个字符是否可以被wordDict中的单词拼接出，
    // 则dp[i]为true当且仅当存在一个j满足dp[j]为true且s[j:i]在wordDict中，
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                int len = word.length();
                if (i >= len && dp[i - len] && word.equals(s.substring(i - len, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
