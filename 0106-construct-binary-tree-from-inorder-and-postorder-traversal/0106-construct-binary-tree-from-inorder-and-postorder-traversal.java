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
    int postIdx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIdx = inorder.length - 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(inorder, postorder, 0, postIdx, map);
    }

    private TreeNode build(int[] in, int[] post, int start, int end, Map<Integer, Integer> map) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(post[postIdx--]);
        int idx = map.get(root.val);

        root.right = build(in, post, idx + 1, end, map);
        root.left = build(in, post, start, idx - 1, map);

        return root;
    }
}