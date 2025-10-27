package day28;

import java.util.LinkedList;
import java.util.List;

public class Ex113 {
    List<List<Integer>> res;
    LinkedList<Integer> path;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        Ex113 ex113 = new Ex113();
        System.out.println(ex113.pathSum(root, 7));
    }

    //    回溯，遍历整棵树，找到所有路径和为targetSum的路径，每个路径是一个链表，链表中的元素是路径上的节点值
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new LinkedList<>();
        path = new LinkedList<>();
        travesal(root, targetSum);
        return res;
    }

    private void travesal(TreeNode root, int count) {
        if (root == null) return;
        path.offer(root.val);
        count -= root.val;
        if (root.left == null && root.right == null && count == 0)
            res.add(new LinkedList<>(path));
        travesal(root.left, count);
        travesal(root.right, count);
        path.removeLast();
    }
}
