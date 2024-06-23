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
        /**
            Method 1
         */
        // connect(root.left, root.right);
        // return root;

        /**
            Method 2
         */
         
        Node node = root;
         while (node != null) {
            Node dummy = new Node(-1);
            Node tmp = node;
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
            node = tmp.left;
         }

        return root;
    }

    private void connect(Node a, Node b) {
        if (a == null || b == null) {
            return;
        }
        if (a != null) {
            a.next = b;
        }
        connect(a.left, a.right);
        connect(b.left, b.right);
        connect(a.right, b.left);
    }

}