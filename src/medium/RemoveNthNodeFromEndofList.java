package medium;

public class RemoveNthNodeFromEndofList {

  /**
   * Given the head of a linked list, remove the nth node from the end of the list and return its head.
   * <p>
   * <p>
   * <p>
   * Example 1:
   * <p>
   * <p>
   * Input: head = [1,2,3,4,5], n = 2
   * Output: [1,2,3,5]
   * Example 2:
   * <p>
   * Input: head = [1], n = 1
   * Output: []
   * Example 3:
   * <p>
   * Input: head = [1,2], n = 1
   * Output: [1]
   * <p>
   * <p>
   * Constraints:
   * <p>
   * The number of nodes in the list is sz.
   * 1 <= sz <= 30
   * 0 <= Node.val <= 100
   * 1 <= n <= sz
   * <p>
   * <p>
   * Follow up: Could you do this in one pass?
   **/


  public static void main(String[] args) {

  }

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


  public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}
