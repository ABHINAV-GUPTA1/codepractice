/*Complete the finction below
Node is as follows
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}*/
class Solution {
    public int maxLevelSum(Node root) {
        int ans = Integer.MIN_VALUE;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int sz = q.size();
            int levelsum = 0;
            while (sz-- > 0) {
                Node t = q.poll();
                levelsum += t.data;
                if (t.left != null) {
                    q.offer(t.left);
                }
                if (t.right != null) {
                    q.offer(t.right);
                }
            }
            if (levelsum > ans) {
                ans = levelsum;
            }
        }
        
        return ans;
    }
}