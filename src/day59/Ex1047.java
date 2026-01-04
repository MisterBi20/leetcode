package day59;

/*给出由小写字母组成的字符串 s，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
在 s 上反复执行重复项删除操作，直到无法继续删除。
在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。*/

public class Ex1047 {
    public static void main(String[] args) {
        String s = "baabbc";
        Ex1047 ex1047 = new Ex1047();
        System.out.println(ex1047.removeDuplicates(s));
    }

    //    定义一个模拟栈，遍历字符串，若栈顶元素与当前元素相等，则弹出栈顶元素，否则将当前元素入栈
//    最后将栈中的元素弹出，拼接成字符串返回
    public String removeDuplicates(String s) {
        StringBuffer res = new StringBuffer();
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (top >= 0 && res.charAt(top) == c) {
                res.deleteCharAt(top);
                top--;
            } else {
                res.append(c);
                top++;
            }
        }
        return res.toString();
    }
}
