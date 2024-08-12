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
    
    public List<Integer> inorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> st = new Stack<>();
        while (root != null) {
            st.add(root);
            root = root.left;
        }
        while (!st.isEmpty()) {
            root = st.pop();
            res.add(root.val);
            if (root.right != null) {
                root = root.right;
                while (root != null) {
                    st.add(root);
                    root = root.left;
                }
            }
        }
        return res;
    }
    
    public List<Integer> inorderTraversal1(TreeNode root) {
        res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        inorder(root);
        return res;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        res.add(root.val);
        inorder(root.right);
    }
}