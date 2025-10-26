package day27;

//给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex106 {
    Map<Integer, Integer> map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] inorder = new int[n];
        int[] postorder = new int[n];
        for (int i = 0; i < n; i++) {
            inorder[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            postorder[i] = sc.nextInt();
        }
        Ex106 ex106 = new Ex106();
        TreeNode root = ex106.buildTree(inorder, postorder);
    }

    //建立二叉树，递归建立左子树和右子树,左闭右开，后序遍历的最后一个元素为根节点
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return findNode(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    public TreeNode findNode(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
        if (inBegin >= inEnd || postBegin >= postEnd) return null;
        int rootIndex = map.get(postorder[postEnd-1]);
        TreeNode root = new TreeNode(inorder[rootIndex]);
        int lenOfLeft = rootIndex - inBegin;
        root.left = findNode(inorder, inBegin, rootIndex, postorder, postBegin, postBegin + lenOfLeft);
        root.right = findNode(inorder, rootIndex + 1, inEnd, postorder, postBegin + lenOfLeft, postEnd - 1);
        return root;
    }
}
