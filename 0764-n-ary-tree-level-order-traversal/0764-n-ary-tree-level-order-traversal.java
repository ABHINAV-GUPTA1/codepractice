/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int sz = q.size();
            List<Integer> tmp = new ArrayList<>();
            while (sz-- > 0) {
                Node t = q.poll();
                tmp.add(t.val);
                for (Node child : t.children) {
                    if (child != null)
                        q.offer(child);
                }
            }
            res.add(tmp);
        }    

        return res;
    }
}