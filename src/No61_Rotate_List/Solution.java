package No61_Rotate_List;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * <p>
 * <p>
 * Example:
 * <p>
 * Given 1->2->3->4->5->NULL and k = 2,
 * <p>
 * return 4->5->1->2->3->NULL.
 */
public class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode end = head, flag = head;
        int len = 0;
        while(end!= null) {
            len += 1;
            end = end.next;
        }
        k = k % len;
        end = head;
        for (int i = 0; i < k; i++) {
            end = end.next;
        }
        while (end.next != null) {
            end = end.next;
            flag = flag.next;
        }

        end.next = head;
        head = flag.next;
        flag.next = null;
        return head;
    }
}
