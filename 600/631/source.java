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
    public TreeNode sortedArrayToBST(int[] nums) {
        return getRootNode(nums, 0, nums.length);
    }

    private TreeNode getRootNode(int[] nums, int start, int end) {
        if (start >= end) {
            return null;

        } else {
            int middle = (start + end) / 2;
            TreeNode node = new TreeNode(nums[middle]);

            node.left = getRootNode(nums, start, middle);
            node.right = getRootNode(nums, middle + 1, end);

            return node;
        }
    }
}