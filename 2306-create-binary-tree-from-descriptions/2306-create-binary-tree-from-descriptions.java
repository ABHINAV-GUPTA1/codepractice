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
    Map<Integer, Integer> ans;
    public TreeNode createBinaryTree(int[][] descriptions) {
        TreeNode root;
        Set<Integer> childSet = new HashSet<>();
        Map<Integer, TreeNode> map = new HashMap<>();
        TreeNode k =  new TreeNode();
        for (int[] d : descriptions) {
            k = map.getOrDefault(d[0], new TreeNode(d[0]));
            if (d[2] == 0) {
                k.right = map.getOrDefault(d[1], new TreeNode(d[1]));
                map.put(d[1], k.right);
            } else {
                k.left = map.getOrDefault(d[1], new TreeNode(d[1]));
                map.put(d[1], k.left);
            }
            
            map.put(d[0], k);            
            childSet.add(d[1]);
        }   
        for (int d[] : descriptions) {
            if (!childSet.contains(d[0])) {
                k = map.get(d[0]);
                return k;
            }
        }
        
        return k;
    }

    int f(int key, Map<Integer, ArrayList<Integer>> m2) {
        if (!m2.containsKey(key)) {
            return 0;
        }
        int count = 0;
        if (ans.containsKey(key)) {
            return ans.get(key);
        }
        for (Integer k: m2.get(key)) {
            count += f(k, m2);
        }
        ans.put(key, m2.get(key).size() + count);
        return ans.get(key);
    }
    
}