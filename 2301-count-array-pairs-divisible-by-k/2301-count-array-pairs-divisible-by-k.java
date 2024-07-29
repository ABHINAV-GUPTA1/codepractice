class Solution {
    public long countPairs(int[] nums, int k) {
        long ans = 0;
        long common, want;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            common = gcd (nums[i], k);
            want = k / common;
            for (Map.Entry<Long, Long> me : map.entrySet()) {
                if (me.getKey()%want == 0) {
                    ans += me.getValue();
                }
            }
            map.put(common, map.getOrDefault(common, 0l)+1);
        }
        return ans;
    }

    private long gcd(int a, int b) {
        return b == 0 ? (long) a : gcd(b, a%b);
    }
}