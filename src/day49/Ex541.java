package day49;

/*给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
如果剩余字符少于 k 个，则将剩余字符全部反转。
如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。*/

public class Ex541 {
    public static void main(String[] args) {
        Ex541 ex541 = new Ex541();
        System.out.println(ex541.reverseStr("abcdefg", 2));
    }

    //    将字符串转换为字符数组,遍历数组,每次取2k个字符,如果剩余字符少于k个,则将剩余字符全部反转,
//    如果剩余字符小于2k但大于或等于k个,则反转前k个字符,其余字符保持原样
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i += 2 * k) {
            int start = i;
            int end = Math.min(ch.length - 1, start + k - 1);
            while (start < end) {
                char temp = ch[start];
                ch[start] = ch[end];
                ch[end] = temp;
                start++;
                end--;
            }
        }
        return new String(ch);
    }
}
