package day26;

//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Ex102 {
    public List<List<Integer>> res = new ArrayList<List<Integer>>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        Ex102 ex102 = new Ex102();
        ex102.levelOrder(root);
        System.out.println(ex102.res);
    }

    //使用队列实现层序遍历，每次遍历一层，将层中的节点值加入到列表中，时间复杂度O(n)，空间复杂度O(n)
    public List<List<Integer>> levelOrder(TreeNode root) {
        checkFun(root);
        return res;
    }

    public void checkFun(TreeNode node) {
        if (node == null) return;
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(node);
        while (!que.isEmpty()) {
            List<Integer> itemList = new ArrayList<Integer>();
            int len = que.size();
            while (len > 0) {
                TreeNode temNode = que.poll();
                itemList.add(temNode.val);
                if (temNode.left != null) que.offer(temNode.left);
                if (temNode.right != null) que.offer(temNode.right);
                len--;
            }
            res.add(itemList);
        }
    }
}
