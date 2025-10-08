package day15;

/*给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
        请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。*/

import java.util.Scanner;

public class Ex41 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ex41 ex41 = new Ex41();
        System.out.println("输入数组元素个数：");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(ex41.firstMissingPositive(nums));
    }

    //    将数组视为哈希表,把数字i放到数组i-1的位置处，找第一个不满足条件的位置
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1)
                return i + 1;
        }
        return len + 1;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

}
