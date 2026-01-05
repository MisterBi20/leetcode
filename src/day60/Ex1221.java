package day60;

/*平衡字符串 中，'L' 和 'R' 字符的数量是相同的。
给你一个平衡字符串 s，请你将它分割成尽可能多的子字符串，并满足：
每个子字符串都是平衡字符串。
返回可以通过分割得到的平衡字符串的 最大数量 。*/

public class Ex1221 {
    public static void main(String[] args) {
        String s = "RLRRLLRLRL";
        Ex1221 ex1221 = new Ex1221();
        int res = ex1221.balancedStringSplit(s);
        System.out.println(res);
    }

    //    记录平衡字符串的数量，当count为0时，说明当前子字符串是平衡字符串，res加一。
    public int balancedStringSplit(String s) {
        int res = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') count++;
            else count--;
            if (count == 0) res++;
        }
        return res;
    }
}
