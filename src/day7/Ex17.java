package day7;

/*给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
        给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ex17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ex17 ex17 = new Ex17();
        System.out.println(ex17.letterCombinations(scanner.nextLine()));
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) return result;
        List<String> digitsCharList = getChar(digits.charAt(0));
        if (digits.length() == 1) return digitsCharList;
        List<String> last = letterCombinations(digits.substring(1));
        for (String digitStr : digitsCharList) {
            for (int i = 0; i < last.size(); i++) {
                result.add(digitStr + last.get(i));
            }
        }
        return result;
    }

    public List<String> getChar(char c) {
        switch (c) {
            case '2':
                return Arrays.asList("a", "b", "c");
            case '3':
                return Arrays.asList("d", "e", "f");
            case '4':
                return Arrays.asList("g", "h", "i");
            case '5':
                return Arrays.asList("j", "k", "l");
            case '6':
                return Arrays.asList("m", "n", "o");
            case '7':
                return Arrays.asList("p", "q", "r", "s");
            case '8':
                return Arrays.asList("t", "u", "v");
            case '9':
                return Arrays.asList("w", "x", "y", "z");
            default:
                return new ArrayList<>();
        }
    }
}
