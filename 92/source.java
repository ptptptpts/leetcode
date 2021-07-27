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
        int count = 1;

        ListNode node = head;
        for (; count < left; count++) {
            node = node.next;
        }

        ListNode[] reverseNodes = new ListNode[right - left + 1];
        for (; count <= right; count++) {
            reverseNodes[count - left] = node;
            node = node.next;
        }
        for (int i = 0; i < reverseNodes.length / 2; i++) {
            int tmp = reverseNodes[i].val;
            reverseNodes[i].val = reverseNodes[right - left - i].val;
            reverseNodes[right - left - i].val = tmp;
        }

        return head;
    }
}
