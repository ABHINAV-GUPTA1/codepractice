class Node {
    int val;
    Node prev;
    Node next;
    Node(int val, Node prev, Node next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}
class MyCircularDeque {

    Node head, end;
    int capacity;
    int size;

    public MyCircularDeque(int k) {
        capacity = k;
        size = 0;
    }
    
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }

        if (head == null) {
            head = new Node(value, null, null);
            end = head;
        } else {
            Node newHead = new Node(value, null, head);
            head.prev = newHead;
            head = newHead;
        }
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        if (head == null) {
            head = new Node(value, null, null);
            end = head;
        } else {
            Node newTail = new Node(value, end, null);
            end.next = newTail;
            end = newTail;
        }
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        if (size == 1) {
            head = null;
            end = null;
        } else {
            head = head.next;
        }
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        if (size == 1) {
            head = null;
            end = null;
        } else {
            end = end.prev;
        }
        size--;
        return true;
    }
    
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return head.val;
    }
    
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return end.val;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */