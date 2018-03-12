package No148_Sort_List;

import BasicDataStruct.ListNode;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class Solution {
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode middle = findMiddle(head);
        ListNode right = sortList(middle.next);
        middle.next = null;
        ListNode left = sortList(head);
        return mergeList(left, right);

    }

    /**
     * 利用快慢指针的思想，找链表中间节点
     */
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 合并两个有序链表
     */
    private ListNode mergeList(ListNode firstHead, ListNode secondHead) {
        ListNode head = new ListNode(-1);
        ListNode node = head;
        while (firstHead != null && secondHead != null) {
            if (firstHead.val < secondHead.val) {
                node.next = firstHead;
                firstHead = firstHead.next;
            } else {
                node.next = secondHead;
                secondHead = secondHead.next;
            }
            node = node.next;
        }
        if (firstHead != null) {
            node.next = firstHead;
        }
        if (secondHead != null) {
            node.next = secondHead;
        }

        return head.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = ListNode.create(new int[]{2,1,3});
        System.out.println(ListNode.toString(s.sortList(head)));
    }
}
