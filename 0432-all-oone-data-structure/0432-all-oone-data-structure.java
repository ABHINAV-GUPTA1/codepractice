class Node {
    int freq;
    Node prev, next;
    Set<String> keys;
    Node(int freq) {
        this.freq = freq;
        keys = new HashSet<>();
    }
}
class AllOne {
    Node head, tail;
    Map<String, Node> map;
    public AllOne() {
        map = new HashMap<>();
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }
    
    public void inc(String key) {
        if (!map.containsKey(key)) {
            Node fnode = head.next;
            if (fnode == tail || fnode.freq > 1) {
                Node nnode = new Node(1);
                nnode.keys.add(key);
                nnode.next = fnode;
                nnode.prev = head;
                head.next = nnode;
                fnode.prev = nnode;
                map.put(key, nnode);
            } else {
                fnode.keys.add(key);
                map.put(key, fnode);
            }
        } else {
            Node node = map.get(key);
            int freq = node.freq;
            node.keys.remove(key);
            Node nnode = node.next;
            if (nnode == tail || nnode.freq != freq + 1) {
                Node newNode = new Node(freq+1);
                newNode.keys.add(key);
                newNode.next = nnode;
                newNode.prev = node;
                node.next = newNode;
                nnode.prev = newNode;
                map.put(key, newNode);
            } else {
                nnode.keys.add(key);
                map.put(key, nnode);
            }

            if (node.keys.isEmpty()) {
                removeNode(node);
            }
        }
    }
    
    public void dec(String key) {
        if (!map.containsKey(key)) {
            return;
        }
        Node node = map.get(key);
        node.keys.remove(key);
        int freq = node.freq;
        if (freq == 1) {
            map.remove(key);
        } else {
            Node prevNode = node.prev;
            if (prevNode == head || prevNode.freq != freq - 1) {
                Node nnode = new Node(freq-1);
                nnode.keys.add(key);
                nnode.next = node;
                nnode.prev = prevNode;
                node.prev = nnode;
                prevNode.next = nnode;
                map.put(key, nnode);
            } else {
                prevNode.keys.add(key);
                map.put(key, prevNode);
            }
        }
        if (node.keys.isEmpty()) {
            removeNode(node);
        }
    }

    private void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    
    public String getMaxKey() {
        if (tail.prev == head) {
            return "";
        }
        return tail.prev.keys.iterator().next();
    }
    
    public String getMinKey() {
        if (head.next == tail) {
            return "";
        }
        return head.next.keys.iterator().next();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */