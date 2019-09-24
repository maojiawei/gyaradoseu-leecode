package io.jovi.gyaradoseu.algorithm.primary.linkedlist;

/**
 * <p>
 * Title:合并两个有序链表
 * </p>
 * <p>
 * Description:
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 *
 * @author Jovi
 * @version 1.0
 */
public class MergeTwoLists {
    /**
     * 1. 先保证l1的第一位小于l2的第一位
     *
     * @param l1
     * @param l2
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }
        if((l1 != null && l2 ==null) || (l2 != null && l1 ==null)){
            return l1 != null?l1:l2;
        }
        int val1 = l1.val;
        int val2 = l2.val;
        // 1.先保证l1的第一位小于l2的第一位
        if(val2 < val1){
            ListNode tmp = l1;
            l1 = l2;
            l2 = tmp;
        }
        // 2. 循环l1的每一位
        //确定一个n1作为l1的下标元素 n2作为l2的下标元素
        ListNode n1 = l1;
        ListNode n2 = l2;
        while (n1.next != null && n2 !=null){
            int valN11 = n1.val;
            int valN12 = n1.next.val;
            int valN2 = n2.val;

            if( !(valN11 <= valN2 && valN2 <= valN12) ){
                n1 = n1.next;
                continue;
            }
            ListNode n3 = n1.next;
            ListNode n4 = n2.next;

            n1.next = n2;
            n1 = n2;

            n2.next = n3;
            n2 = n4;

        }
        if(n2 != null){
            n1.next = n2;
        }
        return l1;
    }

    public static void main(String[] args) {
//        1,2,4
        ListNode n11 = new ListNode(-2);
        ListNode n12 = new ListNode(5);
        n11.next = n12;
//      1,3,4
        ListNode n21 = new ListNode(-1);
        ListNode n22 = new ListNode(1);
        n21.next = n22;
        ListNode n23 = new ListNode(6);
        n22.next = n23;

//        //        1,2,4
//        ListNode n11 = new ListNode(1);
//        ListNode n12 = new ListNode(2);
//        n11.next = n12;
//        ListNode n13 = new ListNode(4);
//        n12.next = n13;
////      1,3,4
//        ListNode n21 = new ListNode(1);
//        ListNode n22 = new ListNode(3);
//        n21.next = n22;
//        ListNode n23 = new ListNode(4);
//        n22.next = n23;

        ListNode node = mergeTwoLists(n11,n21);

        for (;;){
            System.out.println(node.val);
            if(node.next == null){
                break;
            }
            node = node.next;
        }
    }

}
