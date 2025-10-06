package day13;

/*给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
        请必须使用时间复杂度为 O(log n) 的算法。*/

import java.util.Arrays;
import java.util.Scanner;

public class Ex35 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入数组元素个数：");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();
        Ex35 ex35 = new Ex35();
        System.out.println(ex35.searchInsert(nums, target));
        System.out.println(Arrays.toString(nums));
    }

    //    找数字位置或应该插入的位置
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        int j = 0;
        if (left > right) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < target) {
                    j++;
                }
            }
        }
        return j;
    }
}
