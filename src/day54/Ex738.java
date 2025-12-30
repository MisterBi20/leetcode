package day54;

/*当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。
给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。*/

public class Ex738 {
    public static void main(String[] args) {
        int n = 1000000000;
        Ex738 ex738 = new Ex738();
        int res = ex738.monotoneIncreasingDigits(n);
        System.out.println(res);
    }

    //    从后往前遍历数组，找到第一个不满足单调递增的位置，将该位置左边的数字减一，右边的数字都设为9。
    public int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        int start = chars.length;
        for (int i = s.length() - 2; i >= 0; i--) {
            if (chars[i] > chars[i + 1]) {
                chars[i]--;
                start = i + 1;
            }
        }
        for (int i = start; i < s.length(); i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(String.valueOf(chars));
    }
}
