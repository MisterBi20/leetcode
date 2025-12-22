package day45;

/*有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points ，
其中points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend之间的气球。你不知道气球的确切 y 坐标。
一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend，
且满足  xstart ≤ x ≤ xend，则该气球会被 引爆 。可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。
给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。*/

import java.util.Arrays;

public class Ex452 {
    public static void main(String[] args) {
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        Ex452 ex452 = new Ex452();
        int minArrowShots = ex452.findMinArrowShots(points);
        System.out.println(minArrowShots);
    }

/*        先按左边界排序，然后遍历数组，
    如果当前气球的左边界大于前一个气球的右边界，
    说明当前气球和前一个气球不重叠，需要一支新的箭。
    如果当前气球的左边界小于等于前一个气球的右边界，
    说明当前气球和前一个气球重叠，需要更新前一个气球的右边界为当前气球的右边界和前一个气球右边界的较小值。*/
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int count = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > points[i - 1][1]) {
                count++;
            } else {
                points[i][1] = Math.min(points[i][1], points[i - 1][1]);
            }
        }
        return count;
    }
}
