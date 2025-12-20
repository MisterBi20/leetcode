package day44;

/*给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。
返回 需要移除区间的最小数量，使剩余区间互不重叠 。
注意 只在一点上接触的区间是 不重叠的。例如 [1, 2] 和 [2, 3] 是不重叠的。*/

import java.util.Arrays;

public class Ex435 {
    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        Ex435 ex435 = new Ex435();
        System.out.println(ex435.eraseOverlapIntervals(intervals));
    }

    //    先按照区间的起始位置排序,如果起始位置相同,则按照结束位置排序,
//    然后遍历区间,如果当前区间的起始位置小于前一个区间的结束位置,则说明有重叠,
//    则需要移除一个区间,移除的区间为结束位置较大的那个区间,
//    因为结束位置较大的区间更可能与后面的区间重叠,所以移除它可以使剩余区间互不重叠的数量更多,
//    最后返回需要移除的区间数量即可.
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });
        int count = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                intervals[i][1] = Math.min(intervals[i - 1][1], intervals[i][1]);
                continue;
            } else {
                count++;
            }
        }
        return intervals.length - count;
    }
}
