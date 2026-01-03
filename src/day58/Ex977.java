package day58;

//给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。

public class Ex977 {
    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        Ex977 ex977 = new Ex977();
        int[] res = ex977.sortedSquares(nums);
        for (int i : res) {
            System.out.println(i);
        }
    }

    //    双指针，一个指向数组头，一个指向数组尾，比较两个指针指向的元素的平方大小，将较大的平方值放到新数组的末尾，
//    并将指向较大元素的指针向中间移动。重复这个过程，直到两个指针相遇。
    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1;
        int[] res = new int[nums.length];
        int index = nums.length - 1;
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                res[index--] = nums[left] * nums[left];
                left++;
            } else {
                res[index--] = nums[right] * nums[right];
                right--;
            }
        }
        return res;
    }
}
