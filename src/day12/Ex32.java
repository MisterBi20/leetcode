package day12;

/*给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号 子串 的长度。
        左右括号匹配，即每个左括号都有对应的右括号将其闭合的字符串是格式正确的，比如 "(()())"。*/

import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Ex32 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ex32 ex32 = new Ex32();
        String s = scanner.nextLine();
        System.out.println(ex32.longestValidParentheses(s));
    }

    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int max_len = 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    if (i < 2) {
                        dp[i] = 2;
                    } else {
                        dp[i] = dp[i - 2] + 2;
                    }
                } else {
                    if (dp[i - 1] > 0) {
                        int pre_left = i - dp[i - 1] - 1;
                        if (pre_left >= 0 && s.charAt(pre_left) == '(') {
                            dp[i] = dp[i - 1] + 2;
                            if (pre_left - 1 > 0) {
                                dp[i] = dp[i] + dp[pre_left - 1];
                            }
                        }
                    }
                }
            }

            max_len = Math.max(max_len, dp[i]);
        }
        return max_len;
    }





    /*public int longestValidParentheses(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int num = 0, max = 0;
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            }else {
                if (!stack.isEmpty()&&stack.peek()==')'){
                    stack.pop();
                    num+=2;
                    max= Math.max(num,max);
                }else {
                    num=0;
                    stack.clear();
                }
            }
        }
        return max;
    }*/

}