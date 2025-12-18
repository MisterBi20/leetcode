package day42;

/*编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
        不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。*/

public class Ex344 {
    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        Ex344 ex344 = new Ex344();
        ex344.reverseString(s);
    }
    //    双指针，一个指向头，一个指向尾，交换即可
    public void reverseString(char[] s){
        int l = 0;
        int r = s.length-1;
        while (l<r){
            char temp = s[l];
            s[l]=s[r];
            s[r]=temp;
            l++;
            r--;
        }
    }
}
