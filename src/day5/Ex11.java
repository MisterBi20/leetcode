package day5;

/*给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
        找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
        返回容器可以储存的最大水量。
        说明：你不能倾斜容器。*/

import java.util.Scanner;

public class Ex11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = scanner.nextInt();
        }
        Ex11 ex11 = new Ex11();
        System.out.println(ex11.maxArea(height));
    }

    /*双指针法，从两端开始向中间移动，每次移动较短的那一端，因为面积受限于较短的那一端*/
    public int maxArea(int[] height) {
        int n = height.length;
        int l = 0, r = n - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(area, ans);
            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }

}
