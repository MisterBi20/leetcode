package day18;

import java.util.*;

public class Ex49 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ex49 ex49 = new Ex49();
        System.out.println("字符串元素个数：");
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = scanner.nextLine();
        }
        System.out.println(ex49.groupAnagrams(strs));
    }

    //    使用一个HashMap，将排序后的元素，放到同一个value的list中
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            List<String> list = map.getOrDefault(new String(temp), new ArrayList<>());
            list.add(strs[i]);
            map.put(new String(temp), list);
        }
        return new ArrayList<>(map.values());
    }
}
