class TimeMap {
    Map<String, List<Pair<String, Integer>>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, x->new ArrayList<>()).add(new Pair(value, timestamp));
    }
    private static String EMPTY = "";
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return EMPTY;
        }
        List<Pair<String, Integer>> list = map.get(key);
        int low = 0, high = list.size()-1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high-low)/2;
            int val = list.get(mid).getValue();
            if (val > timestamp) {
                high = mid - 1;
            } else {
                ans = mid;
                low = mid + 1;
            }
        }
        return ans == -1 ? EMPTY : list.get(ans).getKey();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */