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
    int maxSum;
    public int maxSumBST(TreeNode root) {
        maxSum = 0;
        dfs(root);
        return maxSum < 0 ? 0 : maxSum;
    }
    // arr[] ->{min, max, sum}
    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        
        if (!(left != null && right != null && root.val > left[1] && root.val < right[0])) {
            return null;
        }

        int sum = root.val + left[2] + right[2];
        maxSum = Math.max(maxSum, sum);

        return new int[] {Math.min(root.val, left[0]), Math.max(root.val, right[1]), sum};

    }
}