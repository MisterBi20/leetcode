package day55;

/*给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
例如，字符串 "ababcc" 能够被分为 ["abab", "cc"]，但类似 ["aba", "bcc"] 或 ["ab", "ab", "cc"] 的划分是非法的。
注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
返回一个表示每个字符串片段的长度的列表。*/

import java.util.LinkedList;
import java.util.List;

public class Ex763 {
    public static void main(String[] args) {
        String s = "ababcc";
        Ex763 ex763 = new Ex763();
        List<Integer> res = ex763.partitionLabels(s);
        System.out.println(res);
    }

    //    贪心算法，记录每个字符最后出现的位置，遍历字符串，记录当前字符最后出现的位置，
    //    如果当前位置等于最后出现的位置，说明当前字符之前的所有字符都出现在了当前字符之前，
    //    可以将当前字符之前的所有字符作为一个片段。
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new LinkedList<>();
        int[] edge = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            edge[chars[i] - 'a'] = i;
        }
        int idx = 0;
        int last = -1;
        for (int i = 0; i < chars.length; i++) {
            idx = Math.max(idx, edge[chars[i] - 'a']);
            if (i == idx) {
                list.add(i - last);
                last = i;
            }
        }
        return list;
    }
}
