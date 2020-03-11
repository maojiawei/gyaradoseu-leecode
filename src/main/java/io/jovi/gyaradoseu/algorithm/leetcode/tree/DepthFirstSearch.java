package io.jovi.gyaradoseu.algorithm.leetcode.tree;

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
public class DepthFirstSearch {
    public List<Integer> dfs(TreeNode root){
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

    }
}
