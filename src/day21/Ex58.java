package day21;

/*给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
        单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。*/

import java.util.Scanner;

public class Ex58 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Ex58 ex58 = new Ex58();
        System.out.println(ex58.lengthOfLastWord(s));
    }

    /*  从字符串的末尾开始遍历，找到第一个不是空格的字符，记录下这个字符的索引i，
        然后继续遍历，找到第一个是空格的字符，记录下这个字符的索引j，
        最后返回i-j就是最后一个单词的长度。*/
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int i = n - 1;
        while (i >= 0 && s.charAt(i) == ' ')
            i--;
        int j = i;
        while (j >= 0 && s.charAt(j) != ' ')
            j--;
        return i - j;
    }
}
