class RandomizedSet {

    Random rand;
    Map<Integer, Integer> map;
    List<Integer> list;

    public RandomizedSet() {
        rand = new Random();
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int idx1 = map.get(val);
        
        int val2 = list.get(list.size()-1);
        int idx2 = map.get(val2);
        
        map.put(val2, idx1);
        list.set(idx1, val2);

        list.remove(list.size()-1);
        map.remove(val);
        return true; 
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */