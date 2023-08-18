package com.alva.LeetCode.back;

import com.alva.LeetCode.Reference.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * <一句话描述>,
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * <p>
 * <详细介绍>,
 * For example, the following two linked lists:
 * <p>
 * A:          a1 → a2
 * ↘
 * c1 → c2 → c3
 * ↗
 * B:     b1 → b2 → b3
 * begin to intersect at node c1.
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class IntersectionofTwoLinkedLists {

    public ListNode getIntersectionNodeI(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();

        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }

    public ListNode getIntersectionNodeII(ListNode headA, ListNode headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);

        if (lenA < lenB) {
            headB = forwardLongList(lenB, lenA, headB);
        } else {
            headA = forwardLongList(lenA, lenB, headA);
        }

        while (headA != null && headB != null) {
            if (headA.val == headB.val) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    public int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }

        return len;
    }

    public ListNode forwardLongList(int long_len, int short_len, ListNode head) {
        int delta = long_len - short_len;
        while (head != null && delta != 0) {
            head = head.next;
            delta--;
        }
        return head;
    }

    public ListNode getIntersectionNodeIII(ListNode headA, ListNode headB) {
        headA = reverseList(headA);
        headB = reverseList(headB);
        int i = 0;

        while (headA!=null&&headB!=null){
            if(headA.val == headB.val){
                i++;
            }else {
                break;
            }

            headA = headA.next;
            headB = headB.next;
        }
        if(i != 0){
            return headA;
        }else {
            return null;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

}
