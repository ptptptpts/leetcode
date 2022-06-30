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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultHead = new ListNode();

        ListNode l1Cursor = l1;
        ListNode l2Cursor = l2;
        ListNode resultCursor = resultHead;

        int roundUp = 0;
        while ((l1Cursor != null) || (l2Cursor != null)) {
            int currentSum = roundUp;
            if (l1Cursor != null) {
                currentSum += l1Cursor.val;
                l1Cursor = l1Cursor.next;
            }
            if (l2Cursor != null) {
                currentSum += l2Cursor.val;
                l2Cursor = l2Cursor.next;
            }
            resultCursor.next = new ListNode(currentSum % 10);
            resultCursor = resultCursor.next;
            roundUp = currentSum / 10;
        }
        if (roundUp == 1) {
            resultCursor.next = new ListNode(1);
        }

        return resultHead.next;
    }
}