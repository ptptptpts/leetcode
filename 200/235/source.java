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
        Queue<TreeNode> routeP = new LinkedList<>();
        Queue<TreeNode> routeQ = new LinkedList<>();

        for (TreeNode node = root; node.val != p.val;) {
            routeP.add(node);
            if (node.val < p.val) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        routeP.add(p);

        for (TreeNode node = root; node.val != q.val;) {
            routeQ.add(node);
            if (node.val < q.val) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        routeQ.add(q);

        TreeNode commonAncestor = root;

        while (routeP.peek() == routeQ.peek()) {
            commonAncestor = routeP.peek();
            routeP.poll();
            routeQ.poll();
        }

        return commonAncestor;
    }

//    public static class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//        TreeNode(int x) { val = x; }
//    }
}
