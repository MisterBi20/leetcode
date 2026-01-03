package day58;

/*给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
以这种方式修改数组后，返回数组 可能的最大和 。*/

import java.util.Arrays;

public class Ex1005 {
    public static void main(String[] args) {
        int[] nums = {4, 2, 3};
        int k = 1;
        Ex1005 ex1005 = new Ex1005();
        int res = ex1005.largestSumAfterKNegations(nums, k);
        System.out.println(res);
    }

    //    排序后，将负数转换为正数，直到k次转换完成。
//    如果k次转换完成后，k还为奇数，说明还需要将最小的数转换为负数，以获得最大和。
//    最后返回数组的和。
    public int largestSumAfterKNegations(int[] nums, int k) {
        if (nums.length == 1) {
            if (k % 2 == 0) return nums[0];
            else return -nums[0];
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length && k > 0; i++) {
            if (nums[i] < 0) {
                nums[i] = -nums[i];
                k--;
            }
        }
        if (k % 2 == 1) {
            Arrays.sort(nums);
            nums[0] = -nums[0];
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
