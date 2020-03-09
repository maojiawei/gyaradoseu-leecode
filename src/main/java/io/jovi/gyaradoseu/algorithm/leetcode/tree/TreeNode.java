package io.jovi.gyaradoseu.algorithm.leetcode.tree;

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
public class TreeNode {
    /**
     * 树值
     */
    int val;
    /**
     * 左子树
     */
    TreeNode left;
    /**
     * 右子树
     */
    TreeNode right;

    /**
     * 构造函数 含值
     * @param x
     */
    TreeNode(int x) { val = x; }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
