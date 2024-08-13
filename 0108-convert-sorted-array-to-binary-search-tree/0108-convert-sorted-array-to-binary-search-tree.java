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
    public TreeNode sortedArrayToBST(int[] nums) {
        
        return convert(0, nums.length-1, nums);
    }
    TreeNode convert(int low, int high, int[] arr) {
        if (low > high) {
            return null;
        }
        int mid = low + (high - low) / 2;
        TreeNode t = new TreeNode(arr[mid]);
        t.left = convert(low, mid-1, arr);
        t.right = convert(mid+1, high, arr);

        return t;
    }
}