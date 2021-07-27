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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }

        int count = 1;

        ListNode reversePrevNode = null;
        ListNode reverseStartNode = null;
        ListNode reverseEndNode = null;
        ListNode reverseNextNode = null;

        ListNode prev = null;
        ListNode cur = head;
        for (; count < left; count++) {
            prev = cur;
            cur = cur.next;
        }
        reversePrevNode = prev;
        reverseStartNode = cur;

        ListNode next = null;
        for (; count <= right; count++) {
            next = cur.next;
            cur.next = prev;

            prev = cur;
            cur = next;
        }
        reverseEndNode = prev;
        reverseNextNode = cur;

        reverseStartNode.next = reverseNextNode;

        if (reversePrevNode == null) {
            return reverseEndNode;
        } else {
            reversePrevNode.next = reverseEndNode;
            return head;
        }
    }
}
