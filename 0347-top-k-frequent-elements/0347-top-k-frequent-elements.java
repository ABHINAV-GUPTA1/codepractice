class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        List<Integer> tlist[] = new List[n+1];
        for (Map.Entry<Integer, Integer> me : map.entrySet()) {
            if (tlist[me.getValue()] == null) {
                tlist[me.getValue()] = new ArrayList<>();
            }
            tlist[me.getValue()].add(me.getKey());
        }
        int[] res = new int[k];
        int idx = 0;
        for (int i = n; i >= 0 && k > 0; i--) {
            if (tlist[i] == null) {
                continue;
            }
            for (int val : tlist[i]) {
                res[idx++] = val;
                k--;
                if (k == 0) {
                    return res;
                }
            }
        }
        return res;
    }
}