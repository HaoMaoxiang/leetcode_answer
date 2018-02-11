package No92_Reverse_Linked_List_II;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * <p>
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * <p>
 * return 1->4->3->2->5->NULL.
 * <p>
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 */
public class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;

        ListNode startNode = newHead;
        ListNode node1 = null, node2 = null;
        for (int i = 0; i < n; i++) {
            if (i < m - 1) {
                startNode = startNode.next;
            } else if (i == m - 1) {
                node1 = startNode.next;
                node2 = node1.next;
            } else {
                node1.next = node2.next;
                node2.next = startNode.next;
                startNode.next = node2;
                node2 = node1.next;
            }
        }
        return newHead.next;
    }
}
