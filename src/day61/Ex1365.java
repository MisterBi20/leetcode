package day61;

/*给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
以数组形式返回答案。*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Ex1365 {
    public static void main(String[] args) {
        int[] nums = {8, 1, 2, 2, 3};
        Ex1365 ex1365 = new Ex1365();
        int[] res = ex1365.smallerNumbersThanCurrent(nums);
        System.out.println(Arrays.toString(res));
    }

    //    排序记录每个元素的下标，然后遍历原数组，根据排序后的数组找到每个元素的下标，就是比它小的所有数字的数目。
    public int[] smallerNumbersThanCurrent(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = Arrays.copyOf(nums, nums.length);
        Arrays.sort(res);
        for (int i = 0; i < res.length; i++) {
            if (!map.containsKey(res[i])) map.put(res[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] = map.get(nums[i]);
        }
        return res;
    }
}
