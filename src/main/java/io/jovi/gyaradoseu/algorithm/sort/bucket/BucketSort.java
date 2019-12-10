package io.jovi.gyaradoseu.algorithm.sort.bucket;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * <p>
 * Title: 桶排序
 * </p >
 * <p>
 * Description:
 * </p >
 * <p>
 * Copyright: Copyright (c) 2019
 * All rights reserved. 2019-12-10.
 * </p >
 *
 * @author MaoJiaWei
 * @version 1.0
 */
public class BucketSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 8, 4, 1};

        bucketSort(nums);

        for (int n : nums) {
            System.out.println(n);
        }
    }

    public static void bucketSort(int[] nums){
        int max = 10;
        LinkedList<Integer>[] buckets = new LinkedList[max];
        for(int num:nums){
            int index = getIndex(num);
            addLinkedList(buckets,index,num);
        }
        // 将桶中元素全部取出来并放入 arr 中输出
        int index = 0;
        for (LinkedList<Integer> bucket : buckets) {
            if(bucket == null){
                continue;
            }
            for (Integer data : bucket) {
                nums[index++] = data;
            }
        }

    }

    /**
     * 获取索引
     * @return
     */
    private static Integer getIndex(Integer num){
        return num;
    }

    /**
     * 有序的插入后排的LinkedList
     */
    private static void addLinkedList(LinkedList<Integer>[] buckets,int index,int num){
        LinkedList<Integer> list = buckets[index];
        // 如果链表为空 插入一个链表
        if(list == null){
            list = new LinkedList<>();
            list.add(num);
            buckets[index] = list;
            return;
        }

        ListIterator<Integer> it = list.listIterator();
        boolean insertFlag = false;
        while (it.hasNext()){
            //如果值比当前链表值大 接着下一个
            if(it.next() < num){
                continue;
            }
            insertFlag = true;
            // 回退上一个
            it.previous();
            it.add(num);
            break;
        }
        if(!insertFlag){
            it.add(num);
        }

    }
}
