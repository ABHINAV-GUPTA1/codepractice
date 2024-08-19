/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        return flat(head, null);
    }

    Node flat(Node root, Node next) {
        if (root == null) {
            return next;
        }
        root.next = flat(root.child, flat(root.next, next));
        if (root.next != null) {
            root.next.prev = root;
        }
        root.child = null;
        return root;
    }
}