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
    public ListNode rotateRight(ListNode head, int k) {
        if ((head == null) || (head.next == null)) {
            return head;
        }

        int length = 0;
        ListNode prevTail = null;
        for (ListNode node = head; node != null; node = node.next) {
            prevTail = node;
            length++;
        }

        k = k % length;

        ListNode newHead = head;
        if (k > 0) {
            ListNode newTail = prevTail;
            for (int newHeadPosition = length - k; newHeadPosition > 0; newHeadPosition--) {
                newTail = newHead;
                newHead = newHead.next;
            }
            newTail.next = null;
            prevTail.next = head;
        }

        return newHead;
    }

//    public static class ListNode {
//        int val;
//        ListNode next;
//        ListNode() {}
//        ListNode(int val) { this.val = val; }
//        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//    }
}