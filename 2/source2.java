class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Input: Two singly linked list that represent two non-negative integers
        // Output: Singly linked list that represents a sum of the given integers

        // What is the maximum length of the given list? 1 <= n <= 100
        // Is the given list can contains a leading zero? No. Only if the given integer is 0

        // Digits is stored as reverse order. The first element is the smallest one.
        // And each node represents only one digit.

        // On each node, we can find a sum of two digits and also find a remain one need to sum with the next digit.
        // And, if one of the list is ended first, we can re-use remained of the other list.
        // There are no limits to use the given nodes, we can reuse the nodes in the given list.

        // To keep the root of the return linked list easier, we can use a temporal root that points a real root.

        ListNode tempHead = new ListNode();
        ListNode cursor = tempHead;

        int remain = 0;
        while ((l1 != null) && (l2 != null)) {
            l1.val += l2.val + remain;
            remain = l1.val / 10;
            l1.val = l1.val % 10;

            cursor.next = l1;
            cursor = cursor.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            l1.val += remain;
            remain = l1.val / 10;
            l1.val = l1.val % 10;

            cursor.next = l1;
            cursor = cursor.next;

            l1 = l1.next;
        }

        while (l2 != null) {
            l2.val += remain;
            remain = l2.val / 10;
            l2.val = l2.val % 10;

            cursor.next = l2;
            cursor = cursor.next;

            l2 = l2.next;
        }

        if (remain > 0) {
            cursor.next = new ListNode(remain, null);
        }

        return tempHead.next;
    }

//    public static class ListNode {
//        int val;
//        ListNode next;
//        ListNode() {}
//        ListNode(int val) { this.val = val; }
//        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//    }
}