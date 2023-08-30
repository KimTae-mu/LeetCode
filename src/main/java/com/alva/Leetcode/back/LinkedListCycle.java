package com.alva.Leetcode.back;

import com.alva.Leetcode.Reference.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * <一句话描述>,
 * Given a linked list, determine if it has a cycle in it.
 * <p>
 * Follow up:
 * Can you solve it without using extra space?
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class LinkedListCycle {

    /**
     * 使用一个set集合来判断是否有重复元素从而判断是否有环
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }

    /**
     * 分别一个快指针和慢指针,快指针走的路程是慢指针的两倍,若两指针相遇则代表存在环,
     * 若不相遇则不存在环;
     * 存在环时,快慢指针相遇的位置与链表头结点分别相距环起始点的位置距离相同,
     * 则一次遍历头结点与相遇结点,两者相遇点即为环开始点.
     *
     * @param head
     * @return
     */
    public boolean hasCycleII(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode meet = null;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
            if (fast == slow) {
                meet = fast;
                break;
            }
        }

        if (meet == null) {
            return false;
        }
        while (head != null && meet != null) {
            if (head == meet) {
                return true;
            }
            head = head.next;
            meet = meet.next;
        }

        return false;
    }
}
