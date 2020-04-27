package io.jovi.gyaradoseu.algorithm.leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * Title:  合并K个排序链表
 * </p>
 * <p>
 * Description:
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * All rights reserved. 2020-04-27.
 * </p>
 *
 * @author MaoJiaWei
 * @version 1.0
 */
public class MergeKLists {
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode root = new ListNode(0);
        ListNode point = root;
        while (true) {
            // 最小值
            int minVal = Integer.MAX_VALUE;
            // 最小值对应的位置
            int position = -1;
            // 依次循环每个链表
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    if (lists[i].val < minVal) {
                        minVal = lists[i].val;
                        position = i;
                    }
                }
            }
            if (minVal == Integer.MAX_VALUE) {
                break;
            }
            point.next = new ListNode(minVal);
            point = point.next;
            lists[position] = lists[position].next;
        }
        return root.next;
    }

    public static void main(String[] args) {
        ListNode n11 = new ListNode(1);
        ListNode n12 = new ListNode(4);
        n11.next = n12;
        ListNode n13 = new ListNode(5);
        n12.next = n13;

        ListNode n21 = new ListNode(1);
        ListNode n22 = new ListNode(3);
        n21.next = n22;
        ListNode n23 = new ListNode(4);
        n22.next = n23;

        ListNode n31 = new ListNode(2);
        ListNode n32 = new ListNode(6);
        n31.next = n32;

        ListNode[] nodes = new ListNode[3];
        nodes[0] = n11;
        nodes[1] = n21;
        nodes[2] = n31;

        ListNode node = mergeKLists(nodes);

        for (;;){
            if(node == null){
                break;
            }
            System.out.println(node.val);
            if(node.next == null){
                break;
            }
            node = node.next;
        }
    }
}
