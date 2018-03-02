package No82_Remove_Duplicates_from_Sorted_List_II;

import BasicDataStruct.ListNode;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * <p>
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode pre = newHead;
        ListNode cur = head;
        ListNode nex = head.next;
        boolean isDup = false;
        while(nex != null) {
            if (!isDup) {
                if (cur.val != nex.val) {
                    pre = cur; cur = nex; nex = nex.next;
                } else {
                    isDup = true;
                    nex = nex.next;
                }
            } else {
                if (cur.val != nex.val) {
                    isDup = false;
                    pre.next = nex; cur = nex; nex = nex.next;
                } else {
                    nex = nex.next;
                }
            }
        }
        if (isDup) {
            pre.next = null;
        }

        return newHead.next;
    }
}
