package day46;

/*给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。
你可以按 任意顺序 返回答案。数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Ex491 {
    public static void main(String[] args) {
        int[] nums = {4, 6, 7, 7};
        Ex491 ex491 = new Ex491();
        List<List<Integer>> subsequences = ex491.findSubsequences(nums);
        System.out.println(subsequences);
    }

//    哈希表记录同一层元素是否使用过，避免重复使用，
//    当当前元素与上一个元素相等时，若上一个元素未被使用，则当前元素也不能被使用，
//    因为上一个元素的递增子序列也包含当前元素，当前元素的递增子序列也包含上一个元素，
//    所以当前元素的递增子序列与上一个元素的递增子序列重复。
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracking(nums, 0);
        return result;
    }

    private void backTracking(int[] nums, int startIndex) {
        if (path.size() >= 2) result.add(new ArrayList<>(path));
        HashSet<Integer> hs = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            if (!path.isEmpty() && path.get(path.size() - 1) > nums[i] || hs.contains(nums[i])) continue;
            hs.add(nums[i]);
            path.add(nums[i]);
            backTracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
