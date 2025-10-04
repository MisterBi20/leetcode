package day11;

//给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1

import java.util.Scanner;

public class Ex28 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Ex28 ex28 = new Ex28();
        String haystack=scanner.nextLine();
        String needle=scanner.nextLine();
        System.out.println(ex28.strStr(haystack,needle));
    }
    public int strStr(String haystack,String needle){
        int index = -1;
        for (int i = 0; i < haystack.length()-needle.length()+1; i++) {
            boolean flag = true;
            for (int j = 0; j <needle.length(); j++) {
                if (haystack.toCharArray()[i+j]!=needle.toCharArray()[j]){
                    flag=false;
                    break;
                }
            }
            if (flag) {
                index=i;
                break;
            }
        }
        return index;
    }
    public int _strStr(String haystack,String needle){
        return haystack.indexOf(needle);
    }
}
