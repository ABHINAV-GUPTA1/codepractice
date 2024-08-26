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
    List<Integer> res;
    public List<Integer> postorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // method 1 traversal in recursion
        // dfs(root);

        // method 2 morris traversal
        morrisTraversal(root);
        return res;
    }

    private void morrisTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode curr = root;

        while (curr != null) {
            if (curr.right == null) {
                res.add(curr.val);
                curr = curr.left;
            } else {
                TreeNode prev = getRight(curr.right, curr);
                if (prev.left == null) {
                    res.add(curr.val);
                    prev.left = curr;
                    curr = curr.right;
                } else {
                    prev.left = null;
                    curr = curr.left;
                }
            }
        }
        reverse();
    }

    private void reverse() {
        int left = 0;
        int right = res.size()-1;
        while (left < right) {
            int t = res.get(left);
            res.set(left, res.get(right));
            res.set(right, t);
            left++;
            right--;
        }
    }


    private TreeNode getRight(TreeNode curr, TreeNode root) {
        while (curr.left != null && curr.left != root) {
            curr = curr.left;
        }
        return curr;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
        res.add(root.val);
    }
}