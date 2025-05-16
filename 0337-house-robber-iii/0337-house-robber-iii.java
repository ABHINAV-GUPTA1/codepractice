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
        int[] sum = findSum(root);
        return Math.max(sum[0], sum[1]);
    }

    private int[] findSum(TreeNode root) {
        if (root == null) {
            return new int[2];
        }

        int[] left = findSum(root.left);
        int[] right = findSum(root.right);

        int withRoot = root.val + left[1] + right[1];
        int withoutRoot = Math.max(left[1], left[0]) + Math.max(right[0], right[1]);

        return new int[]{withRoot, withoutRoot};
    }
}