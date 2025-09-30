package day3;

//给你一个字符串 s，找到 s 中最长的 回文 子串。

public class Ex5 {
    public static void main(String[] args) {
        Ex5 ex5 = new Ex5();
        String s = "babad";
        String longestPalindrome = ex5.longestPalindrome(s);
        System.out.println(longestPalindrome);
    }

    /*中心扩展算法，比较时间复杂度O(n^2)*/
    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        int maxLen = 1;
        int begin = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (i - maxLen >= 1 && isPalindrome(charArray, i - maxLen - 1, i)) {
                begin = i - maxLen - 1;
                maxLen += 2;
                continue;
            }
            if (i - maxLen >= 0 && isPalindrome(charArray, i - maxLen, i)) {
                begin = i - maxLen;
                maxLen += 1;
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /*判断是否为回文串*/
    public static boolean isPalindrome(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
