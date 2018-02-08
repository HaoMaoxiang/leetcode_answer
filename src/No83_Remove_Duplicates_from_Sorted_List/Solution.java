package No83_Remove_Duplicates_from_Sorted_List;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p>
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        while (p.next != null) {
            if (p.next.val == p.val) {
                ListNode q = p.next;
                p.next = q.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }

}
