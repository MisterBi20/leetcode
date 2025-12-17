package day40;

/*给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
        请注意 ，必须在不复制数组的情况下原地对数组进行操作。*/

public class Ex283 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        Ex283 ex283 = new Ex283();
        ex283.moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    //    双指针，快指针遍历数组，慢指针指向非0元素的最后一个位置，快指针遇到非0元素，就交换快慢指针的元素，然后慢指针后移一位
    public void moveZeroes(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast];
            }
        }
        for (int j = slow; j < nums.length; j++) {
            nums[j] = 0;
        }
    }
}
