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
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode prev = findRight(curr.left, curr);
                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    prev.right = null;
                    res.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return res;
    }

    private TreeNode findRight(TreeNode curr, TreeNode root) {
        while (curr.right != null && curr.right != root) {
            curr = curr.right;
        }
        return curr;
    } 

    public List<Integer> inorderTraversal2(TreeNode root) {
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