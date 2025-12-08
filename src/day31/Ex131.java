package day31;

//给你一个字符串 s，请你将 s 分割成一些 子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。

import java.util.ArrayList;
import java.util.List;

public class Ex131 {
    public static void main(String[] args) {
        String s = "aab";
        Ex131 ex131 = new Ex131();
        System.out.println(ex131.partition(s));
    }

    //    分割回文串，回溯，递归，判断回文串，加入结果集，移除结果集，递归结束，返回结果集
    List<List<String>> res = new ArrayList<>();
    List<String> cur = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtracking(s, 0, new StringBuffer());
        return res;
    }

    private void backtracking(String s, int start, StringBuffer sb) {
        if (start == s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (check(sb)) {
                cur.add(sb.toString());
                backtracking(s, i + 1, new StringBuffer());
                cur.remove(cur.size() - 1);
            }
        }
    }

    private boolean check(StringBuffer sb) {
        for (int i = 0; i < sb.length() / 2; i++) {
            if (sb.charAt(i) != sb.charAt(sb.length() - 1 - i))
                return false;
        }
        return true;
    }
}
