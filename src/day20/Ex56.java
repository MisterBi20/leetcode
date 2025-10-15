package day20;

/*以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
        请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ex56 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ex56 ex56 = new Ex56();
        System.out.println("输入区间个数：");
        int n = scanner.nextInt();
        int[][] intervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            intervals[i][0] = scanner.nextInt();
            intervals[i][1] = scanner.nextInt();
        }
        int[][] merged = ex56.merge(intervals);
        for (int[] interval : merged) {
            System.out.println(interval[0] + " " + interval[1]);
        }

    }

    //    左端点排序，合并重叠区间
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (p, q) -> p[0] - q[0]);
        List<int[]> ans = new ArrayList<>();
        for (int[] p : intervals) {
            int m = ans.size();
            if (m > 0 && p[0] <= ans.get(m - 1)[1]) {
                ans.get(m - 1)[1] = Math.max(ans.get(m - 1)[1], p[1]);
            } else {
                ans.add(p);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
