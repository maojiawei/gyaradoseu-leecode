package io.jovi.gyaradoseu.algorithm.primary.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * Title: 删除链表的倒数第N个节点
 * </p>
 * <p>
 * Description:
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 *
 * @author Jovi
 * @version 1.0
 */
public class RemoveNthFromEnd {
    /**
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        Map<Integer,ListNode> map = new HashMap<>();

        ListNode node = head;
        int i = 1;
        while (node != null){
            map.put(i,node);
            node = node.next;
            i++;
        }
        int delNum = i-n;
        node = map.get(delNum);
        if(node.next == null){
            //如果为第一个元素
            if(delNum <=1){
                return null;
            }

            ListNode preNode = map.get(delNum-1);
            preNode.next = null;
            return head;
        }
        node.val = node.next.val;
        node.next = node.next.next;
        return head;
    }

    public static void main(String[] args) {
        test3();
    }

    public static void test1(){
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

        removeNthFromEnd(node1,2);

        ListNode node = node1;
        for (;;){
            System.out.println(node.val);
            if(node.next == null){
                break;
            }
            node = node.next;
        }
    }
    public static void test2(){
        //        4,5,1,9
        ListNode node1 = new ListNode(1);


        removeNthFromEnd(node1,1);

        ListNode node = node1;

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

    public static void test3(){
        //        4,5,1,9
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;


        removeNthFromEnd(node1,1);

        ListNode node = node1;

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
