package io.jovi.gyaradoseu.algorithm.primary.linkedlist;

/**
 * <p>
 * Title: 回文链表
 * </p>
 * <p>
 * Description:
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 *
 * @author Jovi
 * @version 1.0
 */
public class IsPalindrome {
    /**
     * 1. 计算长度 取一半的长度
     * 2. 建立一个数组 一般长度数组，与每项进行匹配。
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        ListNode node = head;
        // 计算链表的总长度
        int size = 1;
        while (node.next != null){
            size ++;
            node = node.next;
        }
        System.out.println(size);
        int numSize = size /2 ;
        int[] nums = new int[numSize];
        // 半数之前的放入数组
        node = head;
        for(int i=0;i < numSize;i++){
            nums[i] = node.val;
            node = node.next;
        }
        System.out.println(nums);
        // 如果总的为计数 跳过一个
        if(size % 2 == 1){
            node = node.next;
        }
        int j = numSize;
        while (j > 0){
            if(node.val != nums[j-1]){
                return false;
            }
            node = node.next;
            j--;
        }
        return true;
    }

    public static boolean isPalindrome2(ListNode head) {
        // 要实现 O(n) 的时间复杂度和 O(1) 的空间复杂度，需要翻转后半部分
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        // 根据快慢指针，找到链表的中点
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = reverse(slow.next);
        while(slow != null) {
            if (head.val != slow.val) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    private static ListNode reverse(ListNode head){
        // 递归到最后一个节点，返回新的新的头结点
        if (head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(0);
        n1.next = n2;
        ListNode n3 = new ListNode(1);
        n2.next = n3;
        ListNode n4 = new ListNode(0);
        n3.next = n4;
        ListNode n5 = new ListNode(0);
        n4.next = n5;

//        ListNode n4 = new ListNode(3);
//        n3.next = n4;
        boolean b = isPalindrome2(n1);
        System.out.println(b);
    }


}
