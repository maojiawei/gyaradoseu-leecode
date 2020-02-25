package io.jovi.gyaradoseu.algorithm.interview;

/**
 * <p>
 * Title: 固定长度数据队列
 * </p>
 * <p>
 * Description:
 * 使用固定长度的数组实现一个队列
 * 要求:
 * 1. 时间复杂度O(1)
 * 2. 实现入队列和出队列两个方法
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 *
 * @author Jovi
 * @version 1.0
 */
public class ArrayQueue {
    /**
     * 写指针，指向入队列的位置
     */
    private int writeIndex;
    /**
     * 读指针，指向出队列的位置
     */
    private int readIndex;
    /**
     * 队列的长度
     */
    private int size;
    /**
     * 固定长度数组
     */
    private int[] array = null;
    /**
     * 构造器，根据容量初始化数组
     */
    public ArrayQueue(int capacity){
        array = new int[capacity];
    }

    /**
     * 入队列
     * @param v 需要添加的元素
     */
    public void enqueue(int v){
        // 判断队列是否有充足的元素
        if(size >= array.length){
            throw new ArrayIndexOutOfBoundsException("the queue is full");
        }
        // 插入数据
        array[writeIndex] = v;
        // 如果写指针超过长度 从0开始
        writeIndex = (++writeIndex) % array.length;
        size++;
    }

    /**
     * 出队列
     * @return
     */
    public int dequeue(){
        // 如果队列为空
        if(size == 0){
            throw new ArrayIndexOutOfBoundsException("the queue is empty");
        }
        // 插入数据
        int value = array[readIndex];
        // 如果读指针超过长度 从0开始
        readIndex = (++readIndex) % array.length;
        size--;
        return value;
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        int a = queue.dequeue();
        int b = queue.dequeue();
        int c = queue.dequeue();
        int d = queue.dequeue();
        int e = queue.dequeue();
        System.out.println(a+" "+b+" "+c+" "+d+" "+e+" ");
    }
}
