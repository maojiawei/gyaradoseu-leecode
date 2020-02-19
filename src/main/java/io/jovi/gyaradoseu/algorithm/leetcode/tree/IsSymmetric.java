package io.jovi.gyaradoseu.algorithm.leetcode.tree;

/**
 * <p>
 * Title:对称二叉树
 * </p>
 * <p>
 * Description:
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * 说明:
 * <p>
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 *
 * @author Jovi
 * @version 1.0
 */
public class IsSymmetric {
    /**
     * 思路：
     * 1. 左子树的左边和右子树的右边相同
     * 2. 左子树的右边和右子树的左边相同
     *
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        if(root.left == null && root.right == null){
            return true;
        }

        return isSymmetrical2(root.left, root.right);
    }

    public static boolean isSymmetrical2(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        //判断A的左边和B的右边是否相等，判断A的右边和B的左边是否相等，都相等就满足
        return isSymmetrical2(root1.left, root2.right) && isSymmetrical2(root1.right, root2.left);
    }

    /**
     * 程序主入口
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        // 二叉树第二层
        TreeNode node21 = new TreeNode(2);
        root.setLeft(node21);
        TreeNode node22 = new TreeNode(2);
        root.setRight(node22);
        // 二叉树第三层
        TreeNode node211 = new TreeNode(3);
        node21.setLeft(node211);
        TreeNode node212 = new TreeNode(4);
        node21.setRight(node212);

        TreeNode node221 = new TreeNode(5);
        node22.setLeft(node221);
        TreeNode node222 = new TreeNode(3);
        node22.setRight(node222);
        //计算深度
        boolean flag = isSymmetric(root);
        System.out.println(flag);
    }
}
