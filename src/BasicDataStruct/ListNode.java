package BasicDataStruct;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode create(int[] nums) {
        ListNode head = new ListNode(-1);
        ListNode node = head;
        for (int num : nums) {
            node.next = new ListNode(num);
            node = node.next;
        }
        return head.next;
    }

    public static String toString(ListNode head) {
        StringBuilder builder = new StringBuilder();
        while (head != null) {
            builder.append(head.val + " ");
            head = head.next;
        }

        return builder.toString();
    }
}
