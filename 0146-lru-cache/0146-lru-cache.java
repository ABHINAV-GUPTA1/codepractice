class LRUCache {
    
    int size;
    Node head, end;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.size = capacity;
        this.head = null;
        this.end = null;
        this.map = new HashMap<>();
    }
    
    private void moveToHead(Node node) {
        node.prev = null;
        node.next = head;
        if (head != null) {
            head.prev = node;
        } 

        head = node;

        if (end == null) {
            end = node;
        }

    }

    private void removeNode(Node node) {
        if (node.prev == null) {
            head = node.next;
        } else {
            node.prev.next = node.next;
        }

        if (node.next == null) {
            end = node.prev;
        } else {
            node.next.prev = node.prev;
        }
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        removeNode(node);
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            get(key);
            Node node = map.get(key);
            node.value = value;
            return;
        }
        if (map.size() >= size) {
            Node endNode = map.get(end.key);
            removeNode(endNode);
            map.remove(endNode.key);
        }
        Node node = new Node(key, value);
        map.put(key, node);
        moveToHead(node);
    }
}


class Node {
    int key, value;
    Node prev, next;
    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */