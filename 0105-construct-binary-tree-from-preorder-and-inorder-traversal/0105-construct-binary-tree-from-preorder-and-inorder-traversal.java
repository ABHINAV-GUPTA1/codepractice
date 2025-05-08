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
    int preIdx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = inorder.length; 
        for (int i = 0; i < len; i++) {
            map.put(inorder[i], i);
        }
        preIdx = 0;
        return build(inorder, preorder, 0, len - 1, map);
    }

    private TreeNode build (int[] in, int[] pre, int start, int end, Map<Integer, Integer> map) {
        if (start > end) {
            return  null;
        }
        
        TreeNode root = new TreeNode(pre[preIdx++]);
        int idx = map.get(root.val);
        
        root.left = build (in, pre, start, idx - 1, map);
        root.right = build (in, pre, idx + 1, end, map);

        return root;
    }
}