package io.jovi.gyaradoseu.algorithm.leetcode.primary.tree;

/**
 * <p>
 * Title: 验证二叉搜索树
 * </p >
 * <p>
 * Description:
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 * </p >
 * <p>
 * Copyright: Copyright (c) 2019
 * All rights reserved. 2019-11-05.
 * </p >
 *
 * @author MaoJiaWei
 * @version 1.0
 */
public class IsValidBST {
    /**
     * 是否平衡二叉树
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
        if(root!=null) {
            //查看左树是否为平衡二叉树
            boolean n1=isValidBST(root.left);
            //查看右树是否为平衡二叉树
            boolean n2=isValidBST(root.right);
            if( !(n1 && n2) ){
                return false;
            }
            //如果左右节点都没有，即叶子节点 则也是为平衡二叉树
            if(root.left == null && root.right == null){
                return true;
            }
            //左右节点进行对比
            int rootNode = root.val;
            // 左子树要小于根节点
            TreeNode leftNode = root.left;
            while (leftNode != null){
                int leftTreeNode = root.left.val;
                if(rootNode <= leftTreeNode) {
                    return false;
                }
                leftNode = leftNode.left;
            }

            TreeNode rightNode = root.right;
            while (rightNode != null){
                //右子树要大于根节点
                int rightTreeNode = root.right.val;
                if(rightTreeNode <= rootNode) {
                    return false;
                }
                rightNode = rightNode.right;
            }
            return true;
        }else {
            return true;
        }
    }
    // 别人的解答
    /**
     *
     */
    static long last = Long.MIN_VALUE;
    public static boolean isValidBST2(TreeNode root) {
        return inOrder(root);
    }

    public static boolean inOrder(TreeNode root){

        if(root!=null){
            if(inOrder(root.left)==false) return false;
            if(root.val<=last) return false;
            last = root.val;
            if(inOrder(root.right)==false) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);

        // 二叉树第二层
        TreeNode node21 = new TreeNode(5);
        root.setLeft(node21);
        TreeNode node22 = new TreeNode(15);
        root.setRight(node22);

        // 二叉树第三层
        TreeNode node221 = new TreeNode(6);
        node22.setLeft(node221);
        TreeNode node222 = new TreeNode(20);
        node22.setRight(node222);

        boolean flag = isValidBST2(root);
        System.out.println(flag);
    }
}
