package No24_Swap_Nodes_in_Pairs;

import java.util.List;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * <p>
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {

    public ListNode swapPairs(ListNode head) {
        ListNode result = head;
        ListNode o, p, q;
        if (head == null || head.next == null) {
            return head;
        }
        result = head.next;
        head.next = result.next;
        result.next = head;
        o = result.next;
        p = o.next;
        if (p == null) {
            return result;
        }
        q = p.next;
        while (q != null) {
            p.next = q.next;
            q.next = p;
            o.next = q;
            o = p; p = o.next;
            if (p == null) {
                return result;
            }
            q = p.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        head.next = node2; node2.next = node3; node3.next = node4;
        Solution s = new Solution();
        s.swapPairs(head);
    }
}
