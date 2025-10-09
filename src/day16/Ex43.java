package day16;

/*给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
        注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。*/

import java.util.Scanner;

public class Ex43 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ex43 ex43 = new Ex43();
        System.out.println(ex43.multiply(scanner.nextLine(), scanner.nextLine()));
    }

    // 模拟乘法竖式计算，将每个位的乘积存储在数组中，最后将数组转换为字符串
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) return "0";
        int len1 = num1.length(), len2 = num2.length();
        int[] ans = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            int value1 = num1.charAt(i) - '0';
            for (int j = len2 - 1; j >= 0; j--) {
                int value2 = num2.charAt(j) - '0';
                int sum = ans[i + j + 1] + value1 * value2;
                ans[i + j + 1] = sum % 10;
                ans[i + j] += sum / 10;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ans.length; i++) {
            if (i == 0 && ans[i] == 0) continue;
            sb.append(ans[i]);
        }
        return sb.toString();
    }
}
