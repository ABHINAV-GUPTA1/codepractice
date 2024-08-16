class LRUCache {
    class Node {
        int value;
        int key;
        Node prev,next;
        Node(int key, int value) {
            this.value = value;
            this.key = key;
        } 
    }

    Node head, end;

    Map<Integer, Node> map;

    int size;

    public LRUCache(int capacity) {
        head = null;
        end = null;    
        map = new HashMap<>(capacity);
        size = capacity;
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
            System.out.println(end.key);
            Node removed = map.get(end.key);
            removeNode(removed);
            map.remove(removed.key);
        }
        Node node = new Node(key, value);
        map.put(key, node);
        moveToHead(node);
    
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */