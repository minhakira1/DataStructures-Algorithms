/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode result = head;
        while(head.next != null){
            ListNode nextNodeOrigin = head.next;
            int a = head.val;
            int b = nextNodeOrigin.val;
            int valGCD = findGCD(a, b);
            ListNode newNode = new ListNode(valGCD);
            newNode.next = nextNodeOrigin;
            head.next = newNode;
            head = nextNodeOrigin;
        }
        return result;
    }

    public static int findGCD(int a, int b) {
        // Euclidean algorithm implementation
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}
