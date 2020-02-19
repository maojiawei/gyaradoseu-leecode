package io.jovi.gyaradoseu.algorithm.leetcode.design;

/**
 * <p>
 * Title: 最小栈
 * </p >
 * <p>
 * Description:
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * </p >
 * <p>
 * Copyright: Copyright (c) 2019
 * All rights reserved. 2020-01-30.
 * </p >
 *
 * @author MaoJiaWei
 * @version 1.0
 */
public class MinStack {
    /**
     * 内部类 代表一个栈节点
     */
    class Node {
        /**
         * 保存的数据
         */
        Integer data;
        /**
         * 目前为止的最小值
         */
        Integer minNum;
        /**
         * 下一个节点的指针
         */
        Node next;

        /**
         * 构造函数初始化
         * @param data
         * @param minNum
         */
        Node(Integer data,Integer minNum){
            this.data = data;
            this.minNum = minNum;
        }
    }

    /**
     * 头结点，每次插入在头结点之前插入
     */
    Node head;

    /**
     * initialize your data structure here.
     * 初始化数据结构
     */
    public MinStack() {

    }

    /**
     * 在栈中，push是将数据x推入栈的最后
     *
     * @param x
     */
    public void push(int x) {
        // 如果head为空，说明栈中没有数据
        if(this.head == null){
            Node node = new Node(x,x);
            this.head = node;
            return;
        }
        // 如果不为空就在头部之前插入数据，注意要计算目前为止的最小数
        Node node = new Node(x,Math.min(x,this.head.data));
        node.next = this.head;
        this.head = node;
    }

    /**
     * 删除栈顶的元素
     */
    public void pop() {
        if(head == null){
            return;
        }
        this.head = this.head.next;
    }

    /**
     * 获取栈顶元素
     */
    public int top() {
        if(this.head != null){
            return this.head.data;
        }
        return -1;
    }

    public int getMin() {
        if(this.head != null){
            return this.head.minNum;
        }
        return -1;
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

    }
}
