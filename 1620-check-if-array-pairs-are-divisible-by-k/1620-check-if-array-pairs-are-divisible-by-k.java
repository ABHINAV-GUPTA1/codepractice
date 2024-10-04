class Solution {
    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            int val = i%k;
            if (val < 0) {
                val += k;
            }
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (key == 0) {
                if (map.get(key)%2 == 1) {
                    return false;
                }
            } else if (2*key == k) {
                if (map.get(key)%2 == 1) {
                    return false;
                }
            } else {
                int l1 = map.get(key);
                int l2 = map.getOrDefault(k-key, 0);
                if (l1 != l2) {
                    return false;
                }
            }
        }
        return true;
    }
}