package day14;

/*「外观数列」是一个数位字符串序列，由递归公式定义：
        countAndSay(1) = "1"
        countAndSay(n) 是 countAndSay(n-1) 的行程长度编码。
        行程长度编码（RLE）是一种字符串压缩方法，其工作原理是通过将连续相同字符（重复两次或更多次）替换为字符重复次数（运行长度）和字符的串联。
        例如，要压缩字符串 "3322251" ，我们将 "33" 用 "23" 替换，将 "222" 用 "32" 替换，将 "5" 用 "15" 替换并将 "1" 用 "11" 替换。因此压缩后字符串变为 "23321511"。
        给定一个整数 n ，返回 外观数列 的第 n 个元素。*/

import java.util.Scanner;

public class Ex38 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Ex38 ex38 = new Ex38();
        System.out.println(ex38.countAndSay(n));
    }

    //    递归添加到缓冲字符串中
    public String countAndSay(int n) {
        StringBuilder s = new StringBuilder();
        if (n == 1) return "1";
        else {
            char[] chars = countAndSay(n - 1).toCharArray();
            char c = chars[0];
            int nums = 0;
            for (char aChar : chars) {
                if (aChar == c) {
                    nums++;
                } else {
                    s.append(nums);
                    s.append(c);
                    c = aChar;
                    nums = 1;
                }
            }
            s.append(nums);
            s.append(c);
        }
        return s.toString();
    }
}
