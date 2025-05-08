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
    /**
        Method 2 using BST property
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        if ((root.val > p.val && root.val < q.val) || (root.val < p.val && root.val > q.val)) {
            return root;
        }
        if ((root.val > p.val && root.val > q.val)) {
            return lowestCommonAncestor(root.left, p, q);
        } else if ((root.val < p.val && root.val < q.val)) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
    /**
        Method 1 : can be used for binary tree
        i.e. doesnot required tree to be a BST
     */
    public TreeNode lowestCommonAncestor_method1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }
}