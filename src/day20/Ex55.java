package day20;

/*给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
        判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。*/

import java.util.Scanner;

public class Ex55 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ex55 ex55 = new Ex55();
        System.out.println("输入数组元素个数：");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(ex55.canJump(nums));
    }

    //从前往后遍历，记录当前能够到达的最远位置max，
    //如果当前位置i大于max，说明无法到达当前位置，返回false
    //否则，更新max为max和i+nums[i]的较大值
    //最后判断max是否大于等于n-1，是则返回true，否则返回false
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }
}
