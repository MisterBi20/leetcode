package day20;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex57 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] intervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            intervals[i][0] = scanner.nextInt();
            intervals[i][1] = scanner.nextInt();
        }
        int[] newInterval = new int[2];
        newInterval[0] = scanner.nextInt();
        newInterval[1] = scanner.nextInt();
        Ex57 ex57 = new Ex57();
        int[][] result = ex57.insert(intervals, newInterval);
        for (int[] ints : result) {
            System.out.println(ints[0] + " " + ints[1]);
        }
    }
//    分情况讨论：
//    1.新区间在所有区间的左边
//    2.新区间在所有区间的右边
//    3.新区间与所有区间有交集
//    合并区间，添加到结果列表中，继续遍历，直到新区间不与任何区间有交集，将剩余区间添加到结果列表中。
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<int[]>();
        int n = intervals.length, i = 0;
        while (i < n && intervals[i][1] < newInterval[0]) {
            list.add(intervals[i]);
            i++;
        }
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        list.add(newInterval);
        while (i < n && intervals[i][0] > newInterval[1]) {
            list.add(intervals[i]);
            i++;
        }
        return list.toArray(new int[list.size()][]);
    }
}
