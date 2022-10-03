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
    public int rob(TreeNode root) {
        // maximum money = Math.max(money[left.rob] + money[right.rob],
        //                  node.val + money[left.notrob] + money[right.notrob],
        //                  money[left.rob] + money[right.notrob],
        //                  money[left.notrob] + money[right.rob])
        int[] maximumProfit = findMaximumProfit(root);
        return Math.max(maximumProfit[0], maximumProfit[1]);
    }

    private int[] findMaximumProfit(TreeNode node) {
        int[] profit = new int[]{ 0, 0 };

        if (node != null) {
            // money[current.rob] = node.val + money[left.notrob] + money[right.notrob]
            // money[current.notrob] = Math.max(money[left.rob], money[left.notrob]) +
            //                     Math.max(money[right.rob], money[right.notrob])
            int[] leftProfit = findMaximumProfit(node.left);
            int[] rightProfit = findMaximumProfit(node.right);

            profit[0] = node.val + leftProfit[1] + rightProfit[1];
            profit[1] = Math.max(leftProfit[0], leftProfit[1])
                    + Math.max(rightProfit[0], rightProfit[1]);
        }

        return profit;
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
