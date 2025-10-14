package day19;

/*给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
        子数组是数组中的一个连续部分*/

import java.util.Scanner;

public class Ex53 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        Ex53 ex53 = new Ex53();
        System.out.println(ex53.maxSubArray(nums));
    }

    //动态规划，pre表示以当前元素结尾的最大子数组和，maxAns表示全局最大子数组和
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int num : nums) {
            pre = Math.max(num, pre + num);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
