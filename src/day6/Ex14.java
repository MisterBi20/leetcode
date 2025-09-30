package day6;

/*编写一个函数来查找字符串数组中的最长公共前缀。
        如果不存在公共前缀，返回空字符串 ""。*/

import java.util.Scanner;

public class Ex14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ex14 ex14 = new Ex14();
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = scanner.nextLine();
        }
        System.out.println(ex14.longestCommonPrefix(strs));
    }

    /*削减第一个字符串，直到找到公共前缀*/
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String str = strs[0];
        for (int i = 1; i < strs.length; i++) {

            while (strs[i].indexOf(str) != 0) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.isEmpty()) break;
        }
        return str;
    }
}
