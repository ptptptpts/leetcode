/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        return findKthSmallestNode(root, k, new int[]{0});
    }

    private int findKthSmallestNode(TreeNode node, int k, int[] numberOfNodesCounter) {
        int kthSmallestValue = -1;

        if (numberOfNodesCounter[0] < k) {
            if (node != null) {
                kthSmallestValue = findKthSmallestNode(node.left, k, numberOfNodesCounter);

                if (kthSmallestValue < 0) {
                    numberOfNodesCounter[0]++;
                    if (numberOfNodesCounter[0] == k) {
                        kthSmallestValue = node.val;
                    } else {
                        kthSmallestValue = findKthSmallestNode(node.right, k, numberOfNodesCounter);
                    }
                }
            }
        }

        return kthSmallestValue;
    }
}
