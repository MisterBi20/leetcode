package day47;

/*给你一个含重复值的二叉搜索树（BST）的根节点 root ，
找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
如果树中有不止一个众数，可以按 任意顺序 返回。
假定 BST 满足如下定义：
结点左子树中所含节点的值 小于等于 当前节点的值
结点右子树中所含节点的值 大于等于 当前节点的值
左子树和右子树都是二叉搜索树*/

import java.util.ArrayList;

public class Ex501 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        Ex501 ex501 = new Ex501();
        int[] res = ex501.findMode(root);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    //    中序遍历，记录当前节点的值和上一个节点的值，
//    如果当前节点的值和上一个节点的值相等，count加1，
//    如果当前节点的值和上一个节点的值不相等，count重置为1，
//    如果count大于maxCount，清空resList，将当前节点的值加入resList，maxCount更新为count，
//    如果count等于maxCount，将当前节点的值加入resList，
//    最后返回resList。
    ArrayList<Integer> resList;
    int maxCount;
    int count;
    TreeNode pre;

    public int[] findMode(TreeNode root) {
        resList = new ArrayList<>();
        maxCount = 0;
        count = 0;
        pre = null;
        findMode1(root);
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    public void findMode1(TreeNode root) {
        if (root == null) return;
        findMode1(root.left);
        int rootVal = root.val;
        if (pre == null || rootVal != pre.val) count = 1;
        else count++;
        if (count > maxCount) {
            resList.clear();
            resList.add(rootVal);
            maxCount = count;
        } else if (count == maxCount) resList.add(rootVal);
        pre = root;
        findMode1(root.right);
    }
}
