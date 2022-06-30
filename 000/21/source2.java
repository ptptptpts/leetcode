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
        // Need to merge two sorted lists to one sorted list

        // Input: two heads of two sorted linked lists list1 and list2
        // Output: is the head of a sorted linked list

        // The output list should be made by the nodes in the given two lists.

        // Because they are sorted, we don't need to care about the next and previous nodes when we compare them.
        // We can use two cursors for the list1 and list2 and compare the current integer from each others.

        // What is the size of the list1 and list2? 0 <= n <= 50
        // What is the range of integers in the list1 and list2? -100 <= n <= 100
        // How is the list1 and list2 ordered? non-decreasing order. So, they can have a duplicated value

        // First, we need to care about the head of new list. But we can use a temporal head node that points a real head on its next.
        // Second, if two cursors points a valid node, we can compare them and connect a smaller one to the current node. And move the smaller one to the next.
        // Third, if one of cursors points a null node, we can connect the other node because all of the nodes in the other list is larger then the list with a null node.
        // Fourth, if two cursors point a null node, we finish to merge two lists.

        ListNode tempHead = new ListNode();
        ListNode cursor = tempHead;

        while ((list1 != null) || (list2 != null)) {
            if (list1 == null) {
                cursor.next = list2;
                list2 = list2.next;
            } else if (list2 == null) {
                cursor.next = list1;
                list1 = list1.next;
            } else {
                if (list1.val < list2.val) {
                    cursor.next = list1;
                    list1 = list1.next;
                } else {
                    cursor.next = list2;
                    list2 = list2.next;
                }
            }
            cursor = cursor.next;
        }

        return tempHead.next;
    }
}
