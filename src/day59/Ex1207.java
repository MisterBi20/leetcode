package day59;

//给你一个整数数组 arr，如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。

public class Ex1207 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 1, 1, 3};
        Ex1207 ex1207 = new Ex1207();
        boolean res = ex1207.uniqueOccurrences(arr);
        System.out.println(res);
    }

    //    定义辅助统计数字出现的次数，再定义辅助数组统计数学出现次数是否重复
    public boolean uniqueOccurrences(int[] arr) {
        int[] count = new int[2001];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] + 1000]++;
        }
        boolean[] flag = new boolean[1002];
        for (int i = 0; i <= 2000; i++) {
            if (count[i] > 0) {
                if (flag[count[i]] == false) flag[count[i]] = true;
                else return false;
            }
        }
        return true;
    }
}
