package day18;

//实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，x^n ）。

import java.util.Scanner;

public class Ex50 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ex50 ex50 = new Ex50();
        System.out.println("输入底数：");
        double x = scanner.nextDouble();
        System.out.println("输入幂：");
        int n = scanner.nextInt();
        System.out.println(ex50.myPow(x, n));
    }

    //    快速幂 + 迭代
    public double myPow(double x, int n) {
        long N = n;
        return N > 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul(double x, long N) {
        double ans = 1.0;
        double x_contribute = x;
        while (N > 0) {
            if (N % 2 == 1) {
                ans *= x_contribute;
            }
            x_contribute *= x_contribute;
            N /= 2;
        }
        return ans;
    }
}
