package day56;

/*给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
注意：如果对空文本输入退格字符，文本继续为空。*/

public class Ex844 {
    public static void main(String[] args) {
        String s = "ab#c";
        String t = "ad#c";
        Ex844 ex844 = new Ex844();
        System.out.println(ex844.backspaceCompare(s, t));
    }

    //    模拟退格操作,将字符串转换为字符数组,遍历数组,如果遇到非退格字符,则将其添加到StringBuilder中,
//    如果遇到退格字符,则删除StringBuilder中的最后一个字符,最后比较两个StringBuilder是否相等，
//    如果相等,则返回true,否则返回false。
    public boolean backspaceCompare(String s, String t) {
        StringBuilder ssb = new StringBuilder();
        StringBuilder tsb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != '#') ssb.append(c);
            else if (ssb.length() > 0) ssb.deleteCharAt(ssb.length() - 1);
        }
        for (char c : t.toCharArray()) {
            if (c != '#') tsb.append(c);
            else if (tsb.length() > 0) tsb.deleteCharAt(tsb.length() - 1);
        }
        return ssb.toString().equals(tsb.toString());
    }
}
