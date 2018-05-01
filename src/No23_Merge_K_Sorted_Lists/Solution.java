package No23_Merge_K_Sorted_Lists;

import BasicDataStruct.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            cur.next = node;
            cur = cur.next;
            if (node.next != null) {
                queue.offer(node.next);
            }
        }
        return head;
    }

}
