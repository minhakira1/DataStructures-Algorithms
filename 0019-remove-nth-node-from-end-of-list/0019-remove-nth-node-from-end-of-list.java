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
            preSlow = slow;
            fast = fast.next;
            slow = slow.next;
        }
        if (preSlow != null) {
            preSlow.next = slow.next;
        } else {
            head = head.next;
        }
        return head;
    }
}