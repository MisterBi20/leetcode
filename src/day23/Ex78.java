package day23;

/*给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
        解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Ex78 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        Ex78 ex78 = new Ex78();
        List<List<Integer>> subsets = ex78.subsets(nums);
        System.out.println(subsets);
    }

    //        回溯法，从0开始遍历，每次遍历到i时，将i加入path，然后递归调用subsetsHelper，递归调用结束后，将i从path中移除，继续遍历下一个数。
    public List<List<Integer>> subsets(int[] nums) {
        subsetsHelper(nums, 0);
        return res;
    }

    private void subsetsHelper(int[] nums, int startIndex) {
        res.add(new ArrayList<>(path));
        if (path.size() == nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            subsetsHelper(nums, i + 1);
            path.removeLast();
        }
    }
}
