/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Node node = root;
        Node tmp;

        while (node != null) {
            Node dummy = new Node(-1);
            Node tDummy = dummy;
            while (node != null) {
                if (node.left != null) {
                    dummy.next = node.left;
                    dummy = dummy.next;
                }
                if (node.right != null) {
                    dummy.next = node.right;
                    dummy = dummy.next;
                }
                node = node.next;
            }
            node = tDummy.next;
        }
        return root;
    }
}