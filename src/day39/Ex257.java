package day39;

/*给你一个二叉树的根节点 root ，按任意顺序，返回所有从根节点到叶子节点的路径。
叶子节点 是指没有子节点的节点。*/

import java.util.ArrayList;
import java.util.List;

public class Ex257 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        Ex257 ex257 = new Ex257();
        List<String> strings = ex257.binaryTreePaths(root);
        System.out.println(strings);
    }

    //    递归，先判断是否为空，再判断是否为叶子节点，若为叶子节点，将路径加入结果集，否则递归左右子树，将路径加入结果集，递归结束后返回结果集
    List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        deal(root, "");
        return result;
    }

    public void deal(TreeNode node, String s) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            result.add(new StringBuffer(s).append(node.val).toString());
            return;
        }
        String tem = new StringBuffer(s).append(node.val).append("->").toString();
        deal(node.left, tem);
        deal(node.right, tem);
    }
}
