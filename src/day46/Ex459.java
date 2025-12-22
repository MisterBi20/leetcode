package day46;

//给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。

public class Ex459 {
    public static void main(String[] args) {
        String s = "abab";
        Ex459 ex459 = new Ex459();
        boolean b = ex459.repeatedSubstringPattern(s);
        System.out.println(b);
    }

    // 采用KMP算法，判断字符串是否是由一个子串重复多次构成，
// 1. 构造next数组，next[i]表示字符串s的前i个字符的最长公共前缀和后缀的长度
// 2. 如果next[len]>0&&len%(len-next[len])==0，说明字符串s是由一个子串重复多次构成
// 3. 否则，说明字符串s不是由一个子串重复多次构成，返回false
    public boolean repeatedSubstringPattern(String s) {
        if (s.equals("")) return false;
        int len = s.length();
        s = " " + s;
        char[] chars = s.toCharArray();
        int[] next = new int[len + 1];
        for (int i = 2, j = 0; i <= len; i++) {
            while (j > 0 && chars[i] != chars[j + 1]) j = next[j];
            if (chars[i] == chars[j + 1]) j++;
            next[i] = j;
        }
        if (next[len] > 0 && len % (len - next[len]) == 0) return true;
        return false;
    }
}
