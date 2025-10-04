package day11;

/*给你两个整数，被除数 dividend 和除数 divisor。将两数相除，要求 不使用 乘法、除法和取余运算。
        整数除法应该向零截断，也就是截去（truncate）其小数部分。例如，8.345 将被截断为 8 ，-2.7335 将被截断至 -2 。
        返回被除数 dividend 除以除数 divisor 得到的 商 。
        注意：假设我们的环境只能存储 32 位 有符号整数，其数值范围是 [−2^31,  2^31−1] 。本题中，如果商 严格大于 2^31 − 1 ，则返回 2^31 − 1 ；如果商 严格小于 -2^31 ，则返回 -2^31 。*/

import java.util.Scanner;

public class Ex29 {
    int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ex29 ex29 = new Ex29();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(ex29.divide(a, b));
    }

    //    二分法找到最大的r使得r*除数<被除数
    public int divide(int dividend, int divisor) {
        long dividendLong = dividend, divisorLong = divisor;
        boolean flag = false;
        if ((dividendLong ^ divisorLong) < 0) flag = true;
        if (dividendLong < 0) dividendLong = -dividendLong;
        if (divisorLong < 0) divisorLong = -divisorLong;
        long l = 0, r = dividendLong;
        while (l < r) {
            long mid = l + r + 1 >> 1;
            if (mul(mid, divisorLong) <= dividendLong) l = mid;
            else r = mid - 1;
        }
        r = flag ? -r : r;
        if (r > INF || r < -INF - 1) return INF;
        return (int) r;
    }

    long mul(long a, long k) {
        long ans = 0;
        while (k > 0) {
            if ((k & 1) == 1) ans += a;
            k >>= 1;
            a += a;
        }
        return ans;
    }
}
