package day58;

/*给你一个字符串数组 words ，请你找出所有在 words 的每个字符串中都出现的共用字符（包括重复字符），
并以数组形式返回。你可以按 任意顺序 返回答案。*/

import java.util.ArrayList;
import java.util.List;

public class Ex1002 {
    public static void main(String[] args) {
        String[] words = {"bella", "label", "roller"};
        Ex1002 ex1002 = new Ex1002();
        System.out.println(ex1002.commonChars(words));
    }

    //    遍历数组，统计每个字符串中每个字符出现的次数，将出现次数最少的字符加入结果列表。
    public List<String> commonChars(String[] words) {
        List<String> res = new ArrayList<>();
        if (words.length == 0) return res;
        int[] hash = new int[26];
        for (int i = 0; i < words[0].length(); i++) {
            hash[words[0].charAt(i) - 'a']++;
        }
        for (int i = 1; i < words.length; i++) {
            int[] hashOtherStr = new int[26];
            for (int j = 0; j < words[i].length(); j++) {
                hashOtherStr[words[i].charAt(j) - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                hash[j] = Math.min(hash[j], hashOtherStr[j]);
            }
        }
        for (int i = 0; i < 26; i++) {
            while (hash[i] != 0) {
                char c = (char) (i + 'a');
                res.add(String.valueOf(c));
                hash[i]--;
            }
        }
        return res;
    }
}
