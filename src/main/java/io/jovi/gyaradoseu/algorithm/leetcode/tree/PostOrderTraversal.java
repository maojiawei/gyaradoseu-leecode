package io.jovi.gyaradoseu.algorithm.leetcode.tree;

import java.util.LinkedList;
import java.util.List;

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
