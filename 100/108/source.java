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
        return buildBinaryTree(nums, 0, nums.length);
    }

    private TreeNode buildBinaryTree(int[] nums, int start, int end) {
        if (start == end) {
            return null;
        }

        TreeNode newRoot = new TreeNode();

        int middle = (start + end) / 2;
        newRoot.val = nums[middle];
        newRoot.left = buildBinaryTree(nums, start, middle);
        newRoot.right = buildBinaryTree(nums, middle + 1, end);

        return newRoot;
    }

//    public static class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//        TreeNode() {}
//        TreeNode(int val) { this.val = val; }
//        TreeNode(int val, TreeNode left, TreeNode right) {
//            this.val = val;
//            this.left = left;
//            this.right = right;
//        }
//    }
}