package day4;

/*给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
        回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。*/

import java.util.Scanner;

public class Ex9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        Ex9 ex9 = new Ex9();
        System.out.println(ex9.isPalindrome(x));
    }

    /*将整数转为字符串，然后比较*/
/*    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String s = String.valueOf(x);
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }*/

    /*不将整数转为字符串，直接比较*/
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int temp = x;
        int res = 0;
        while (temp != 0) {
            res = res * 10 + temp % 10;
            temp = temp / 10;
        }
        return res == x;
    }
}
