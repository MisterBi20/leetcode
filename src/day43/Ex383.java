package day43;

/*给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
        如果可以，返回 true ；否则返回 false 。
        magazine 中的每个字符只能在 ransomNote 中使用一次。*/

public class Ex383 {
    public static void main(String[] args) {
        String ransomNote = "a";
        String magazine = "b";
        Ex383 ex383 = new Ex383();
        boolean ans = ex383.canConstruct(ransomNote, magazine);
        System.out.println(ans);
    }

    //    数组记录magazine中每个字符出现的次数，然后遍历ransomNote，
    //    每次遍历到一个字符，就将数组中对应字符的次数减一，
    //    如果最后数组中所有元素都大于等于0，说明ransomNote可以由magazine中的字符构成。
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        int[] record = new int[26];
        for (char c : magazine.toCharArray()) {
            record[c - 'a'] += 1;
        }
        for (char c : ransomNote.toCharArray()) {
            record[c - 'a'] -= 1;
        }
        for (int i : record) {
            if (i < 0) return false;
        }
        return true;
    }
}
