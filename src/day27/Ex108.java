package day27;

//给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 平衡 二叉搜索树。

import java.util.Scanner;

public class Ex108 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        Ex108 ex108 = new Ex108();
        TreeNode root = ex108.sortedArrayToBST(nums);
    }

    //    递归取升序数组中序构造平衡二叉树
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = traversal(nums, 0, nums.length - 1);
        return root;
    }

    private TreeNode traversal(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = traversal(nums, left, mid - 1);
        root.right = traversal(nums, mid + 1, right);
        return root;
    }
}
