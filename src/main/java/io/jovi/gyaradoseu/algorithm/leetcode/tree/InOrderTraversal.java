package io.jovi.gyaradoseu.algorithm.leetcode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * <p>
 * Title:
 * </p >
 * <p>
 * Description:
 * </p >
 * <p>
 * Copyright: Copyright (c) 2019
 * All rights reserved. 2020-03-09.
 * </p >
 *
 * @author MaoJiaWei
 * @version 1.0
 */
public class InOrderTraversal {
    /**
     * 中序遍历(递归)
     * 左根右
     * @param root
     * @return
     */
    public static List<Integer> inOrderTraversal(TreeNode root){
        List<Integer> list = new LinkedList<>();

        // 1. 遍历左节点
        if(root.getLeft() != null){
            list.addAll(inOrderTraversal(root.getLeft()));
        }
        // 2. 左节点遍历完了，遍历根节点
        list.add(root.getVal());
        // 3. 遍历右节点
        if(root.getRight() != null){
            list.addAll(inOrderTraversal(root.getRight()));
        }
        return list;
    }

    /**
     * 中序遍历(迭代)
     * 左根右
     * @param root
     * @return
     */
    public static List<Integer> inOrderTraversal2(TreeNode root){
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        // 因为栈（先进后出） 最左边的节点可以先取出
        while(!stack.isEmpty() || root != null) {
            // 先压入左子树 直到不能压位置

            if(root != null) {
                stack.push(root);
                root = root.left;
            }else {
                root = stack.pop();
                root = root.right;
            }
        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.setLeft(node1);
        root.setRight(node2);

        TreeNode node11 = new TreeNode(4);
        node1.left = node11;

        TreeNode node21 = new TreeNode(5);
        node2.left = node21;

        TreeNode node112 = new TreeNode(6);
        node11.right = node112;

        TreeNode node1122 = new TreeNode(7);
        node112.right = node1122;

        List<Integer> list = inOrderTraversal(root);
        System.out.println(list);
    }
}
