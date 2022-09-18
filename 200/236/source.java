import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> historyP = new LinkedList<>();
        Queue<TreeNode> historyQ = new LinkedList<>();
        findTreeNode(root, p.val, historyP);
        findTreeNode(root, q.val, historyQ);

        while (historyP.size() > historyQ.size()) {
            historyP.poll();
        }
        while (historyQ.size() > historyP.size()) {
            historyQ.poll();
        }

        while (historyP.peek().val != historyQ.peek().val) {
            historyP.poll();
            historyQ.poll();
        }

        return historyP.peek();
    }

    private boolean findTreeNode(TreeNode node, int val, Queue<TreeNode> history) {
        boolean find = false;

        if (node != null) {
            if (node.val == val) {
                find = true;
            } else if (findTreeNode(node.left, val, history)) {
                find = true;
            } else if (findTreeNode(node.right, val, history)) {
                find = true;
            }
        }

        if (find) {
            history.add(node);
        }

        return find;
    }

//    public class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//        TreeNode(int x) { val = x; }
//    }
}
