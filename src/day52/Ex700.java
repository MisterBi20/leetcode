package day52;

/*给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。*/

public class Ex700 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        Ex700 ex700 = new Ex700();
        TreeNode treeNode = ex700.searchBST(root, 2);
        System.out.println(treeNode.val);
    }

    //    递归，
//    如果根节点为空，或者根节点的值等于val，返回根节点，
//    如果val小于根节点的值，递归查找左子树，
//    否则，递归查找右子树。
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        if (val < root.val) return searchBST(root.left, val);
        else return searchBST(root.right, val);
    }
}
