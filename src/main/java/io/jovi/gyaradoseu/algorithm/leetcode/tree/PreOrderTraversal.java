package io.jovi.gyaradoseu.algorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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
public class PreOrderTraversal {
    /**
     * 前序遍历(递归)
     * 根左右
     * @param root
     * @return
     */
    public static List<Integer> preOrderTraversal(TreeNode root){
        List<Integer> list = new LinkedList<>();
        // 1. 遍历根节点
        list.add(root.getVal());
        // 2. 遍历左节点
        if(root.getLeft() != null){
            list.addAll(preOrderTraversal(root.getLeft()));
        }
        // 3. 遍历右节点
        if(root.getRight() != null){
            list.addAll(preOrderTraversal(root.getRight()));
        }

        return list;
    }

    /**
     * 前序遍历(迭代)
     * 根左右
     * @param root
     * @return
     */
    public static List<Integer> preOrderTraversal2(TreeNode root){
        List<Integer> list = new LinkedList<>();
        // 栈 先进后出 利用该特点 预存左右子树信息
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        //循环遍历 直至栈为空停止
        while (!stack.empty()){
            TreeNode node = stack.pop();
            list.add(node.val);
            // 先存入右子数 因为需要先取出左子树（先进后出）
            if(node.right != null){
                stack.push(node.right);
            }
            // 先存入左子树
            if(node.left != null){
                stack.push(node.left);
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
        node2.right = node21;

        TreeNode node112 = new TreeNode(6);
        node11.right = node112;

        TreeNode node1122 = new TreeNode(7);
        node112.right = node1122;

        List<Integer> list = preOrderTraversal2(root);
        System.out.println(list);
    }
}
