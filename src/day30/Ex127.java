package day30;

/*
字典 wordList 中从单词 beginWord 到 endWord 的 转换序列 是一个按下述规格形成的序列 beginWord -> s1 -> s2 -> ... -> sk：
每一对相邻的单词只差一个字母。
对于 1 <= i <= k 时，每个 si 都在 wordList 中。注意， beginWord 不需要在 wordList 中。
sk == endWord
给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0 。
*/

import java.util.*;

public class Ex127 {
    public static void main(String[] args) {

    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Map<String,Integer> map = new HashMap<>();
        map.put(beginWord,1);
        while (!queue.isEmpty()){
            String word = queue.poll();
            int path = map.get(word);
            for (int i = 0; i < word.length(); i++) {
                char[] chars = word.toCharArray();
                for (char k = 'a'; k <= 'z'; k++) {
                    chars[i]=k;
                    String newword = String.valueOf(chars);
                    if (newword.equals(endWord)){
                        return path+1;
                    }
                    if (wordSet.contains(newword)&&!map.containsKey(newword)){
                        map.put(newword,path+1);
                        queue.offer(newword);
                    }
                }
            }
        }
        return 0;
    }
}
