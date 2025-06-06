class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int currsum = 0;
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            currsum += nums[i];
            if (map.containsKey(currsum - k)) {
                count += map.get(currsum - k);
            }
            map.put(currsum, map.getOrDefault(currsum, 0) + 1);
        }

        return count;
    }
}