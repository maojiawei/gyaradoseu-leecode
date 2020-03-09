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
public class PostOrderTraversal {
    /**
     * 后序遍历(递归)
     * 左右根
     * @param root
     * @return
     */
    public static List<Integer> postOrderTraversal(TreeNode root){
        List<Integer> list = new LinkedList<>();

        // 1. 遍历左节点
        if(root.getLeft() != null){
            list.addAll(postOrderTraversal(root.getLeft()));
        }
        // 2. 遍历右节点
        if(root.getRight() != null){
            list.addAll(postOrderTraversal(root.getRight()));
        }
        // 3. 遍历根节点
        list.add(root.getVal());
        return list;
    }

    /**
     * 后序遍历(迭代)
     * 左右根
     * @param root
     * @return
     */
    public static List<Integer> postOrderTraversal2(TreeNode root){
        List<Integer> list = new LinkedList<>();

        Stack<TreeNode> stack = new Stack<>();
        //首先将根节点压栈
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode ele = stack.pop(); //首先出栈的为根节点，其后先出右子节点，后出左子节点
            if(ele.left != null)
                stack.push(ele.left);  //将左子节点压栈
            if(ele.right != null) {
                stack.push(ele.right); //将右子节点压栈
            }
            list.add(ele.val); //因为出栈顺序为“根右左”，所以需要每次将元素插入list开头
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

        List<Integer> list = postOrderTraversal(root);
        System.out.println(list);
    }
}
