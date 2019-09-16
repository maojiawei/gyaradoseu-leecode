package io.jovi.gyaradoseu.algorithm.primary.linkedlist;

/**
 * <p>
 * Title:反转链表
 * </p >
 * <p>
 * Description:
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * </p >
 * <p>
 * Copyright: Copyright (c) 2019
 * All rights reserved. 2019-09-16.
 * </p >
 *
 * @author MaoJiaWei
 * @version 1.0
 */
public class ReverseList {
    public static ListNode reverseList(ListNode head) {
        //当前节点
        ListNode pNode = head;
        //前置节点
        ListNode preNode = null;
        //下个节点
        ListNode next = head.next;
        while(next!=null) {
            pNode.next=preNode;
            preNode=pNode;
            pNode=next;
            next=pNode.next;
        }
        pNode.next=preNode;
        return pNode;
    }
    public static void main(String[] args) {
        //        4,5,1,9
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;

        reverseList(node1);

        ListNode node = node1;
        for (;;){
            System.out.println(node.val);
            if(node.next == null){
                break;
            }
            node = node.next;
        }
    }
}
