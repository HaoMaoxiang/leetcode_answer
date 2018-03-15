package No160_Intersection_of_Two_Linked_Lists;

import BasicDataStruct.ListNode;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * <p>
 * <p>
 * For example, the following two linked lists:
 * <p>
 * A:          a1 → a2
 * ↘
 * c1 → c2 → c3
 * ↗
 * B:     b1 → b2 → b3
 * begin to intersect at node c1.
 * <p>
 * <p>
 * Notes:
 * <p>
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node = null;
        int len1 = len(headA), len2 = len(headB);
        if (len1 > len2) {
            for (int i = 0; i < len1 - len2 && headA != null; i++) {
                headA = headA.next;
            }
        } else {
            for (int i = 0; i < len2 - len1 && headB != null; i++) {
                headB = headB.next;
            }
        }

        while (headA != null && headB != null) {
            if (headA == headB) {
                node = headA;
                break;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return node;
    }

    private int len(ListNode head) {
        ListNode node = head;
        int l = 0;
        while (node != null) {
            l += 1;
            node = node.next;
        }
        return l;
    }
}
