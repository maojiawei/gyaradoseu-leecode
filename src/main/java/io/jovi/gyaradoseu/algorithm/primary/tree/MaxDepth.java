package io.jovi.gyaradoseu.algorithm.primary.tree;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 *
 * @author Jovi
 * @version 1.0
 */
public class MaxDepth {
    /**
     * 找出最大长度
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        int length = 0;
        if(root == null){
            return length;
        }
        //算上本身为一个深度
        length += 1;
        // 叶子节点
        if(root.getLeft() == null && root.getRight() == null){
            return length;
        }
        int maxLength = 0;
        if(root.getLeft() != null){
            int leftLength = maxDepth(root.getLeft());
            maxLength = leftLength;
        }
        if(root.getRight() != null){
            int rightLength = maxDepth(root.getRight());
            if(rightLength > maxLength){
                maxLength = rightLength;
            }
        }
        length += maxLength;
        return length;
    }

    public static int maxDepth2(TreeNode root) {
        if(root!=null) {
            //获取左子树的高度
            int n1=this.maxDepth2(root.left);
            //获取右子树的高度
            int n2=this.maxDepth2(root.right);
            //返回左子树，右子树较大的高度+1
            return n1>n2?n1+1:n2+1;
        }else {
            return 0;
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        // 二叉树第二层
        TreeNode node21 = new TreeNode(9);
        root.setLeft(node21);
        TreeNode node22 = new TreeNode(20);
        root.setRight(node22);
        // 二叉树第三层
        TreeNode node221 = new TreeNode(15);
        node22.setLeft(node221);
        TreeNode node222 = new TreeNode(7);
        node22.setRight(node222);
        //计算深度
        int length = maxDepth(root);
        System.out.println(length);
    }


}
