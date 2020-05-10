package io.jovi.gyaradoseu.algorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * <p>
 * Title: 二叉树的锯齿形层次遍历
 * </p>
 * <p>
 * Description:
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * All rights reserved. 2020-05-06.
 * </p>
 *
 * @author MaoJiaWei
 * @version 1.0
 */
public class ZigzagLevelOrder {

    /**
     * 二叉树的锯齿形层次遍历
     * @param root
     * @return
     */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // 1. 如果root为空 返回部分
        if (root == null) {
            return new LinkedList<>();
        }
        // 结果集
        List<List<Integer>> result = new LinkedList<>();
        // 树的层数
        int depth = 1;
        // 队列 先进先出
        Queue<TreeNode> queue = new LinkedList<>();
        // 优先插入根节点
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 同一层的集合
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                // 默认先取左边 再取右边
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            // 如果层数为2的倍数 需要将从左往右 改为从右往左
            if (depth % 2 == 0) {
                Collections.reverse(list);
            }
            depth++;
            result.add(list);
        }
        return result;
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        root.setLeft(node1);
        root.setRight(node2);

//        TreeNode node11 = new TreeNode(4);
//        node1.left = node11;

        TreeNode node21 = new TreeNode(15);
        node2.left = node21;

        TreeNode node22 = new TreeNode(7);
        node2.left = node22;


        List<List<Integer>> list = zigzagLevelOrder(root);
        int index = 1;
        for(List<Integer> nodeList:list){
            System.out.println("start i="+index);
            for(Integer val: nodeList){
                System.out.println("val="+val);
            }
            System.out.println("end i="+index);
            index++;
        }
    }
}
