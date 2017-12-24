package No2_Add_Two_Numbers;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode pre = null;
        int sign = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + sign;
            if (sum >= 10) {
                sign = 1;
                sum -= 10;
            } else
                sign = 0;
            ListNode p = new ListNode(sum);
            if (result == null) {
                result = pre = p;
            }
            else {
                pre.next = p;
                pre = p;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + sign;
            if (sum >= 10) {
                sign = 1;
                sum -= 10;
            } else
                sign = 0;
            ListNode p = new ListNode(sum);
            pre.next = p;
            pre = p;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + sign;
            if (sum >= 10) {
                sign = 1;
                sum -= 10;
            } else
                sign = 0;
            ListNode p = new ListNode(sum);
            pre.next = p;
            pre = p;
            l2 = l2.next;
        }
        if (sign == 1) {
            result.next = new ListNode(1);
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
//        ListNode a2 = new ListNode(8);
//        ListNode a3 = new ListNode(3);
//        a1.next = a2;
//        a2.next = a3;
        ListNode b1 = new ListNode(9);
        ListNode b2 = new ListNode(9);
//        ListNode b3 = new ListNode(4);
        b1.next = b2;
//        b2.next = b3;

        Solution s = new Solution();
        ListNode r = s.addTwoNumbers(a1, b1);
        while (r != null) {
            System.out.printf(String.valueOf(r.val));
            r = r.next;
        }
    }
}
