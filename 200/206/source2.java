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
    public ListNode reverseList(ListNode head) {
        ListNode previousNode = null;
        ListNode currentNode = head;

        return reverse(previousNode, currentNode);
    }

    private ListNode reverse(ListNode previousNode, ListNode currentNode) {
        if (currentNode == null) {
            return previousNode;
        }

        ListNode nextNode = currentNode.next;
        currentNode.next = previousNode;
        return reverse(currentNode, nextNode);
    }

//    public static class ListNode {
//        int val;
//        ListNode next;
//        ListNode() {}
//        ListNode(int val) { this.val = val; }
//        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//    }
}
