class Node {
    int minVal;
    int val;
    Node next;
    Node(int val, int minVal, Node next) {
        this.val = val;
        this.minVal = minVal;
        this.next = next;
    }
}
class MinStack {
    Node head;
    public MinStack() {
        head = null;
    }
    
    public void push(int val) {
        head = new Node(val, head == null ? val : Math.min(val, head.minVal), head);
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.minVal;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */