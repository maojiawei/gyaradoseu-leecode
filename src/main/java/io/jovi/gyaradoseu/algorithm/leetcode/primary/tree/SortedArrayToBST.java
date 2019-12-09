package io.jovi.gyaradoseu.algorithm.leetcode.primary.tree;

/**
 * <p>
 * Title:将有序数组转换为二叉搜索树
 * </p>
 * <p>
 * Description:
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * <p>
 * 给定有序数组: [-10,-3,0,5,9],
 * <p>
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 *
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 *
 * @author Jovi
 * @version 1.0
 */
public class SortedArrayToBST {
    /**
     * 将有序数组转换为二叉搜索树
     *
     * @param nums
     * @return
     */
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return getTree(nums, 0, nums.length - 1);
    }

    /**
     * @param nums
     * @param l
     * @param r
     * @return
     */
    public static TreeNode getTree(int[] nums, int l, int r) {
        // r是总长度 l是当前高度
        if (r < l) {
            return null;
        }
        // 子树根节点
        int mid = (r+1)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = getTree(nums,l,mid+1);
        node.right = getTree(nums,mid+1,r);
        return node;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        sortedArrayToBST(nums);
    }
}
