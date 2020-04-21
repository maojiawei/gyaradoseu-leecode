package io.jovi.gyaradoseu.algorithm.leetcode.linkedlist;

/**
 * <p>
 * Title: 两数相加
 * </p>
 * <p>
 * Description:
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * All rights reserved. 2020-04-21.
 * </p>
 *
 * @author MaoJiaWei
 * @version 1.0
 */
public class AddTwoNumbers {
    /**
     * 两数相加
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 进位器 当相加数字大于10的时候
        boolean count = false;
        // 创建一个新的node
        int val1 = l1.val;
        int val2 = l2.val;
        int sum = val1 + val2;
        // 如果大于10 进1
        if(sum >= 10){
            count = true;
            sum = sum % 10;
        }
        // 初始节点
        ListNode firstNode = new ListNode(sum);
        // 进行中的节点 以免下一个指针
        ListNode processNode = firstNode;
        // 终止条件 两个链表任意一个没有下一个值得时候 断开
        while (l1.next!= null && l2.next != null){
            int val1x = l1.next.val;
            int val2x = l2.next.val;
            int sumx = val1x + val2x;
            if(count){
                sumx++;
                count = false;
            }
            // 如果大于10 进1
            if(sumx >= 10){
                count = true;
                sumx = sumx % 10;
            }
            ListNode node = new ListNode(sumx);
            processNode.next = node;
            processNode = node;

            l1 = l1.next;
            l2 = l2.next;
        }
        // 找出两个链表没有查询完毕的那个
        ListNode l = l1.next != null ? l1 : l2;
        // 对没有查询完毕的 链表循环 查询没有循环到的元素
        while (l.next != null){
            int valx = l.next.val;
            // 还是要考虑+1的情况 如果有9可能考虑下一个需要进位
            if(count && valx == 9){
                // 如果原先为9 那么+1 需要进位 因为是10
                // 下一个还是需要进位
                valx = 0;
            } else if(count) {
                valx++;
            }
            ListNode node = new ListNode(valx);
            processNode.next = node;
            processNode = node;
            l = l.next;
        }
        // 查询是否需要进位
        if(count){
            // 如果进位 因为没有数据 直接为1
            ListNode node = new ListNode(1);
            processNode.next = node;
        }
        return firstNode;
    }

    public static void main(String[] args) {
        ListNode node11 = new ListNode(9);
        ListNode node12 = new ListNode(9);
        node11.next = node12;

        ListNode node21 = new ListNode(1);

        ListNode node = addTwoNumbers(node11,node21);
//        ListNode node = node;
        for (;;){
            System.out.println(node.val);
            if(node.next == null){
                break;
            }
            node = node.next;
        }
    }

}
