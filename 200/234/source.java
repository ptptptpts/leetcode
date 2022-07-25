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
    public boolean isPalindrome(ListNode head) {
        boolean ret = true;

        ListNode prevCursor = null;
        ListNode halfCursor = head;
        int sizeOfList = 0;
        for (ListNode leadCursor = head; leadCursor != null; leadCursor = leadCursor.next) {
            sizeOfList++;
            if ((sizeOfList % 2) == 0) {
                ListNode pprevCursor = prevCursor;
                prevCursor = halfCursor;
                halfCursor = halfCursor.next;
                prevCursor.next = pprevCursor;
            }
        }

        if ((sizeOfList % 2) == 1) {
            halfCursor = halfCursor.next;
        }

        while (halfCursor != null) {
            if (halfCursor.val != prevCursor.val) {
                ret = false;
                break;
            }
            halfCursor = halfCursor.next;
            prevCursor = prevCursor.next;
        }

        return ret;
    }

//    public static class ListNode {
//        int val;
//        ListNode next;
//        ListNode() {}
//        ListNode(int val) { this.val = val; }
//        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//    }
}