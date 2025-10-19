package day24;

/*给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
        求在该柱状图中，能够勾勒出来的矩形的最大面积。*/

import java.util.Scanner;

public class Ex84 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入数组元素个数：");
        int n = scanner.nextInt();
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = scanner.nextInt();
        }
        Ex84 ex84 = new Ex84();
        System.out.println(ex84.largestRectangleArea(heights));
    }

    //遍历数组每个元素两边的第一个较小位置，最后求最大面积
    public int largestRectangleArea(int[] heights) {
        int length = heights.length;
        int[] midLeftIndex = new int[length];
        int[] midRightIndex = new int[length];
        midLeftIndex[0] = -1;
        for (int i = 1; i < length; i++) {
            int t = i - 1;
            while (t >= 0 && heights[t] >= heights[i]) t = midLeftIndex[t];
            midLeftIndex[i] = t;
        }
        midRightIndex[length - 1] = length;
        for (int i = length - 2; i >= 0; i--) {
            int t = i + 1;
            while (t < length && heights[t] >= heights[i]) t = midRightIndex[t];
            midRightIndex[i] = t;
        }
        int res = 0;
        for (int i = 0; i < length; i++) {
            int sum = heights[i] * ((midRightIndex[i] - 1) - (midLeftIndex[i] + 1) + 1);
            res = Math.max(sum, res);
        }
        return res;
    }
}

