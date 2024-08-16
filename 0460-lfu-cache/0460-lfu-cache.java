class LFUCache {
    int size;
    int min;
    
    Map<Integer, Integer> keyToValMap;
    Map<Integer, Integer> keyToCountMap;
    Map<Integer, LinkedHashSet<Integer>> countToKeysMap;
    
    public LFUCache(int capacity) {
        size = capacity;
        min = 0;
        keyToValMap = new HashMap<>();
        keyToCountMap = new HashMap<>();
        countToKeysMap = new HashMap<>();
    }
    
    public int get(int key) {
        if (!keyToValMap.containsKey(key)) {
            return -1;
        }
        int count = keyToCountMap.get(key);
        countToKeysMap.get(count).remove(key);
        if (count == min && countToKeysMap.get(count).size() == 0) {
            min++;
        }
        keyToCountMap.put(key, count+1);
        countToKeysMap.computeIfAbsent(count+1, x->new LinkedHashSet<>()).add(key);
        return keyToValMap.get(key);
    }
    
    public void put(int key, int value) {
        if (keyToValMap.containsKey(key)) {
            get(key);
            keyToValMap.put(key, value);
            return;
        }
        if (keyToValMap.size() >= size) {
            evictKey(countToKeysMap.get(min).iterator().next());
        }
        min = 1;
        keyToValMap.put(key, value);
        keyToCountMap.put(key, min);
        countToKeysMap.computeIfAbsent(min, x->new LinkedHashSet<>()).add(key);
    }

    private void evictKey(int key) {
        keyToValMap.remove(key);
        countToKeysMap.get(min).remove(key);
        keyToCountMap.remove(key);
    } 
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */