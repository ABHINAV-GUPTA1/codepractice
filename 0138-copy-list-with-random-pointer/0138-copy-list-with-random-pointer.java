/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        Node tmpHead = head;
        // create the copy node and put it in between original node i.e. after
        // 1->2->3->null    =>  1->1`->2->2`->3->3`->null
        while (tmpHead != null) {
            Node copyNode = new Node(tmpHead.val);
            Node next = tmpHead.next;

            tmpHead.next = copyNode;
            copyNode.next = next;
            tmpHead = next; 
        }

        // create random links for copynode
        tmpHead = head;
        while (tmpHead != null) {
            Node randomPtr = tmpHead.random;
            Node copyNode = tmpHead.next;
            
            copyNode.random = randomPtr == null ? null : randomPtr.next;

            tmpHead = tmpHead.next.next;
        }

        // create next links for copynode and add it in res
        Node res = new Node(-1);
        Node ans = res;
        tmpHead = head;
        while (tmpHead != null) {
            Node copyNode = tmpHead.next;
            
            ans.next = copyNode;
            ans = ans.next;

            tmpHead.next = copyNode.next;
            tmpHead = tmpHead.next;
        }
        
        return res.next;
    }
}