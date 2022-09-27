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
    public ListNode swapPairs(ListNode head) {
        // Node0.next -> Node1.next -> Node2.next -> Node3
        // Node0.next -> Node2.next -> Node1.next -> Node3

        // Node0(Pre).next -> Node2
        // Node1(Cur).next -> Node3
        // Node2(Post).next -> Node1

        // Node1(Pre).next -> Node3
        // Node3(Cur).next -> Node4
        // Node4(Post).next -> Node5

        ListNode newHead;

        if (head == null) {
            newHead = null;
        } else if (head.next == null) {
            newHead = head;
        } else {
            newHead = head.next;

            ListNode previousNode = null;
            ListNode firstNode = head;
            while (firstNode != null) {
                ListNode secondNode = firstNode.next;

                if (secondNode != null) {
                    if (previousNode != null) {
                        previousNode.next = secondNode;
                    }
                    firstNode.next = secondNode.next;
                    secondNode.next = firstNode;
                }

                previousNode = firstNode;
                firstNode = firstNode.next;
            }
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