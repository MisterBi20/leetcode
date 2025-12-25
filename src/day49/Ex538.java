package day49;

/*给出二叉搜索树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），
使每个节点node的新值等于原树中大于或等于node.val的值之和。
提醒一下，二叉搜索树满足下列约束条件：
节点的左子树仅包含键 小于 节点键的节点。
节点的右子树仅包含键 大于 节点键的节点。
左右子树也必须是二叉搜索树。*/

public class Ex538 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        Ex538 ex538 = new Ex538();
        System.out.println(ex538.convertBST(root).val);
    }

    //    右中左遍历，先遍历右子树，再遍历根节点，最后遍历左子树，
//    因为是二叉搜索树，所以右子树的节点值都大于根节点，左子树的节点值都小于根节点，
//    所以先遍历右子树，再遍历根节点，最后遍历左子树，就可以得到从大到小的顺序，
//    每次遍历到一个节点，就将当前的累加和sum加上该节点的值，
//    并将该节点的值更新为sum，就可以得到累加树。
    int sum;

    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        convertBST1(root);
        return root;
    }

    public void convertBST1(TreeNode root) {
        if (root == null) return;
        convertBST1(root.right);
        sum += root.val;
        root.val = sum;
        convertBST1(root.left);
    }
}
