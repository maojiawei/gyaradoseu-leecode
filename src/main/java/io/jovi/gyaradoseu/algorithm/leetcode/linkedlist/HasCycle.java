package io.jovi.gyaradoseu.algorithm.leetcode.linkedlist;

/**
 * <p>
 * Title: 环形链表
 * </p>
 * <p>
 * Description:
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 *
 * 示例 2：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 *
 * 示例 3：
 *
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 *
 *
 *
 *
 * 进阶：
 *
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 *
 * @author Jovi
 * @version 1.0
 */
public class HasCycle {
    /**
     * 环形链表
     * 利用快慢指针
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        // 快指针每次走两步
        ListNode fast = head;
        // 慢指针每次走一步
        ListNode slow = head;

        // 快指针走的比较快 如果快指针走到尽快（即本身或下一指针为空）
        // 即链表访问结束 没有环
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 快慢指针如果走到同一个地方说明有环
            if (slow == fast){
                return true;
            }
        }
        return false;
    }
}
