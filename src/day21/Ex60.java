package day21;

/*给出集合[1,2,3,...,n]，其所有元素共有 n!种排列。
        按大小顺序列出所有排列情况，并一一标记，当 n=3时,所有排列如下：
        "123"
        "132"
        "213"
        "231"
        "312"
        "321"
        给定 n 和 k，返回第 k 个排列。*/

import java.util.Arrays;
import java.util.Scanner;

public class Ex60 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        Ex60 ex60 = new Ex60();
        System.out.println(ex60.getPermutation(n, k));
    }

    /*    第k个排列可以表示为：
        a1a2a3...an
        其中ai表示第i个位置的数字，i=1,2,3,...,n
        第k个排列的第i个位置的数字可以表示为：
        ki=(k-1)/(n-i)!+1
        其中ki为第i个位置的数字，k为第k个排列，n为集合的元素个数，i为第i个位置*/
    public String getPermutation(int n, int k) {
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        k--;
        StringBuffer ans = new StringBuffer();
        int[] valid = new int[n + 1];
        Arrays.fill(valid, 1);
        for (int i = 1; i <= n; i++) {
            int order = k / factorial[n - i] + 1;
            for (int j = 1; j <= n; j++) {
                order -= valid[j];
                if (order == 0) {
                    ans.append(j);
                    valid[j] = 0;
                    break;
                }
            }
            k %= factorial[n - i];
        }
        return ans.toString();
    }
}
