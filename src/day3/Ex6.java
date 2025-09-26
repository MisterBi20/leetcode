package day3;

/*将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。

        比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：

        P   A   H   N
        A P L S I I G
        Y   I   R
        之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。

        请你实现这个将字符串进行指定行数变换的函数：

        string convert(string s, int numRows);*/

import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        Ex6 ex6 = new Ex6();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int numRows = scanner.nextInt();
        System.out.println(ex6.convert(s,numRows));
    }
    public String convert(String s,int numRows){
        if (numRows<2) return s;
        StringBuffer[] strings = new StringBuffer[numRows];
        for (int i = 0; i < numRows; i++) {
            strings[i] = new StringBuffer();
        }
        int i = 0;
        int flag = -1;
        for (char c:s.toCharArray()){
            strings[i].append(c);
            if (i==0||i==numRows-1) flag=-flag;
            i+=flag;
        }
        StringBuffer res = new StringBuffer();
        for (StringBuffer stringBuffer:strings){
            res.append(stringBuffer);
        }
        return res.toString();
    }
}
