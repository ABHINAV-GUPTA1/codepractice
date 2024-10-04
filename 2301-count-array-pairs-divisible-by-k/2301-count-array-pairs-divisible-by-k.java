class Solution {
    public long countPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int gcd = gcd(nums[i], k);
            int req = k / gcd;
            for (int key : map.keySet()) {
                if (key%req == 0) {
                    ans += map.get(key);
                }
            }
            map.put(gcd, map.getOrDefault(gcd, 0)+1);
        }

        return ans;

    }

    private int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b%a, a);
    }
}