class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        long res = 0;
        long mod = (long)1e9+7;
        int n = nums.length;
        int[] count = new int[n];
        for (int[] request: requests) {
            count[request[0]]++;
            if (request[1]+1 < n) {
                count[request[1]+1] -= 1;
            }
        }    
        for (int i = 1; i < n; i++) {
            count[i] += count[i-1];
        }
        Arrays.sort(nums);
        Arrays.sort(count);
        for (int i = 0; i < n; i++) {
            res += ((long)nums[i])*count[i];
        }

        return (int)(res%mod);
    }
}