package day47;

/*nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，
并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Ex496 {
    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        Ex496 ex496 = new Ex496();
        int[] res = ex496.nextGreaterElement(nums1, nums2);
        for (int i : res) {
            System.out.println(i);
        }
    }

    //    定义一个哈希表map，用于记录nums1中每个元素的下标，方便最后根据下标赋值，
//    定义一个数组res，用于记录nums1中每个元素的下一个更大元素，初始值为-1，
//    定义一个栈stack，用于记录nums2中元素的下标，栈中元素从栈底到栈顶单调递减，
//    遍历nums2，当栈为空或当前元素小于等于栈顶元素时，将当前元素的下标入栈，
//    否则，将栈顶元素出栈，根据map记录的下标，将当前元素赋值给res数组，
//    最后返回res数组。
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }
        int[] res = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(res, -1);
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                int pre = nums2[stack.pop()];
                if (map.containsKey(pre)) res[map.get(pre)] = nums2[i];
            }
            stack.push(i);
        }
        return res;
    }
}
