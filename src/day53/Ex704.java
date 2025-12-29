package day53;

/*给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
写一个函数搜索 nums 中的 target，如果 target 存在返回下标，否则返回 -1。
你必须编写一个具有 O(log n) 时间复杂度的算法。*/

public class Ex704 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        Ex704 ex704 = new Ex704();
        int res = ex704.search(nums, target);
        System.out.println(res);
    }

    //    二分法，定义左右指针，每次取中间值，判断中间值是否等于目标值，
//    如果等于，返回中间值的下标
//    如果中间值大于目标值，说明目标值在左半部分，将右指针移动到中间值的左边
//    如果中间值小于目标值，说明目标值在右半部分，将左指针移动到中间值的右边
//    如果左指针大于右指针，说明目标值不存在，返回-1
    public int search(int[] nums, int target) {
        if (target < nums[0] || target > nums[nums.length - 1]) return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}
