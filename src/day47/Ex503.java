package day47;

/*给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），
返回 nums 中每个元素的 下一个更大元素 。
数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，
这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。*/

import java.util.Arrays;
import java.util.Stack;

public class Ex503 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        Ex503 ex503 = new Ex503();
        int[] nextGreaterElements = ex503.nextGreaterElements(nums);
        System.out.println(Arrays.toString(nextGreaterElements));
    }

    //    定义单调栈，栈中元素为数组下标，栈中元素对应的数组元素单调递减，
//    遍历数组，当栈不为空且当前元素大于栈顶元素时，弹出栈顶元素，将当前元素对应的下一个更大元素设为当前元素，
//    最后返回结果数组即可
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) return new int[]{-1};
        int size = nums.length;
        int[] res = new int[size];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * size; i++) {
            while (!stack.isEmpty() && nums[i % size] > nums[stack.peek()]) {
                res[stack.peek()] = nums[i % size];
                stack.pop();
            }
            stack.push(i % size);
        }
        return res;
    }
}
