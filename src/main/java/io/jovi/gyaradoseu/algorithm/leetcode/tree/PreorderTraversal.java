package io.jovi.gyaradoseu.algorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
public class PreorderTraversal {
    /**
     * 前序遍历(递归)
     * 根左右
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal(TreeNode root){
        List<Integer> list = new LinkedList<>();
        // 1. 遍历根节点
        list.add(root.getVal());
        // 2. 遍历左节点
        if(root.getLeft() != null){
            list.addAll(preorderTraversal(root.getLeft()));
        }
        // 3. 遍历右节点
        if(root.getRight() != null){
            list.addAll(preorderTraversal(root.getRight()));
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
        node2.right = node21;

        TreeNode node112 = new TreeNode(6);
        node11.right = node112;

        TreeNode node1122 = new TreeNode(7);
        node112.right = node1122;

        List<Integer> list = preorderTraversal(root);
        System.out.println(list);
    }
}
