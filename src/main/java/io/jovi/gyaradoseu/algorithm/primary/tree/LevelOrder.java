package io.jovi.gyaradoseu.algorithm.primary.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * Title:二叉树的层次遍历
 * </p>
 * <p>
 * Description:
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 *
 * @author Jovi
 * @version 1.0
 */
public class LevelOrder {
    /**
     * 二叉树的层次遍历
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        Map<Integer,List<Integer>> map = new HashMap<>(10);
        level(root,0,map);
        // 转换
        List<List<Integer>> list = new ArrayList<>(10);
        for(Integer level:map.keySet()){
            list.add(map.get(level));
        }
        return list;
    }

    /**
     * 根据等级查询
     * @param root
     * @param level
     * @return
     */
    private static Map<Integer,List<Integer>> level(TreeNode root, int level, Map<Integer,List<Integer>> map){
        if(root == null){
            return map;
        }
        List<Integer> list = map.get(level);
        if(list == null){
            list = new ArrayList<>();
        }
        // 根节点
        list.add(root.val);
        map.put(level,list);
        // 左子树
        level(root.left,level+1,map);
        //右子树
        level(root.right,level+1,map);
        return map;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        // 二叉树第二层
        TreeNode node21 = new TreeNode(9);
        root.setLeft(node21);
        TreeNode node22 = new TreeNode(20);
        root.setRight(node22);
        // 二叉树第三层
        TreeNode node221 = new TreeNode(15);
        node22.setLeft(node221);
        TreeNode node222 = new TreeNode(7);
        node22.setRight(node222);

        List<List<Integer>> list  = levelOrder(root);

        System.out.println(list);
    }
}
