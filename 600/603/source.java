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
        int size = 0;

        for (size = 0; cursor != null; size++) {
            cursor = cursor.next;
        }

        if (size == 1) {
            return null;
        } else {
            if (size == n) {
                return head.next;
            } else {
                int target = size - n;
                ListNode previousNode = null;
                cursor = head;
                int currentPos = 0;

                for (currentPos = 0; currentPos < target; currentPos++) {
                    previousNode = cursor;
                    cursor = cursor.next;
                }

                previousNode.next = cursor.next;

                return head;
            }
        }
    }
}