import java.util.HashSet;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> history = new HashSet<>();

        ListNode cursor = head;
        while (cursor != null) {
            cursor = cursor.next;
            if (history.contains(cursor)) {
                return true;
            } else {
                history.add(cursor);
            }
        }

        return false;
    }
}
