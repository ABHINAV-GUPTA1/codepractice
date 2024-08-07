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
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);    
    }

    boolean isValid(TreeNode root, double min, double max) {
        if (root == null) {
            return true;
        }

        if (root.val <= min || root.val >= max) {
            return false;
        }

        boolean left = isValid(root.left, min, root.val);
        boolean right = isValid(root.right, root.val, max);

        return left && right;
    }
}