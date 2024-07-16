/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private Map<Integer, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        Node nnode = new Node(node.val);
        map.put(node.val, nnode);
        Node neighbor;
        Node n;
        for (int i = 0; i < node.neighbors.size(); i++) {
            neighbor = node.neighbors.get(i);
            n = map.get(neighbor.val);
            if (n == null) {
                n = cloneGraph(neighbor);
            }
            nnode.neighbors.add(n);
        }

        return nnode;

    }
}