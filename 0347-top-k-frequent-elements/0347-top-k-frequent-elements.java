class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        int idx = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        List<Integer>[] freq = new List[nums.length+1];
        for (int i = 0; i <= nums.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> me : map.entrySet()) {
            freq[me.getValue()].add(me.getKey());
        }
        for (int i = nums.length; i >= 0 && idx < k; i--) {
            if (freq[i].size() > 0) {
                for (int j = 0; j < freq[i].size() && idx < k; j++) {
                    res[idx++] = freq[i].get(j);
                }
            }
        }

        return res;
    }
}