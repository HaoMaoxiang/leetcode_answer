package No147_Insertion_Sort_List;

import BasicDataStruct.ListNode;

/**
 * Sort a linked list using insertion sort.
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode start = new ListNode(-1);
        start.next = head;
        if (head == null) {
            return head;
        }
        ListNode end = head;
        ListNode cur = end.next;
        while (cur != null) {
            if (cur.val < end.val) {
                ListNode p = start;
                while (p != end) {
                    if (p.next.val > cur.val) {
                        end.next = cur.next;
                        cur.next = p.next;
                        p.next = cur;
                        break;
                    } else {
                        p = p.next;
                    }
                }
            } else {
                end = cur;
            }
            cur = end.next;
        }

        return start.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = new ListNode(5);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        head.next = node1; node1.next = node2; node2.next = node3;
        System.out.println(ListNode.toString(s.insertionSortList(head)));
    }
}
