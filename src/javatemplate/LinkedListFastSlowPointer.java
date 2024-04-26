package javatemplate;

import medium.RemoveNthNodeFromEndofList;

public class LinkedListFastSlowPointer {
  public int fastSlowPointer(RemoveNthNodeFromEndofList.ListNode head) {
    RemoveNthNodeFromEndofList.ListNode slow = head;
    RemoveNthNodeFromEndofList.ListNode fast = head;
    int ans = 0;

    while (fast != null && fast.next != null) {
      // do logic
      slow = slow.next;
      fast = fast.next.next;
    }

    return ans;
  }
}
