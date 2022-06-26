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
        ListNode leadCursor = head;
        ListNode realCursor = head;

        for (int i = 0; i < n; i++) {
            leadCursor = leadCursor.next;
            if (leadCursor == null) {
                break;
            }
        }

        if (leadCursor == null) {
            return head.next;
        } else {
            while (leadCursor.next != null) {
                leadCursor = leadCursor.next;
                realCursor = realCursor.next;
            }
            realCursor.next = realCursor.next.next;

            return head;
        }
    }
}
