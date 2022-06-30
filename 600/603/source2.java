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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cursor = head;
        int currentPos = 0;

        for (currentPos = 0; currentPos < n; currentPos++) {
            cursor = cursor.next;
        }

        ListNode previousDeleteNode = head;

        if (cursor == null) {
            return head.next;
        } else {
            while (cursor.next != null) {
                cursor = cursor.next;
                previousDeleteNode = previousDeleteNode.next;
            }
            previousDeleteNode.next = previousDeleteNode.next.next;

            return head;
        }
    }
}