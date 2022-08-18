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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        int subLevel = findLevel(subRoot);
        return traverse(root, subRoot, subLevel)[1] == 1;
    }

    private int findLevel(TreeNode subRoot) {
        if (subRoot == null) {
            return 0;
        }
        return Math.max(findLevel(subRoot.left), findLevel(subRoot.right)) + 1;
    }

    private int[] traverse(TreeNode first, TreeNode subRoot, int subLevel) {
        if (first == null) {
            return new int[] {0, 0};
        }

        int[] left = traverse(first.left, subRoot, subLevel);
        if (left[1] == 1) {
            return new int[] {0, 1};
        }
        int[] right = traverse(first.right, subRoot, subLevel);
        if (right[1] == 1) {
            return new int[] {0, 1};
        }

        int[] current = new int[] {Math.max(left[0], right[0]) + 1, 0};
        if ((first.val == subRoot.val) && (current[0] == subLevel)) {
            if (compare(first, subRoot)) {
                current[1] = 1;
            }
        }
        return current;
    }

    private boolean compare(TreeNode first, TreeNode second) {
        if ((first == null) && (second == null)) {
            return true;
        }
        if ((first == null) || (second == null)) {
            return false;
        }
        if (first.val != second.val) {
            return false;
        }
        return compare(first.left, second.left) && compare(first.right, second.right);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
