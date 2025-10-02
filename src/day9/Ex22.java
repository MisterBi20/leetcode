package day9;

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex22 {
    List<String> ans = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Ex22 ex22 = new Ex22();
        System.out.println(ex22.generateParenthesis(n));
    }

    public List<String> generateParenthesis(int n) {
        dfs("", n, n);
        return ans;
    }

    //中序遍历依次添加括号
    public void dfs(String str, int left, int right) {
        if (left == 0 && right == 0) ans.add(str);
        if (left > 0) dfs(str + "(", left - 1, right);
        if (left < right) dfs(str + ")", left, right - 1);
    }
}
