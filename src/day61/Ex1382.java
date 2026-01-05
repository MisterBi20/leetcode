package day61;

/*
给你一棵二叉搜索树，请你返回一棵 平衡后 的二叉搜索树，新生成的树应该与原来的树有着相同的节点值。如果有多种构造方法，请你返回任意一种。
如果一棵二叉搜索树中，每个节点的两棵子树高度差不超过 1 ，我们就称这棵二叉搜索树是 平衡的 。
*/

import java.util.ArrayList;

public class Ex1382 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        Ex1382 ex1382 = new Ex1382();
        TreeNode res = ex1382.balanceBST(root);
    }

    //    中序遍历二叉搜索树，将节点值存入数组中，然后根据数组构造平衡二叉搜索树。
    ArrayList<Integer> res = new ArrayList<>();

    private void travesal(TreeNode root) {
        if (root == null) return;
        travesal(root.left);
        res.add(root.val);
        travesal(root.right);
    }

    private TreeNode getTree(ArrayList<Integer> nums, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums.get(mid));
        root.left = getTree(nums, left, mid - 1);
        root.right = getTree(nums, mid + 1, right);
        return root;
    }

    public TreeNode balanceBST(TreeNode root) {
        travesal(root);
        return getTree(res, 0, res.size() - 1);
    }
}
