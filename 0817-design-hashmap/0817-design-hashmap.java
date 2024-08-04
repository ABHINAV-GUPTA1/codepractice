class MyHashMap {
    class Entry<K,V> {
        K key;
        V val;
        Entry(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }
    
    int SIZE = 1200;
    LinkedList<Entry<Integer, Integer>>[] bucket;

    public MyHashMap() {
        bucket = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            bucket[i] = new LinkedList<>();
        }
    }
    
    public void put(int key, int value) {
        int hash = hashCode(key);
        remove(key);
        LinkedList<Entry<Integer, Integer>> b = bucket[hash];
        b.add(new Entry<Integer, Integer>(key, value));
    }
    
    public int get(int key) {
        Iterator<Entry<Integer, Integer>> iter = getIterator(key);
        while (iter.hasNext()) {
            Entry<Integer, Integer> entry = iter.next();
            if (entry.key == key) {
                return entry.val;
            }
        }

        return -1;
    }

    private int hashCode(int key) {
        return key%SIZE;
    }
    
    public void remove(int key) {
        Iterator<Entry<Integer, Integer>> iter = getIterator(key);
        while (iter.hasNext()) {
            Entry<Integer, Integer> entry = iter.next();
            if (entry.key == key) {
                iter.remove();
            }
        }
    }

    private Iterator<Entry<Integer, Integer>> getIterator(int key) {
        int hash = hashCode(key);
        LinkedList<Entry<Integer, Integer>> b = bucket[hash];
        return b.iterator();
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */