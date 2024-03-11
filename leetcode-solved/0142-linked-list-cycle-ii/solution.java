/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null)
          return null;
        ListNode slow = head;
        ListNode fast = head;
        boolean isCycle = false;
      while (slow.next != null && fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if(slow == fast) {
          isCycle = true;
          break;
        }
      }
      if(isCycle) {
        ListNode start = head;
        while (true) {
          if (start == slow) 
            return start;
          start = start.next;
          slow = slow.next;
        }
      }
      return null;
    }
}
