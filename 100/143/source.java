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
    public void reorderList(ListNode head) {
        int sizeOfList = 0;
        ListNode halfCursor = head;
        ListNode prevNode = null;
        for (ListNode leadCursor = head; leadCursor != null; leadCursor = leadCursor.next) {
            sizeOfList++;
            if ((sizeOfList & 1) == 0) {
                prevNode = halfCursor;
                halfCursor = halfCursor.next;
            }
        }
        if ((sizeOfList & 1) == 1) {
            prevNode = halfCursor;
            halfCursor = halfCursor.next;
        }
        prevNode.next = null;

        if (halfCursor != null) {
            ListNode nextCursor = halfCursor.next;
            ListNode prevCursor = null;
            while (halfCursor.next != null) {
                halfCursor.next = prevCursor;
                prevCursor = halfCursor;

                halfCursor = nextCursor;
                nextCursor = halfCursor.next;
            }
            halfCursor.next = prevCursor;

            ListNode leftCursor = head;
            ListNode rightCursor = halfCursor;
            while (leftCursor != null) {
                ListNode leftTempNode = leftCursor.next;
                leftCursor.next = rightCursor;
                leftCursor = leftTempNode;

                if (rightCursor != null) {
                    ListNode rightTempNode = rightCursor.next;
                    rightCursor.next = leftTempNode;
                    rightCursor = rightTempNode;
                }
            }
        }
    }

//    public class ListNode {
//        int val;
//        ListNode next;
//        ListNode() {}
//        ListNode(int val) { this.val = val; }
//        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//    }
}