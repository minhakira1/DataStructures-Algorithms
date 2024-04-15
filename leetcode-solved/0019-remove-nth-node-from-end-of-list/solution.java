/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) 
            head = null;
        ListNode slow = head;
        ListNode preSlow = null;
        ListNode fast = head;
        int countStep = 0;
        while (countStep < n) {
            if (fast == null)
                return null;
            fast = fast.next;
            ++countStep;
        }
        // from start (slow at start, fast at kth) step by step slow and fast
        // to the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
            if (preSlow == null) {
                preSlow = head;
            } else {
                preSlow = preSlow.next;
            }
        }
        if (preSlow != null) {
            preSlow.next = slow.next;
            slow.next = null;
        } else {
            head = head.next;
            slow.next = null;
            slow = null;
        }
        return head;
    }
}
