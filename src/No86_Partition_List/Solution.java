package No86_Partition_List;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * <p>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p>
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode less = head, greater = head;
        while (less != null && less.val >= x) less = less.next;
        while (greater != null && greater.val <x) greater = greater.next;
        if (less == null || greater == null) {
            return head;
        }
        ListNode p = head;
        ListNode temp = greater;
        head = less;
        while (p != null) {
            ListNode q = p.next;
            if (p.val < x) {
                less.next = p;
                less = less.next;
            } else {
                greater.next = p;
                greater = greater.next;
            }
            p = q;
        }
        greater.next = null;
        less.next = temp;
        return head;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(2);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        head = s.partition(head, 3);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
