package day20;

/*给你一个 无重叠的 ，按照区间起始端点排序的区间列表 intervals，其中 intervals[i] = [starti, endi] 表示第 i 个区间的开始和结束，并且 intervals 按照 starti 升序排列。同样给定一个区间 newInterval = [start, end] 表示另一个区间的开始和结束。
        在 intervals 中插入区间 newInterval，使得 intervals 依然按照 starti 升序排列，且区间之间不重叠（如果有必要的话，可以合并区间）。
        返回插入之后的 intervals。
        注意 你不需要原地修改 intervals。你可以创建一个新数组然后返回它*/

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
