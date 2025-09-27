package day4;

/*给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。

        如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。

        假设环境不允许存储 64 位整数（有符号或无符号）。*/

import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ex7 ex7 = new Ex7();
        System.out.println(ex7.reverse(scanner.nextInt()));
    }
    public int reverse(int x){
        int res = 0;
        while (x!=0){
            int pop = x%10;
            x/=10;
            if (res>Integer.MAX_VALUE/10||(res==Integer.MAX_VALUE/10&&pop>7)) return 0;
            if (res<Integer.MIN_VALUE/10||(res==Integer.MIN_VALUE/10&&pop<-8)) return 0;
            res = res*10+pop;
        }
        return res;
    }
}
