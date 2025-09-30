package day2;


import java.util.HashMap;
import java.util.Scanner;

//给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
//滑动窗口
public class Ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Ex3 ex3 = new Ex3();
        System.out.println(ex3.lengthOfLongestSubString(s));
    }
    /*滑动窗口对比之前的子串，时间复杂度O(n)*/
    public int lengthOfLongestSubString(String s) {
        if (s.isEmpty()) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
