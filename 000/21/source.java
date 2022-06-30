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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode list1Cursor = list1;
        ListNode list2Cursor = list2;
        ListNode mergedCursor = head;

        while ((list1Cursor != null) || (list2Cursor != null)) {
            int list1Value = 101;
            int list2Value = 101;
            if (list1Cursor != null) {
                list1Value = list1Cursor.val;
            }
            if (list2Cursor != null) {
                list2Value = list2Cursor.val;
            }

            if (list1Value < list2Value) {
                mergedCursor.next = list1Cursor;
                list1Cursor = list1Cursor.next;
            } else {
                mergedCursor.next = list2Cursor;
                list2Cursor = list2Cursor.next;
            }
            mergedCursor = mergedCursor.next;
        }

        return head.next;
    }
}