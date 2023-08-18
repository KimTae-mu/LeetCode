package com.alva.LeetCode.back;

import com.alva.LeetCode.Reference.ListNode;
import org.junit.Test;

/**
 * <一句话描述>,
 * Reverse a linked list from position m to n. Do it in one-pass.
 * <p>
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * <p>
 * <详细介绍>,
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {

        int len = n - m + 1;
        ListNode pre_head = null;
        ListNode result = head;

        while (head != null && --m != 0) {
            pre_head = head;
            head = head.next;
        }
        ListNode modify_node_tail = head;
        ListNode new_head = null;
        while (head != null && len != 0) {
            ListNode temp = head.next;
            head.next = new_head;
            new_head = head;
            head = temp;
            len--;
        }
        modify_node_tail.next = head;

        if (pre_head != null) {
            pre_head.next = new_head;
        } else {
            result = new_head;
        }

        return result;
    }

    @Test
    public void test() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = null;

        System.out.println(reverseBetween(a, 2, 4));

    }
}
