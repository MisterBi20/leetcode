package day57;

/*你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。*/

public class Ex925 {
    public static void main(String[] args) {
        String name = "alex", typed = "aaleex";
        Ex925 ex925 = new Ex925();
        boolean res = ex925.isLongPressedName(name, typed);
        System.out.println(res);
    }

    //    定义两个指针i和j，分别指向name和typed数组的当前字符。
//    遍历数组typed，判断是否能够匹配name中的字符。
//    如果匹配成功，i和j都向后移动一位。
//    如果匹配失败，判断是否是长按导致的失败。如果是，j向后移动一位，继续判断是否匹配。如果不是，返回false。
//    遍历完成后，判断是否i指针是否指向name数组的末尾。如果是，返回true。否则，返回false。
    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        int m = name.length(), n = typed.length();
        while (i < m && j < n) {
            if (name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else {
                if (j == 0) return false;
                while (j < n - 1 && typed.charAt(j) == typed.charAt(j - 1)) j++;
                if (name.charAt(i) == typed.charAt(j)) {
                    i++;
                    j++;
                } else return false;
            }
        }
        if (i < m) return false;
        while (j < n) {
            if (typed.charAt(j) == typed.charAt(j - 1)) j++;
            else return false;
        }
        return true;
    }
}
