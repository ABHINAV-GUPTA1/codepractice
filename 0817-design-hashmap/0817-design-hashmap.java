class MyHashMap {
    class Entry {
        int key, val;
        Entry(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    int SIZE = 1200;
    LinkedList<Entry>[] bucket;

    public MyHashMap() {
        bucket = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            bucket[i] = new LinkedList<>();
        }
    }
    
    public void put(int key, int value) {
        int hash = hashCode(key);
        remove(key);
        LinkedList<Entry> b = bucket[hash];
        b.add(new Entry(key, value));
    }
    
    public int get(int key) {
        Iterator<Entry> iter = getIterator(key);
        while (iter.hasNext()) {
            Entry entry = iter.next();
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
        Iterator<Entry> iter = getIterator(key);
        while (iter.hasNext()) {
            Entry entry = iter.next();
            if (entry.key == key) {
                iter.remove();
            }
        }
    }

    private Iterator<Entry> getIterator(int key) {
        int hash = hashCode(key);
        LinkedList<Entry> b = bucket[hash];
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