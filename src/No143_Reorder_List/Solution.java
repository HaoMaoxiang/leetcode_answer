package No143_Reorder_List;

import BasicDataStruct.ListNode;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * You must do this in-place without altering the nodes' values.
 * <p>
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        ListNode newHead = new ListNode(-1);
        newHead.next = head2;
        while (head2.next != null) {
            ListNode node = head2.next;
            head2.next = node.next;
            node.next = newHead.next;
            newHead.next = node;
        }
        head = merge(head, newHead.next);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode node1 = head1, node2 = head2;
        boolean flag = true;
        while (node2 != null) {
            ListNode p = node1.next, q = node2.next;
            node2.next = p;
            node1.next = node2;
            node1 = p; node2 = q;
        }
        return head1;
    }
}
