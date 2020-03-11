package io.jovi.gyaradoseu.algorithm.leetcode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <p>
 * Title: 广度优先遍历
 * </p>
 * <p>
 * Description:
 *
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 *
 * @author Jovi
 * @version 1.0
 */
public class BreadFirstSearch {
    /**
     * 广度优先遍历
     * @param root
     * @return
     */
    public static List<Integer> bfs(TreeNode root){
        // 存放遍历的结果
        List<Integer> list = new LinkedList<>();
        // 队列 先进先出
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            // 左子节点 加入队列 左子节点先取出 先进先出
            if(node.left != null){
                queue.add(node.left);
            }
            // 右子节点 加入队列
            if(node.right != null){
                queue.add(node.right);
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

        List<Integer> list = bfs(root);
        System.out.println(list);
    }


}
