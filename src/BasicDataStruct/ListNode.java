package BasicDataStruct;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
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
