package day39;

//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的 字母异位词。

public class Ex242 {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        Ex242 ex242 = new Ex242();
        boolean anagram = ex242.isAnagram(s, t);
        System.out.println(anagram);
    }

    //    辅助数组，记录每个字符出现的次数，s中出现的字符次数加1，t中出现的字符次数减1，最后检查辅助数组是否全为0
    public boolean isAnagram(String s, String t) {
        int[] record = new int[26];
        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            record[t.charAt(i) - 'a']--;
        }
        for (int count : record) {
            if (count != 0) return false;
        }
        return true;
    }
}
