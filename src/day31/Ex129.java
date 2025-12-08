package day31;

/*给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
        每条从根节点到叶节点的路径都代表一个数字：
        例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
        计算从根节点到叶节点生成的 所有数字之和 。
        叶节点 是指没有子节点的节点。*/

import java.util.ArrayList;
import java.util.List;

public class Ex129 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        Ex129 ex129 = new Ex129();
        System.out.println(ex129.sumNumbers(root));
    }

    List<Integer> path = new ArrayList<>();
    int res = 0;

    //    回溯算法，遍历所有路径，将路径上的数字转换为整数，累加起来，返回结果
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        path.add(root.val);
        recur(root);
        return res;
    }

    public void recur(TreeNode root) {
        if (root.left == null && root.right == null) {
            res += listToInt(path);
            return;
        }
        if (root.left != null) {
            path.add(root.left.val);
            recur(root.left);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            path.add(root.right.val);
            recur(root.right);
            path.remove(path.size() - 1);
        }
        return;
    }

    public int listToInt(List<Integer> path) {
        int sum = 0;
        for (Integer num : path) {
            sum = sum * 10 + num;
        }
        return sum;
    }
}
