package day11;

/*给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。
        s 中的 串联子串 是指一个包含  words 中所有字符串以任意顺序排列连接起来的子串。
        例如，如果 words = ["ab","cd","ef"]， 那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"，"efabcd"， 和 "efcdab" 都是串联子串。 "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。
        返回所有串联子串在 s 中的开始索引。你可以以 任意顺序 返回答案。*/

import java.util.*;

public class Ex30 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入字符串：");
        String s = scanner.nextLine();
        System.out.println("输入单词数量：");
        int m = scanner.nextInt();
        scanner.nextLine();
        String[] words = new String[m];
        for (int i = 0; i < m; i++) {
            words[i] = scanner.nextLine();
        }
        Ex30 ex30 = new Ex30();
        System.out.println(ex30.findSubstring(s, words));
    }

    //    滑动窗口 + HashMap 计数差值法
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        int m = words.length, n = words[0].length(), ls = s.length();
        for (int i = 0; i < n; i++) {
            if (i + m * n > ls) break;
            Map<String, Integer> differ = new HashMap<String, Integer>();
            for (int j = 0; j < m; j++) {
                String word = s.substring(i + j * n, i + (j + 1) * n);
                differ.put(word, differ.getOrDefault(word, 0) + 1);
            }
            for (String word : words) {
                differ.put(word, differ.getOrDefault(word, 0) - 1);
                if (differ.get(word) == 0) differ.remove(word);
            }
            for (int start = i; start < ls - m * n + 1; start += n) {
                if (start != i) {
                    String word = s.substring(start + (m - 1) * n, start + m * n);
                    differ.put(word, differ.getOrDefault(word, 0) + 1);
                    if (differ.get(word) == 0) differ.remove(word);
                    word = s.substring(start - n, start);
                    differ.put(word, differ.getOrDefault(word, 0) - 1);
                    if (differ.get(word) == 0) differ.remove(word);
                }
                if (differ.isEmpty()) res.add(start);
            }

        }
        return res;
    }
}
