package io.jovi.gyaradoseu.algorithm.leetcode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * <p>
 * Title: 深度优先遍历
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
public class DepthFirstSearch {
    /**
     * 深度优先遍历
     * @param root
     * @return
     */
    public static List<Integer> dfs(TreeNode root){
        List<Integer> list = new LinkedList<>();
        // 栈 先进后出
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()){
            // 取出栈中元素 放入结果集中
            TreeNode node = stack.pop();
            list.add(node.val);
            // 先进后出 先取出左子树 所以先进右子树
            if(node.right != null){
                stack.push(node.right);
            }
            // 后进左子树 后进先出
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
        node2.left = node21;

        TreeNode node112 = new TreeNode(6);
        node11.right = node112;

        TreeNode node1122 = new TreeNode(7);
        node112.right = node1122;

        List<Integer> list = dfs(root);
        System.out.println(list);
    }
}
