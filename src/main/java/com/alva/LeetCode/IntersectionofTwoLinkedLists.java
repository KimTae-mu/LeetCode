package com.alva.LeetCode;

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

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
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

}
