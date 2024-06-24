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
        if (root == null) {
            return root;
        }
        Node node = root;
        Node dummy;
        Node tmp;
        Node tdummy;

        while (node != null) {
            tmp = node;
            dummy = new Node(-1);
            tdummy = dummy;
            while (tmp != null) {
                if (tmp.left != null) {
                    dummy.next = tmp.left;
                    dummy = dummy.next;
                }
                if (tmp.right != null) {
                    dummy.next = tmp.right;
                    dummy = dummy.next;
                }
                tmp = tmp.next;
            }
            node = tdummy.next;
        }

        return root;
    }
}