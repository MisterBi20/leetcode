package day60;

/*给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
请你返回排序后的数组。*/

import java.util.Arrays;
import java.util.Comparator;

public class Ex1356 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        Ex1356 ex1356 = new Ex1356();
        System.out.println(Arrays.toString(ex1356.sortByBits(arr)));
    }

    //    统计一个整数二进制表示中 1 的数目，
//    利用位运算，每次将 val 与 val-1 进行与运算，即可将 val 二进制表示中最右边的 1 变成 0，
//    每次运算，count 加 1，直到 val 变成 0，即可得到 val 二进制表示中 1 的数目。
    private int cntInt(int val) {
        int count = 0;
        while (val > 0) {
            val = val & (val - 1);
            count++;
        }
        return count;
    }

    public int[] sortByBits(int[] arr) {
        return Arrays.stream(arr).boxed().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int cnt1 = cntInt(o1);
                int cnt2 = cntInt(o2);
                return (cnt1 == cnt2) ? Integer.compare(o1, o2) : Integer.compare(cnt1, cnt2);
            }
        }).mapToInt(Integer::intValue).toArray();
    }
}
